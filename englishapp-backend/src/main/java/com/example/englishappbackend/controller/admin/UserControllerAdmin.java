package com.example.englishappbackend.controller.admin;

import com.example.englishappbackend.entity.User;
import com.example.englishappbackend.service.user.UserService;
import com.example.englishappbackend.service.word.WordService;
import com.example.englishappbackend.util.WordFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin/user")
public class UserControllerAdmin {

    @Autowired
    UserService service;

    @Autowired
    WordService wordService;

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

    @RequestMapping(method = RequestMethod.GET,path = "update-user")
    public ResponseEntity<?> updateUser(@RequestParam(name = "user-id") int user_id, @RequestBody User user){
        return new ResponseEntity<>(service.updateUser(user_id,user),HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(method = RequestMethod.GET,path = "getWords")
    public ResponseEntity<?> getWordByUserId(@RequestParam(name = "userId") int userId,
                                             @RequestParam(name = "page",defaultValue = "1") int page,
                                             @RequestParam(name = "size", defaultValue = "10") int size,
                                             @RequestParam(name = "word-name", defaultValue = "") String name){
        WordFilter filter = WordFilter.WordFilterBuilder.aWordFilter()
                .withName(name)
                .withPage(page)
                .withSize(size)
                .build();
        return new ResponseEntity<>(wordService.getWordsByUserId(userId,filter), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = "active")
    public ResponseEntity<?> activeUser(@RequestParam(name = "user-id") int userId){
        return new ResponseEntity<>(service.activeUser(userId),HttpStatus.OK);
    }

}
