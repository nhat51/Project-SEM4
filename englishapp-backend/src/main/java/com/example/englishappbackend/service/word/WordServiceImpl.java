package com.example.englishappbackend.service.word;

import com.example.englishappbackend.entity.User;
import com.example.englishappbackend.entity.Word;
import com.example.englishappbackend.repo.UserRepository;
import com.example.englishappbackend.repo.WordRepository;
import com.example.englishappbackend.specification.SearchCriteria;
import com.example.englishappbackend.specification.WordSpecification;
import com.example.englishappbackend.util.WordFilter;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    public Page<Word> getAll(WordFilter filter) {
        Specification<Word> spec = Specification.where(null);
        PageRequest pageRequest = PageRequest.of(filter.getPage() - 1, filter.getSize());
        if (filter.getName() != null && filter.getName().length() > 0){
            spec = spec.and(new WordSpecification(new SearchCriteria(WordFilter.NAME,"LIKE",filter.getName())));
        }
        return wordRepository.findAll(spec,pageRequest);
    }

    @Override
    public Page<Word> getWordsByUser(WordFilter filter) {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        PageRequest pageRequest = PageRequest.of(filter.getPage() - 1, filter.getSize());
        User user = userRepository.findByUsername(principal.getName());
        return wordRepository.findWordsByUserId(user.getId(), pageRequest);
    }

    @Override
    public Page<Word> getWordsByUserId(int userId, WordFilter filter) {
        PageRequest pageRequest = PageRequest.of(filter.getPage() - 1, filter.getSize());
        return wordRepository.findWordsByUserId(userId,pageRequest);
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

    @Override
    public Word deleteWord(int wordId) {
        return null;
    }

    @Override
    public List<Word> userSearchWord(String name) {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        User userExist = userRepository.findByUsername(principal.getName());
        Set<Word> list = userExist.getWords();
        List<Word> result = new ArrayList<>();
        for (Word w : list){
            if (w.getName().contains(name) || w.getName().equals(name)){
                result.add(w);
            }
        }
        return result;
    }

    @Override
    public List<Word> getRememberedWord() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        User userExist = userRepository.findByUsername(principal.getName());
        List<Word> result = new ArrayList<>();
        for (Word w: userExist.getWords()){
            if (w.isRemember()){
                result.add(w);
            }
        }
        return result;
    }

    @Override
    public List<Word> getWordNeedRemind() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        User userExist = userRepository.findByUsername(principal.getName());
        List<Word> result = new ArrayList<>();
        for (Word w: userExist.getWords()){
            if (!w.isRemember()){
                result.add(w);
            }
        }
        return result;
    }

    private String callThirdPartyApiSearchWord(String word) {
        final String uri = "https://api.dictionaryapi.dev/api/v2/entries/en/" + word;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }
}
