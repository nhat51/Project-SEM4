package com.example.englishappbackend.controller.admin;

import com.example.englishappbackend.service.word.WordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin/words")
public class WordControllerAdmin {

    final
    WordService wordService;

    public WordControllerAdmin(WordService wordService) {
        this.wordService = wordService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllWord(
            @RequestParam(name = "page",defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "word",defaultValue = "")String name){
        return new ResponseEntity<>(wordService.getAll(page, size,name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,path = "word-detail")
    public ResponseEntity<?> getWordDetail(@RequestParam(name = "word-id") int id){
        return new ResponseEntity<>(wordService.getWordDetail(id), HttpStatus.OK);
    }
}
