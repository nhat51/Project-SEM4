package com.example.englishappbackend.controller;

import com.example.englishappbackend.dtos.UserDto;
import com.example.englishappbackend.entity.User;
import com.example.englishappbackend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllUser(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int limit
    ){
        Page<User> listUser = service.getAllUser(page,limit);
        if (listUser.getContent().size() != 0){
            return new ResponseEntity<>(listUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET,path = "user-detail")
    public ResponseEntity<?> getUserDetail(@RequestParam(name = "user-id") int user_id){
        User user = service.userDetail(user_id);
        if (user != null){
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET,path = "save")
    public ResponseEntity<?> saveUser(@RequestBody UserDto user){
        return new ResponseEntity<>(service.saveUser(user),HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET,path = "update-user")
    public ResponseEntity<?> updateUser(@RequestParam(name = "user-id") int user_id, @RequestBody User user){
        return new ResponseEntity<>(service.updateUser(user_id,user),HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET,path = "receive-device-token")
    public ResponseEntity<?> receiveToken(
            @RequestHeader(name = "device-token") String token,
            @RequestHeader(name = "user-id") int user_id){
        return new ResponseEntity<>(service.getToken(user_id,token),HttpStatus.BAD_REQUEST);
    }

}
