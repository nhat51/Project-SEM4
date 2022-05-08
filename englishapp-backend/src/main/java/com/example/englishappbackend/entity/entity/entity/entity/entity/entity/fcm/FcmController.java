package com.example.englishappbackend.entity.entity.entity.entity.entity.entity.fcm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/notification")
public class FcmController {

    @Autowired
    FcmService service;

    @RequestMapping(method = RequestMethod.POST,path = "/send")
    public String sendSampleNotification(@RequestBody PnsRequest pnsRequest){
        return service.pushNotification(pnsRequest);
    }
}
