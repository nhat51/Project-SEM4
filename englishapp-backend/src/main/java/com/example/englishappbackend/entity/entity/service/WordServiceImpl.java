package com.example.englishappbackend.entity.entity.service;

import com.example.englishappbackend.entity.entity.entity.Word;
import com.example.englishappbackend.entity.entity.repo.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WordServiceImpl implements WordService {

    @Autowired
    WordRepository wordRepository;

    @Override
    public List<Word> getAll() {
        return wordRepository.findAll();
    }

    @Override
    public List<Word> getWordsByUser(int userId) {
        return wordRepository.findWordsByUser_id(userId);
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
            wordExist.setCategory_type(word.getCategory_type());
            wordExist.setPart_of_speech(word.getPart_of_speech());
            wordExist.setPronounce(word.getPronounce());
            wordExist.setContent(word.getContent());
        }
        return wordRepository.save(wordExist);
    }
}
