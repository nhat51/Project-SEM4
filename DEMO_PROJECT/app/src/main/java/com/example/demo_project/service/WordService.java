package com.example.demo_project.service;

import com.example.demo_project.entity.Word;
import com.example.demo_project.entity.WordResponse;
import com.example.demo_project.entity.WordsByUserResponse;

import java.util.List;
import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WordService {
    @POST("api/v1/user/words/save")
    Call<Word> addNewWord(@Body Word newWord);

    @GET("api/v1/user/words/word-detail")
    Call<Word> getWordDetail(@Query("word-id") int wordId);

    @GET("api/v1/user/words/user-word")
    Call<WordsByUserResponse> getWordsByUser(@Query("page") Integer page, @Query("size") Integer limit);

    @GET("api/v1/user/words/word-remember")
    Call<List<Word>> getRememberedWord();

    @GET("api/v1/user/words/word-remind")
    Call<List<Word>> getRemindWord();

//    @GET("api/v1/user/words/word-search")
//    Call<WordsByUserResponse> findWordByUser();

}
