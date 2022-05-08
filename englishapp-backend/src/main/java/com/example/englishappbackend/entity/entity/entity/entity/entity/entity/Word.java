package com.example.englishappbackend.entity.entity.entity.entity.entity.entity;

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
public class Word extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String content;
    private String pronounce;
    private String part_of_speech;
    @JoinColumn(name = "user_id")
    private int user_id;
    private LocalDate last_remind;
    private int success_time;
    private int category_type;

    @ManyToOne
    @JoinColumn(name = "user_id",updatable = false,insertable = false)
    @JsonIgnore
    User user;

}
