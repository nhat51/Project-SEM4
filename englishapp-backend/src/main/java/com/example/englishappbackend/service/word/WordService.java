package com.example.englishappbackend.service.word;

import com.example.englishappbackend.entity.Word;
import org.springframework.data.domain.Page;

public interface WordService {
    Page<Word> getAll(int page, int size, String name);
    Page<Word> getWordsByUser(int page, int size);
    Page<Word> getWordsByUserId(int userId,int page, int size);
    Word getWordDetail(int wordId);
    Word createWord(Word word);
    Word updateWord(int wordId,Word word);

}
