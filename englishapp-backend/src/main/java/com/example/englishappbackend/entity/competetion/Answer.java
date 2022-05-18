package com.example.englishappbackend.entity.competetion;

import com.example.englishappbackend.entity.BaseEntity;
import com.example.englishappbackend.entity.competetion.Question;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "answers")
public class Answer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private boolean isRightAnswer;
    @Column(name = "question_id")
    private int questionId;

    @ManyToOne
    @JoinColumn(name = "question_id",insertable = false,updatable = false)
    @JsonBackReference
    private Question question;
}
