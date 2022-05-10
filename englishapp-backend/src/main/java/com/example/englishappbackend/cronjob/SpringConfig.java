package com.example.englishappbackend.cronjob;

import com.example.englishappbackend.entity.Word;
import com.example.englishappbackend.fcm.FcmService;
import com.example.englishappbackend.fcm.NotifyBody;
import com.example.englishappbackend.fcm.PnsRequest;
import com.example.englishappbackend.repo.WordRepository;
import com.google.gson.Gson;
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

    @Autowired
    FcmService fcmService;

    @Scheduled(fixedDelay = 1000*10)
    public void scheduleFixedDelayTask() {
        List<Word> list = wordRepository.findAll();
        for (Word w : list) {
            /*
            * Lấy ra ngày hiện tại và ngày cuối cùng nhắc nhở để tính
            * */
            System.out.println(w.getLast_remind());
            System.out.println(Calendar.getInstance().getTime());
            System.out.println(DAYS.between(w.getLast_remind(), LocalDate.now()));


            if (DAYS.between(w.getLast_remind(), LocalDate.now()) == 2){
                System.out.println("Gửi nhắc nhở");
                PnsRequest messageData = new PnsRequest();
                messageData.setTitle("Từ mới cho hôm nay nè");
                messageData.setFcmToken("dUnE2PHoR8CA3jl8jbPwWG:APA91bELVKOMHVu0A-J2HIh9SFL3T9gLqV9QvnX9IEIhPlFC-LrFWPLP0cQ0tjiASwc4VTfvzuB_IvGLhSLVz8L7HueHg6R38bNKYGFEOL-CDqqRKOzRkORtiFHFzCne3R20ImnuXih7");
                messageData.setContent(convertWordToMessage(w));
                fcmService.pushNotification(messageData);
            }
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

    public NotifyBody convertWordToMessage(Word word){
        NotifyBody notifyBody = new NotifyBody();
        notifyBody.setId(word.getId());
        notifyBody.setName(word.getName());
        notifyBody.setMeaning(word.getContent());
        return notifyBody;
    }
}
