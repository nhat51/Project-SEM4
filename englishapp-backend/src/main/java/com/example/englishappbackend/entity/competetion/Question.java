package com.example.englishappbackend.entity.competetion;

import com.example.englishappbackend.entity.BaseEntity;
import com.example.englishappbackend.enums.QuestionType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "questions")
public class Question extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private QuestionType questionType;
    @Column(name = "competition_id")
    private int competitionId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "competition_id",updatable = false,insertable = false)
    private Competition competition;

    @OneToMany(mappedBy = "question")
    @JsonManagedReference
    private Set<Answer> answers;
}
