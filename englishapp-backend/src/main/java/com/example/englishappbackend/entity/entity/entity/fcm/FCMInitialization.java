package com.example.englishappbackend.entity.entity.entity.fcm;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Log4j2
public class FCMInitialization {

    @Bean
    FirebaseMessaging firebaseMessaging()  throws IOException {
        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new ClassPathResource("firebase-service-account.json").getInputStream());
        FirebaseOptions firebaseOptions = FirebaseOptions
                .builder()
                .setCredentials(googleCredentials)
                .build();
        if  (FirebaseApp.getApps().isEmpty()) { //<--- check with this line
            FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions);
            return FirebaseMessaging.getInstance(app);
        }else {
            return FirebaseMessaging.getInstance();
        }
    }
}
