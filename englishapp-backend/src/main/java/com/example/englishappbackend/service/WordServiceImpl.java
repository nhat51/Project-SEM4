package com.example.englishappbackend.service;

import com.example.englishappbackend.entity.User;
import com.example.englishappbackend.entity.Word;
import com.example.englishappbackend.repo.UserRepository;
import com.example.englishappbackend.repo.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService{

    @Autowired
    WordRepository wordRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Word> getAll() {
        return wordRepository.findAll();
    }

    @Override
    public List<Word> getWordsByUser(int userId) {
       Optional<User> user = userRepository.findById(userId);
       if (user.isPresent()){
           List<Word> list = new ArrayList<>(user.get().getWords());
           return list;
       }
        return null;
    }

    @Override
    public Word getWordDetail(int wordId) {
        return wordRepository.getById(wordId);
    }

    @Override
    public Word createWord(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public Word updateWord(int wordId, Word word) {
        Word wordExist = wordRepository.getById(wordId);
        if (wordExist != null){
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
}
