package com.example.englishappbackend.fcm;

import com.example.englishappbackend.entity.User;
import com.example.englishappbackend.repo.UserRepository;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class FcmService {

    private final FirebaseMessaging firebaseMessaging;

    @Autowired
    UserRepository userRepository;

    public FcmService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }

    public String pushNotification(PnsRequest pnsRequest){
        String content = pnsRequest.getContent().getMessageContent();
        Notification notification = Notification
                .builder()
                .setImage(pnsRequest.getContent().getImageUrl())
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

    public String getDeviceToken(int userId,String deviceToken){
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()){
            user.get().setUserDeviceToken(deviceToken);
            userRepository.save(user.get());
            return deviceToken;
        }
        return "";
    }
}
