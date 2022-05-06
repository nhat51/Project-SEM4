package com.example.englishappbackend.seeding;

import com.example.englishappbackend.entity.Word;
import com.example.englishappbackend.repo.WordRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;

@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    WordRepository wordRepository;

    @Override
    public void run(String... args) throws Exception {
        if (wordRepository.count() == 0) {
            Faker faker = new Faker();
            wordRepository.save(new Word(1
                    , faker.harryPotter().location()
                    , faker.harryPotter().quote()
                    , "prounce 1"
                    , "Noun"
                    , 1
                    , yesterday()
                    , 1
                    , 1
            ));
            wordRepository.save(new Word(2
                    , faker.harryPotter().location()
                    , faker.harryPotter().quote()
                    , "prounce 2"
                    , "Noun"
                    , 1
                    , yesterday()
                    , 1
                    , 1
            ));
            wordRepository.save(new Word(3
                    , faker.harryPotter().location()
                    , faker.harryPotter().quote()
                    , "prounce 1"
                    , "Noun"
                    , 1
                    , yesterday()
                    , 1
                    , 1
            ));
            wordRepository.save(new Word(4
                    , faker.harryPotter().location()
                    , faker.harryPotter().quote()
                    , "prounce 1"
                    , "Noun"
                    , 1
                    , yesterday()
                    , 1
                    , 1
            ));
            wordRepository.save(new Word(5
                    , faker.harryPotter().location()
                    , faker.harryPotter().quote()
                    , "prounce 1"
                    , "Noun"
                    , 1
                    , yesterday()
                    , 1
                    , 1
            ));
            wordRepository.save(new Word(6
                    , faker.harryPotter().location()
                    , faker.harryPotter().quote()
                    , "prounce 1"
                    , "Noun"
                    , 1
                    , yesterday()
                    , 1
                    , 1
            ));
        }
    }

    private LocalDate yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return LocalDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault()).toLocalDate();
    }
}
