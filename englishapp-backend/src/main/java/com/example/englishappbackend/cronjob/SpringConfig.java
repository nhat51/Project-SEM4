package com.example.englishappbackend.cronjob;

import com.example.englishappbackend.entity.User;
import com.example.englishappbackend.entity.Word;
import com.example.englishappbackend.enums.WordCategory;
import com.example.englishappbackend.fcm.FcmService;
import com.example.englishappbackend.fcm.NotifyBody;
import com.example.englishappbackend.fcm.PnsRequest;
import com.example.englishappbackend.repo.UserRepository;
import com.example.englishappbackend.repo.WordRepository;
import com.example.englishappbackend.util.HandleTime;
import com.example.englishappbackend.util.WordSuccessTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

@Configuration
@EnableScheduling
public class SpringConfig {

    @Autowired
    WordRepository wordRepository;

    @Autowired
    FcmService fcmService;

    @Autowired
    UserRepository userRepository;

    private Map<User, List<Word>> listMap;

    @Scheduled(fixedDelay = 1000*30)
    public void scheduleFixedDelayTask() {
        HandleTime handleTime = new HandleTime();
        Date date = new Date();
        long currentTime = handleTime.calculateTimeToLong(date.getHours(), date.getMinutes());
        List<User> userList = userRepository.findAll();
        for (User u : userList) {
            if (currentTime >= u.getStartRemindTime() && currentTime <= u.getEndRemindTime()){
                for (Word w : u.getWords()) {
                    System.out.println("Gửi notify");
                    wordControl(w,u.getUserDeviceToken());
                }
            }
        }

    }
    /*
    *Gửi notify và chuyển word category cho từng từ
    * */
    public void wordControl(Word word,String deviceToken){
        if (DAYS.between(word.getLastRemind(), LocalDate.now()) == WordCategory.ONCE_A_DAY.getValue()){
            pushNotify(word, deviceToken);
            if (word.getSuccessTime() == WordSuccessTime.THIRD_TIME){
                word.setSuccessTime(WordSuccessTime.ZERO);
                word.setCategoryType(WordCategory.ONCE_EVERY_THREE_DAY);
                wordRepository.save(word);
            }
        }
        if (DAYS.between(word.getLastRemind(), LocalDate.now()) == WordCategory.ONCE_EVERY_THREE_DAY.getValue()){
            pushNotify(word, deviceToken);
            if (word.getSuccessTime() == WordSuccessTime.THIRD_TIME){
                word.setSuccessTime(WordSuccessTime.ZERO);
                word.setCategoryType(WordCategory.ONCE_EVERY_SEVEN_DAY);
                wordRepository.save(word);
            }
        }
        if (DAYS.between(word.getLastRemind(), LocalDate.now()) == WordCategory.ONCE_EVERY_SEVEN_DAY.getValue()){
            pushNotify(word, deviceToken);
            if (word.getSuccessTime() == WordSuccessTime.THIRD_TIME){
                word.setSuccessTime(WordSuccessTime.ZERO);
                word.setCategoryType(WordCategory.ONCE_EVERY_THIRTY_DAY);
                wordRepository.save(word);
            }
        }
        if (DAYS.between(word.getLastRemind(), LocalDate.now()) == WordCategory.ONCE_EVERY_THIRTY_DAY.getValue()){
            pushNotify(word, deviceToken);
            if (word.getSuccessTime() == WordSuccessTime.THIRD_TIME){
                /*
                 * Đoạn này gửi để cho người dùng confirm xem đã thuộc hay chưa
                 * Nếu người dùng chọn chưa thuộc thì gửi đặt lại success time và category type
                 * Rồi save từ
                 * */
                //word.setSuccessTime(WordSuccessTime.ZERO);
                //word.setCategoryType(WordCategory.ONCE_EVERY_SEVEN_DAY);
                word.setRemember(true);
                wordRepository.save(word);
            }
        }
    }

    /*
    * Gửi notify lên firebase
    * */
    private void pushNotify(Word word, String deviceToken) {
        if (word.getSuccessTime() < WordSuccessTime.THIRD_TIME){
            PnsRequest messageData = new PnsRequest();
            messageData.setTitle("Bạn có từ mới cần phải nhớ này ;)");
            messageData.setFcmToken(deviceToken);
            messageData.setContent(convertWordToMessage(word));
            fcmService.pushNotification(messageData);
            word.setSuccessTime(word.getSuccessTime() + 1);
            wordRepository.save(word);
        }
    }


    public NotifyBody convertWordToMessage(Word word){
        NotifyBody notifyBody = new NotifyBody();
        notifyBody.setId(word.getId());
        notifyBody.setName(word.getName());
        notifyBody.setMeaning(word.getContent());
        return notifyBody;
    }
}
