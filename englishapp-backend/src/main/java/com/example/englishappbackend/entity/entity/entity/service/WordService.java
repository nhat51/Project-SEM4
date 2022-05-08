package com.example.englishappbackend.entity.entity.entity.service;

import com.example.englishappbackend.entity.entity.entity.entity.Word;

import java.util.List;

public interface WordService {
    List<Word> getAll();
    List<Word> getWordsByUser(int userId);
    Word getWordDetail(int wordId);
    Word createWord(Word word);
    Word updateWord(int wordId, Word word);

}
