package com.example.englishappbackend.entity.entity.entity.entity.seeding;

import com.example.englishappbackend.entity.entity.entity.entity.entity.User;
import com.example.englishappbackend.entity.entity.entity.entity.entity.Word;
import com.example.englishappbackend.entity.entity.entity.entity.repo.UserRepository;
import com.example.englishappbackend.entity.entity.entity.entity.repo.WordRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    WordRepository wordRepository;

    @Autowired
    UserRepository userRepository;

    private final List<User> userList = new ArrayList<>();

    private final List<String> listPronounce = Arrays.asList(
            "Verb",
            "Noun",
            "Adjective",
            "Adverb"
    );

    @Override
    public void run(String... args) throws Exception {
        seedUser();
        seedWord();
    }

    private LocalDate yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return LocalDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault()).toLocalDate();
    }

    public void seedUser() {
        if (userRepository.count() == 0) {
            Faker faker = new Faker();
            for (int i = 1; i < 6; i++) {
                userList.add(userRepository.save(
                                new User(1
                                        , faker.name().username()
                                        , "123456"
                                        , faker.name().fullName()
                                        , faker.zelda().character() + "@gmail.com"
                                        , faker.phoneNumber().phoneNumber()
                                        , null
                                        , 1
                                        , 1
                                        , null)
                        )
                );
            }
        }
    }

    public void seedWord() {
        if (wordRepository.count() == 0) {
            Faker faker = new Faker();
            Random rand = new Random();
            for (User user : userList) {
                for (int i = 1; i < 6; i++) {
                    wordRepository.save(new Word(i
                            , faker.harryPotter().location()
                            , faker.harryPotter().quote()
                            , "prounce " + i
                            , listPronounce.get(rand.nextInt(listPronounce.size()))
                            , 1
                            , yesterday()
                            , 1
                            , 1
                            , user
                    ));
                }

            }
        }
    }
}
