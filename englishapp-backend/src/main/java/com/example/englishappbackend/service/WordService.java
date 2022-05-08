package com.example.englishappbackend.service;

import com.example.englishappbackend.entity.Word;

import java.util.List;

public interface WordService {
    List<Word> getAll();
    List<Word> getWordsByUser(int userId);
    Word getWordDetail(int wordId);
    Word createWord(Word word);
    Word updateWord(int wordId,Word word);

}
