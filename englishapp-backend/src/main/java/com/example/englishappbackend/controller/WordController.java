package com.example.englishappbackend.controller;

import com.example.englishappbackend.entity.Word;
import com.example.englishappbackend.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/words")
public class WordController {

    @Autowired
    WordService wordService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllWord(){
        return new ResponseEntity<>(wordService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,path = "user-word")
    public ResponseEntity<?> getWordByUser(@RequestParam(name = "user-id") int user_id){
        List<Word> wordList = wordService.getWordsByUser(user_id);
        if (wordList.size() > 0){
            return new ResponseEntity<>(wordList, HttpStatus.OK);
        }
        return new ResponseEntity<>("Bạn không có từ nào trong danh sách", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET,path = "save")
    public ResponseEntity<?> save(@RequestBody Word word){
        return new ResponseEntity<>(wordService.createWord(word), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET,path = "word-detail")
    public ResponseEntity<?> getWordDetail(@RequestParam(name = "word-id") int word_id){
        return new ResponseEntity<>(wordService.getWordDetail(word_id), HttpStatus.OK);
    }

}
