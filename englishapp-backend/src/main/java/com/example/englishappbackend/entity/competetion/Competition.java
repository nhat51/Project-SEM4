package com.example.englishappbackend.entity.competetion;

import com.example.englishappbackend.entity.BaseEntity;
import com.example.englishappbackend.enums.CompetitionStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "competitions")
public class Competition extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private CompetitionStatus status;

    @OneToMany(mappedBy = "competition")
    @JsonManagedReference
    Set<Question> questions;

    @OneToMany(mappedBy = "competition")
    @JsonManagedReference
    Set<CompetitionUser> competitionUsers;


}
