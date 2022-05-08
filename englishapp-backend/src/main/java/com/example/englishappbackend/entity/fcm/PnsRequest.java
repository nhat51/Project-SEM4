package com.example.englishappbackend.entity.fcm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PnsRequest {
    private String fcmToken;
    private Object content;
    private String title;

}
