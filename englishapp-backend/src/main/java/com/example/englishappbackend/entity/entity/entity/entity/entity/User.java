package com.example.englishappbackend.entity.entity.entity.entity.entity;

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
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password_hash;
    private String full_name;
    private String email;
    private String phone;
    private String user_device_token;
    private int role;
    private int status;

    @OneToMany(mappedBy = "user")
    Set<Word> words;

}
