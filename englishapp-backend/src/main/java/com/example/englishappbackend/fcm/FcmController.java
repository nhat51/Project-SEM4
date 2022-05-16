package com.example.englishappbackend.fcm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/notification")
public class FcmController {

    @Autowired
    FcmService service;

    @RequestMapping(method = RequestMethod.POST,path = "/send")
    public ResponseEntity<?> sendSampleNotification(@RequestBody PnsRequest pnsRequest){
        return new ResponseEntity<>(service.pushNotification(pnsRequest), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = "/get-token")
    public ResponseEntity<?> getToken(@RequestParam(name = "user-id")int userId, @RequestParam(name = "token") String token){
        return new ResponseEntity<>(service.getDeviceToken(userId,token), HttpStatus.OK);
    }

}
