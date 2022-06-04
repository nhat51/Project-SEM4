package com.example.englishappbackend.dtos;

import com.example.englishappbackend.entity.User;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private String role;
    private double startRemindTime;
    private double endRemindTime;

    public UserDto(User user){
        this.username = user.getUsername();
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.role = user.getRole();
        this.startRemindTime = user.getStartRemindTime();
        this.endRemindTime = user.getEndRemindTime();
    }
}
