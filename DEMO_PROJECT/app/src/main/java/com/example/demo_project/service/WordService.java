package com.example.demo_project.service;

import com.example.demo_project.entity.Word;
import com.example.demo_project.entity.WordResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WordService {
    @GET("api/v1/words")
    Call<WordResponse> getAll();

    @GET("api/v1/words/user-word?user_id=1")
    Call<List<Word>> getListWord();

    @POST("api/v1/words/save")
    Call<Word> addNewWord(@Body Word newWord);

    @GET("api/v1/words/word-detail?")
    Call<WordResponse> getWordDetail(@Query("word-id") int wordId);

}
