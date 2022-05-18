package com.example.englishappbackend.entity.competetion;

import com.example.englishappbackend.entity.BaseEntity;
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
@Entity(name = "question_answers")
public class QuestionAnswer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "competition_user_id")
    private int competitionUserId;
    @Column(name = "question_id")
    private int questionId;
    @Column(name = "answer_id")
    private int answerId;
    private boolean isRightAnswer;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "competition_user_id",insertable = false,updatable = false)
    private CompetitionUser competitionUser;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "question_id",insertable = false,updatable = false)
    private Question question;

    @OneToOne
    @JoinColumn(name = "answer_id",insertable = false,updatable = false)
    private Answer answer;

}
