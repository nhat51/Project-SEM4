package com.example.englishappbackend.entity.entity.fcm;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;


@Service
public class FcmService {

    private final FirebaseMessaging firebaseMessaging;

    public FcmService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }

    public String pushNotification(PnsRequest pnsRequest){
        String content = new Gson().toJson(pnsRequest.getContent());
        Notification notification = Notification
                .builder()
                .setTitle(pnsRequest.getTitle())
                .setBody(content)
                .build();
        Message message = Message.builder()
                .setToken(pnsRequest.getFcmToken())
                .putData("text",content)
                .setNotification(notification)
                .putData("title", pnsRequest.getTitle())
                .build();
        System.out.println(new Gson().toJson(message));
        String response = null;
        try {
            response = firebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
        return response;
    }
}
