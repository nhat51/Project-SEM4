package com.example.demo_project.service;

import com.example.demo_project.entity.Word;
import com.example.demo_project.entity.WordsByUserResponse;
import com.example.demo_project.util.RetrofitGenerator;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class WordServiceTest {

    WordService wordService;
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0b3JhdTk4NTYiLCJyb2xlcyI6WyJST0xFX1VTRVIiXSwiaXNzIjoiaHR0cHM6Ly9oZWxsby1lbmdsaXNoLXQyMDA0ZS5oZXJva3VhcHAuY29tL2FwaS92MS91c2Vycy9sb2dpbiIsImV4cCI6MTY1NTIwNzQ0OH0.rNvfZFOcXcSLgJ52lqwr5PUqakLw_CveaygpkgQBhrM";

    @Before
    public void setUp() {
        wordService = RetrofitGenerator.createService(WordService.class, token);
    }

    @Test
    public void test() {
        Call<WordsByUserResponse> wordsByUserResponseCall =wordService.getWordsByUser(1, 2);
        try {
             Response<WordsByUserResponse> wordsByUserResponse = wordsByUserResponseCall.execute();
             if(wordsByUserResponse.isSuccessful()){
                 WordsByUserResponse userWordResponse = wordsByUserResponse.body();
                 List<Word> words = userWordResponse.getContent();
                 for (Word word :
                         words) {
                     System.out.println(word.getId());
                     System.out.println(word.getContent());
                     System.out.println(word.getName());
                 }
             }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Got Error.");
        }

    }
}