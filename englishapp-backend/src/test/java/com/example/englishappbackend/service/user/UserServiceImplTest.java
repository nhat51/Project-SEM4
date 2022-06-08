package com.example.englishappbackend.service.user;

import com.example.englishappbackend.entity.User;
import com.example.englishappbackend.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void test(){
        User account = new User("user01",
                bCryptPasswordEncoder.encode("user01"),
                "ROLE_USER");
        userRepository.save(account);
        System.out.println("Action success!");
    }

}