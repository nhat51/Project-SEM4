package com.example.englishappbackend.entity;

import com.example.englishappbackend.enums.WordCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "words")
public class Word extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String content;
    private String pronounce;
    private String partOfSpeech;
    private String example;
    private String translatedExample;
    private LocalDate lastRemind;
    private int successTime;
    private WordCategory categoryType;
    private boolean isRemember;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    User user;

}
