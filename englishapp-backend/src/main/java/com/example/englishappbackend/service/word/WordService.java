package com.example.englishappbackend.service.word;

import com.example.englishappbackend.entity.Word;
import com.example.englishappbackend.util.WordFilter;
import org.springframework.data.domain.Page;

import java.util.List;

public interface WordService {
    Page<Word> getAll(WordFilter filter);
    Page<Word> getWordsByUser(WordFilter filter);
    Page<Word> getWordsByUserId(int userId,WordFilter filter);
    Word getWordDetail(int wordId);
    Word createWord(Word word);
    Word updateWord(int wordId,Word word);
    Word deleteWord(int wordId);
    List<Word> userSearchWord(String name);
    List<Word> getRememberedWord();
    List<Word> getWordNeedRemind();
}
