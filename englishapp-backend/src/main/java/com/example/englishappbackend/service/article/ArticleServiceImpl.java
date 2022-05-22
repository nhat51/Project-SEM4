package com.example.englishappbackend.service.article;

import com.example.englishappbackend.entity.Article;
import com.example.englishappbackend.enums.ArticleStatus;
import com.example.englishappbackend.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Page<Article> getAll(int page, int limit) {
        PageRequest paging = PageRequest.of(page - 1, limit);
        return articleRepository.findAll(paging);
    }

    @Override
    public Article getDetail(int articleId) {
        return articleRepository.findById(articleId).orElse(null);
    }

    @Override
    public Article update(int articleId, Article article) {
        Optional<Article> exist = articleRepository.findById(articleId);
        if (exist.isPresent()){
            exist.get().setTitle(article.getTitle());
            exist.get().setStatus(article.getStatus());
            exist.get().setDescription(article.getDescription());
            exist.get().setContent(article.getContent());
            exist.get().setUpdatedAt(LocalDateTime.now());
            return articleRepository.save(exist.get());
        }
       return null;
    }

    @Override
    public Article delete(int articleId) {
        Optional<Article> exist = articleRepository.findById(articleId);
        if (exist.isPresent()){
            exist.get().setStatus(ArticleStatus.DELETED);
            return articleRepository.save(exist.get());
        }
        return null;
    }
}
