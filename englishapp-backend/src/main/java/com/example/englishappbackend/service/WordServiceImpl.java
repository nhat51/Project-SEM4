package com.example.englishappbackend.service;

import com.example.englishappbackend.entity.User;
import com.example.englishappbackend.entity.Word;
import com.example.englishappbackend.repo.UserRepository;
import com.example.englishappbackend.repo.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService{

    final
    WordRepository wordRepository;

    final
    UserRepository userRepository;

    public WordServiceImpl(WordRepository wordRepository, UserRepository userRepository) {
        this.wordRepository = wordRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Page<Word> getAll(int page, int size) {
        PageRequest paging = PageRequest.of(page - 1,size);
        return wordRepository.findAll(paging);
    }

    @Override
    public Page<Word> getWordsByUser(int userId, int page, int size) {
        PageRequest paging = PageRequest.of(page - 1,size);
        return wordRepository.findWordsByUser_id(userId,paging);
    }

    @Override
    public Word getWordDetail(int wordId) {
        Optional<Word> word = wordRepository.findById(wordId);
        if (word.isPresent()){
            return word.get();
        }
        return null;
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
