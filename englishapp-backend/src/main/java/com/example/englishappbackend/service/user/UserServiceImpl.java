package com.example.englishappbackend.service.user;

import com.example.englishappbackend.dtos.UserDto;
import com.example.englishappbackend.entity.User;
import com.example.englishappbackend.exception.RequestValidException;
import com.example.englishappbackend.repo.UserRepository;
import com.example.englishappbackend.util.HandleTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    final
    UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Page<User> getAllUser(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return userRepository.findAll(pageRequest);
    }

    @Override
    public User userDetail(int user_id) {
        Optional<User> user = userRepository.findById(user_id);
        return user.orElse(null);
    }

    @Override
    public UserDto saveUser(UserDto user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RequestValidException("Username already exists! Please choose another username.");
        }
        User account = new User(user.getUsername(),
                bCryptPasswordEncoder.encode(user.getPassword()),
                "user");
        account.setRole("ROLE_USER");
        userRepository.save(account);
        return new UserDto(account);
    }

    @Override
    public User updateUser(int user_id, User user) {
        Optional<User> userExist = userRepository.findById(user_id);
        if (userExist.isPresent()){
            userExist.get().setEmail(user.getEmail());
            userExist.get().setPhone(user.getPhone());
            userExist.get().setFullName(user.getFullName());
            return userRepository.save(userExist.get());
        }
        return null;
    }

    @Override
    public User getToken(String token  ) {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(principal.getName());
        user.setUserDeviceToken(token);
        return userRepository.save(user);
    }

    @Override
    public User setRemindTime(String startRemindTime,String endRemindTime) {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(principal.getName());
        HandleTime handleTime = new HandleTime();
        long start = handleTime.convertStringToLong(startRemindTime);
        long end = handleTime.convertStringToLong(endRemindTime);
        user.setStartRemindTime(start);
        user.setEndRemindTime(end);
        userRepository.save(user);
        return user;
    }
}
