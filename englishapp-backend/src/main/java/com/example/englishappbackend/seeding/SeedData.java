package com.example.englishappbackend.seeding;

import com.example.englishappbackend.entity.User;
import com.example.englishappbackend.entity.Word;
import com.example.englishappbackend.enums.WordCategory;
import com.example.englishappbackend.repo.UserRepository;
import com.example.englishappbackend.repo.WordRepository;
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
            Random rand = new Random();
            for (int i = 1; i < 11; i++) {
                userRepository.save(
                        new User(i
                                , faker.name().username()
                                , "123456"
                                , faker.name().fullName()
                                , faker.zelda().character() + "@gmail.com"
                                , faker.phoneNumber().phoneNumber()
                                , null
                                , 1
                                , 1
                                , rand.nextInt(24)
                                , rand.nextInt(24)
                                ,null )
                );

            }
        }
    }

    public void seedWord() {
        if (wordRepository.count() == 0) {
            Faker faker = new Faker();
            Random rand = new Random();
            List<User> userList = userRepository.findAll();
            for (int j = 0; j < userList.size(); j++){
                User user = userList.get(j);
                Set<Word> wordSet = new HashSet<>();
                for (int i = 1; i < 6; i++) {
                    Word w = new Word();
                    w.setName(faker.harryPotter().location());
                    w.setContent(faker.harryPotter().quote());
                    w.setPronounce("pronounce " + i);
                    w.setPart_of_speech(listPronounce.get(rand.nextInt(listPronounce.size())));
                    w.setExample(faker.shakespeare().asYouLikeItQuote());
                    w.setTranslated_example(faker.shakespeare().asYouLikeItQuote());
                    w.setLast_remind(yesterday());
                    w.setCategory_type(WordCategory.ONCE_EVERY_THREE_DAY);
                    w.setSuccess_time(1);
                    w.setUser(user);
                    wordSet.add(w);
                    wordRepository.save(w);
                }
                user.setWords(wordSet);
                userRepository.save(user);
            }
        }
    }
}
