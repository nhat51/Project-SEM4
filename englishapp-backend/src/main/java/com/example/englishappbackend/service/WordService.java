package com.example.englishappbackend.service;

import com.example.englishappbackend.entity.Word;
import org.springframework.data.domain.Page;

import java.util.List;

public interface WordService {
    Page<Word> getAll(int page, int size);
    Page<Word> getWordsByUser(int userId, int page, int size);
    Word getWordDetail(int wordId);
    Word createWord(Word word);
    Word updateWord(int wordId,Word word);

}
