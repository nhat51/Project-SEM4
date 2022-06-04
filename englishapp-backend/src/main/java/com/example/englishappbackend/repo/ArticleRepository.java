package com.example.englishappbackend.repo;

import com.example.englishappbackend.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
