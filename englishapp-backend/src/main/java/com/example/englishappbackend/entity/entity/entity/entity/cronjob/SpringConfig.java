package com.example.englishappbackend.entity.entity.entity.entity.cronjob;

import com.example.englishappbackend.entity.entity.entity.entity.entity.Word;
import com.example.englishappbackend.entity.entity.entity.entity.repo.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoUnit.DAYS;

@Configuration
@EnableScheduling
public class SpringConfig {

    @Autowired
    WordRepository wordRepository;

    @Scheduled(fixedDelay = 1000*60)
    public void scheduleFixedDelayTask() {
        List<Word> list = wordRepository.findAll();
        for (Word w : list) {
            /*if (getDifferentDay(new Date(),w.getLast_remind()) == 1){
                System.out.println(w.getName());
            }*/
            System.out.println(w.getLast_remind());
            System.out.println(Calendar.getInstance().getTime());
            System.out.println(DAYS.between(w.getLast_remind(), LocalDate.now()));
            if (DAYS.between(w.getLast_remind(), LocalDate.now()) == 7){
                System.out.println("Gửi nhắc nhở");
            }
//            System.out.println(Duration.between(w.getLast_remind(), LocalDate.now()).toDays());
//            System.out.println(Duration.between(w.getLast_remind(), LocalDate.now()).toHours());
            // System.out.println(Calendar.getInstance().getTime() - w.getLast_remind());
        }


    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse("04/22/2020");
        Date secondDate = sdf.parse("04/27/2020");

        long diff = secondDate.getTime() - firstDate.getTime();

        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        System.out.println("The difference in days is : "+diffrence);
    }

    public long getDifferentDay(Date d1, Date d2){
        long diff = d1.getTime() - d2.getTime();

        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        return diff;
    }
}
