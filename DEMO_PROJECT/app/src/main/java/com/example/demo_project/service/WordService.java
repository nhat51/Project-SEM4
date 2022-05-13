package com.example.demo_project.service;

import com.example.demo_project.entity.Word;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WordService {
    @GET("api/v1/words")
    Call<List<Word>> getAll();

    @GET("api/v1/words/user-word?user_id=1")
    Call<List<Word>> getListWord();


}
