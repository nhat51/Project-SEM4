package com.example.englishappbackend.entity;

import com.example.englishappbackend.entity.competetion.CompetitionUser;
import com.example.englishappbackend.enums.UserStatus;
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
@Entity(name = "users")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String passwordHash;
    private String fullName;
    private String email;
    private String phone;
    private String userDeviceToken;
    private int role;
    @Enumerated(EnumType.ORDINAL)
    private UserStatus status;
    private double startRemindTime;
    private double endRemindTime;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    Set<Word> words;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    Set<CompetitionUser> competitionUsers;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    Set<Transaction> transactions;
}
