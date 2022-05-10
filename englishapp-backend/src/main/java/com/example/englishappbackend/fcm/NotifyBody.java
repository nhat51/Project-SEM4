package com.example.englishappbackend.fcm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotifyBody {
    private int id;
    private String name;
    private String meaning;
    private String imageUrl;
    public String getMessageContent(){
        return String.format("%s : %s",this.name,this.meaning);
    }
}
