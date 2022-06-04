package com.example.demo_project.service;

import com.example.demo_project.entity.Article;
import com.example.demo_project.entity.ArticleResponse;
import com.example.demo_project.entity.Word;
import com.example.demo_project.entity.WordResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArticleService {
    @GET("api/v1/articles")
    Call<ArticleResponse> getAllArticle();

    @GET("api/v1/article/article-detail?")
    Call<Article> getArticleDetail(@Query("article-id") int articleId);
}
