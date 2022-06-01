package com.example.englishappbackend.controller;

import com.example.englishappbackend.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/articles")
@CrossOrigin("*")
public class ArticleController {

    final ArticleService articleService;

    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        return new ResponseEntity<>(articleService.getAll(page, size), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "detail")
    public ResponseEntity<?> getDetail(@RequestParam(name = "articleId") int id){
        return new ResponseEntity<>(articleService.getDetail(id),HttpStatus.OK);
    }
}
