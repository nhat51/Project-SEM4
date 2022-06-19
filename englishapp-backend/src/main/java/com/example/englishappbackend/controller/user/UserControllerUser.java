package com.example.englishappbackend.controller.user;

import com.example.englishappbackend.dtos.UserDto;
import com.example.englishappbackend.entity.User;
import com.example.englishappbackend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user/users")
public class UserControllerUser {

    @Autowired
    UserService service;

    @RequestMapping(method = RequestMethod.GET,path = "user-detail")
    public ResponseEntity<?> getUserDetail(@RequestParam(name = "user-id") int user_id){
        User user = service.userDetail(user_id);
        if (user != null){
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.POST,path = "save")
    public ResponseEntity<?> saveUser(@RequestBody UserDto user){
        return new ResponseEntity<>(service.saveUser(user),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,path = "update-user")
    public ResponseEntity<?> updateUser(@RequestParam(name = "user-id") int user_id, @RequestBody User user){
        return new ResponseEntity<>(service.updateUser(user_id,user),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,path = "receive-device-token")
    public ResponseEntity<?> receiveToken(
            @RequestParam(name = "device-token") String token){
        return new ResponseEntity<>(service.getToken(token),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "setRemindTime")
    public ResponseEntity<?> setRemindTime(@RequestParam(name = "startTime") String start,
                                           @RequestParam(name = "endTime") String end){
        return new ResponseEntity<>(service.setRemindTime(start,end),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "get-profile")
    public ResponseEntity<?> getProfile(){
        return new ResponseEntity<>(service.getProfile(),HttpStatus.OK);
    }
}
