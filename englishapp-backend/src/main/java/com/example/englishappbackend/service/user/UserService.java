package com.example.englishappbackend.service.user;

import com.example.englishappbackend.dtos.UserDto;
import com.example.englishappbackend.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<User> getAllUser(int page,int size);
    User userDetail(int user_id);
    User activeUser(int userId);
    UserDto saveUser(UserDto user);
    User updateUser(int user_id, User user);
    User getToken(String token);
    User setRemindTime(String startRemindTime, String endRemindTime);
    User getProfile();
}
