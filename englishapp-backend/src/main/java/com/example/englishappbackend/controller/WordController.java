package com.example.englishappbackend.controller;

import com.example.englishappbackend.entity.Word;
import com.example.englishappbackend.service.word.WordService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/words")
@CrossOrigin("*")
public class WordController {

    final
    WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllWord(
            @RequestParam(name = "page",defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "word",defaultValue = "")String name){
        return new ResponseEntity<>(wordService.getAll(page, size,name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,path = "user-word")
    public ResponseEntity<?> getWordByUser(@RequestParam(name = "user-id") int user_id,
                                           @RequestParam(name = "page",defaultValue = "1") int page,
                                           @RequestParam(name = "size", defaultValue = "5") int size){
        Page<Word> wordList = wordService.getWordsByUser(user_id,page,size);
        if (wordList.getContent().size() > 0){
            return new ResponseEntity<>(wordList, HttpStatus.OK);
        }
        return new ResponseEntity<>("Bạn không có từ nào trong danh sách", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.POST,path = "save")
    public ResponseEntity<?> save(@RequestBody Word word){
        return new ResponseEntity<>(wordService.createWord(word), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET,path = "word-detail")
    public ResponseEntity<?> getWordDetail(@RequestParam(name = "word-id") int id){
        return new ResponseEntity<>(wordService.getWordDetail(id), HttpStatus.OK);
    }
}
