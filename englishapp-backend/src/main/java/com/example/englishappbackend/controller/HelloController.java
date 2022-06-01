package com.example.englishappbackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/hello")
@CrossOrigin("*")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String hello(){
        return "Hello world";
    }
}
