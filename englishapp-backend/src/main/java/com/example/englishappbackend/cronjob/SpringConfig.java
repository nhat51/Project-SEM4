package com.example.englishappbackend.cronjob;

import com.example.englishappbackend.entity.Word;
import com.example.englishappbackend.enums.WordCategory;
import com.example.englishappbackend.fcm.FcmService;
import com.example.englishappbackend.fcm.NotifyBody;
import com.example.englishappbackend.fcm.PnsRequest;
import com.example.englishappbackend.repo.UserRepository;
import com.example.englishappbackend.repo.WordRepository;
import com.example.englishappbackend.util.WordSuccessTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;

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

//    @Scheduled(fixedDelay = 1000*60*60)
//    public void scheduleFixedDelayTask() {
//        List<Word> list = wordRepository.findAll();
//        for (Word w : list) {
//            User user = userRepository.getById(w.getUser().getId());
//            Date date = new Date();   // given date
//            Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
//            calendar.setTime(date);
////            if(calendar.get(Calendar.HOUR_OF_DAY) >= user.getStartRemindTime()
////                    && calendar.get(Calendar.HOUR_OF_DAY) <= user.getEndRemindTime()
////            ){
//////                wordControl(w,user.getUserDeviceToken());
////            }
//        }
//    }

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
                word.setSuccessTime(WordSuccessTime.ZERO);
                word.setCategoryType(WordCategory.ONCE_EVERY_SEVEN_DAY);

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
            messageData.setTitle("Từ mới cho hôm nay nè");
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
