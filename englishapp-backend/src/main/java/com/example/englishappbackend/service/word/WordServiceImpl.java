package com.example.englishappbackend.service.word;

import com.example.englishappbackend.entity.User;
import com.example.englishappbackend.entity.Word;
import com.example.englishappbackend.repo.UserRepository;
import com.example.englishappbackend.repo.WordRepository;
import com.example.englishappbackend.specification.SearchCriteria;
import com.example.englishappbackend.specification.WordSpecification;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {

    final
    WordRepository wordRepository;

    final
    UserRepository userRepository;

    public WordServiceImpl(WordRepository wordRepository, UserRepository userRepository) {
        this.wordRepository = wordRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Page<Word> getAll(int page, int size, String name) {
        PageRequest paging = PageRequest.of(page - 1, size);
        Specification<Word> spec =Specification.where(null);
        if (name != null){
            spec = spec.and(new WordSpecification(new SearchCriteria("name",":",name)));
        }
        return wordRepository.findAll(spec,paging);
    }

    @Override
    public Page<Word> getWordsByUser(int page, int size) {
        PageRequest paging = PageRequest.of(page - 1, size);
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(principal.getName());
        return wordRepository.findWordsByUserId(user.getId(), paging);
    }

    @Override
    public Word getWordDetail(int wordId) {
        Optional<Word> word = wordRepository.findById(wordId);
        if (word.isPresent()) {
            return word.get();
        }
        return null;
    }

    @Override
    public Word createWord(Word word) {
        String json = null;
        if (word != null) {
            json = callThirdPartyApiSearchWord(word.getName());

            JsonParser parser = new JsonParser();
            JsonArray rootObj = parser.parse(json).getAsJsonArray();

            String phonetic = null;
            for (int i = 0; i < rootObj.size(); i++) {
                JsonElement jsonElement = rootObj.get(i);
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                phonetic = jsonObject.get("phonetic").getAsString();
                word.setPronounce(phonetic);
                break;
            }
            System.out.println(phonetic);
            Principal principal = SecurityContextHolder.getContext().getAuthentication();
            User user = userRepository.findByUsername(principal.getName());
            word.setUser(user);
        }
        return wordRepository.save(word);
    }

    @Override
    public Word updateWord(int wordId, Word word) {
        Word wordExist = wordRepository.getById(wordId);
        if (wordExist != null) {
            wordExist.setName(word.getName());
            wordExist.setCategoryType(word.getCategoryType());
            wordExist.setPartOfSpeech(word.getPartOfSpeech());
            wordExist.setPronounce(word.getPronounce());
            wordExist.setContent(word.getContent());
            wordExist.setExample(word.getExample());
            wordExist.setTranslatedExample(word.getTranslatedExample());
        }
        return wordRepository.save(wordExist);
    }

    private String callThirdPartyApiSearchWord(String word) {
        final String uri = "https://api.dictionaryapi.dev/api/v2/entries/en/" + word;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }
}
