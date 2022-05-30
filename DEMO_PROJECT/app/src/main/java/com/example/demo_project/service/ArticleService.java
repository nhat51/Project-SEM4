package com.example.demo_project.service;

import com.example.demo_project.entity.ArticleResponse;
import com.example.demo_project.entity.WordResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ArticleService {
    @GET("api/v1/articles")
    Call<ArticleResponse> getAllArticle();
}
