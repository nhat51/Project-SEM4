package com.example.englishappbackend.fcm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PnsRequest {
    private String fcmToken;
    private NotifyBody content;
    private String title;


}
