package com.example.englishappbackend.service.article;

import com.example.englishappbackend.entity.Article;
import org.springframework.data.domain.Page;

public interface ArticleService {
    Page<Article> getAll(int page, int limit);
    Article getDetail(int articleId);
    Article update(int articleId, Article article);
    Article delete(int articleId);
}
