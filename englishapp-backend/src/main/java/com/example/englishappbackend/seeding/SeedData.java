package com.example.englishappbackend.seeding;

import com.example.englishappbackend.entity.User;
import com.example.englishappbackend.entity.Word;
import com.example.englishappbackend.enums.UserStatus;
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
            Set<User> userSet = new HashSet<>();

            User user1 = new User();
            user1.setId(1);
            user1.setUsername("dr.nhat");
            user1.setPasswordHash("123");
            user1.setFullName("Nguyen Quang Nhat");
            user1.setEmail("nhatngao@gmail.com");
            user1.setPhone("(84-8) 8510847");
            user1.setRole(1);
            user1.setStatus(UserStatus.ACTIVATED);
            userSet.add(user1);

            User user2 = new User();
            user2.setId(2);
            user2.setUsername("son3coc");
            user2.setPasswordHash("123");
            user2.setFullName("Dang Hoang Son");
            user2.setEmail("nhaude@gmail.com");
            user2.setPhone("(84-8) 8323791");
            user2.setRole(1);
            user2.setStatus(UserStatus.ACTIVATED);
            userSet.add(user2);

            User user3 = new User();
            user3.setId(3);
            user3.setUsername("Christian.Le");
            user3.setPasswordHash("123");
            user3.setFullName("Christian Le");
            user3.setEmail("sorryallday@gmail.com");
            user3.setPhone("(84-4) 39 283 977");
            user3.setRole(1);
            user3.setStatus(UserStatus.ACTIVATED);
            userSet.add(user3);

            User user4 = new User();
            user4.setId(4);
            user4.setUsername("hong.ne");
            user4.setPasswordHash("123");
            user4.setFullName("Nguyen Thi Hong");
            user4.setEmail("goilaiemhong@gmail.com");
            user4.setPhone("(84-8) 39 570 522");
            user4.setRole(1);
            user4.setStatus(UserStatus.ACTIVATED);
            userSet.add(user4);

            User user5 = new User();
            user5.setId(5);
            user5.setUsername("chinhnguyen321");
            user5.setPasswordHash("123");
            user5.setFullName("Nguyen Duc Chinh");
            user5.setEmail("nguyenducchinhhhhhh@gmail.com");
            user5.setPhone("(84-8) 38 439 697");
            user5.setRole(1);
            user5.setStatus(UserStatus.ACTIVATED);
            userSet.add(user5);

            User user6 = new User();
            user6.setId(6);
            user6.setUsername("nhituyetle129");
            user6.setPasswordHash("123");
            user6.setFullName("Le Tuyet Nhi");
            user6.setEmail("tuyetnhi635465@gmail.com");
            user6.setPhone("84-0-983682958");
            user6.setRole(1);
            user6.setStatus(UserStatus.ACTIVATED);
            userSet.add(user6);

            User user7 = new User();
            user7.setId(7);
            user7.setUsername("luonCaoBang");
            user7.setPasswordHash("123");
            user7.setFullName("Phung Thanh Do");
            user7.setEmail("vohatxihoicungso@gmail.com");
            user7.setPhone("(84-64) 3 851 922");
            user7.setRole(1);
            user7.setStatus(UserStatus.ACTIVATED);
            userSet.add(user7);

            User user8 = new User();
            user8.setId(8);
            user8.setUsername("torau9856");
            user8.setPasswordHash("123");
            user8.setFullName("Truong Tue Chau");
            user8.setEmail("trauhoncun12093@gmail.com");
            user8.setPhone("(650) 3658414 ");
            user8.setRole(1);
            user8.setStatus(UserStatus.ACTIVATED);
            userSet.add(user8);

            User user9 = new User();
            user9.setId(9);
            user9.setUsername("anculaunam879");
            user9.setPasswordHash("123");
            user9.setFullName("Phong Thanh Duong");
            user9.setEmail("detuDCCC@gmail.com");
            user9.setPhone("04. 3 7 951 711");
            user9.setRole(1);
            user9.setStatus(UserStatus.ACTIVATED);
            userSet.add(user9);

            User user10 = new User();
            user10.setId(10);
            user10.setUsername("cmcmcmcmcm710");
            user10.setPasswordHash("123");
            user10.setFullName("Cristiano Messi");
            user10.setEmail("cm710@gmail.com");
            user10.setPhone("(08) 38350961");
            user10.setRole(1);
            user10.setStatus(UserStatus.ACTIVATED);
            userSet.add(user10);

            userRepository.saveAll(userSet);
        }
    }

    public void seedWord() {
//        if (wordRepository.count() == 0) {
//            Faker faker = new Faker();
//            Random rand = new Random();
//            List<User> userList = userRepository.findAll();
//            for (int j = 0; j < userList.size(); j++){
//                User user = userList.get(j);
//                Set<Word> wordSet = new HashSet<>();
//                for (int i = 1; i < 6; i++) {
//                    Word w = new Word();
//                    w.setName(faker.harryPotter().location());
//                    w.setContent(faker.harryPotter().quote());
//                    w.setPronounce("pronounce " + i);
//                    w.setPartOfSpeech(listPronounce.get(rand.nextInt(listPronounce.size())));
//                    w.setExample(faker.shakespeare().asYouLikeItQuote());
//                    w.setTranslatedExample(faker.shakespeare().asYouLikeItQuote());
//                    w.setLastRemind(yesterday());
//                    w.setCategoryType(WordCategory.ONCE_EVERY_THREE_DAY);
//                    w.setSuccessTime(1);
//                    w.setUser(user);
//                    wordSet.add(w);
//                    wordRepository.save(w);
//                }
//                user.setWords(wordSet);
//                userRepository.save(user);
//            }
//        }
        if (wordRepository.count() == 0) {
            List<User> listUser = userRepository.findAll();
            Set<Word> wordSet = new HashSet<>();

            Word word1 = new Word();
            word1.setId(51);
            word1.setName("abdomen");
            word1.setContent("bụng");
            word1.setPartOfSpeech("noun");
            word1.setPronounce("/ˈæbdəmən/");
            word1.setExample("Patients reported pain in the lower chest or upper abdomen.");
            word1.setTranslatedExample("Bệnh nhân cho biết đau ở ngực dưới hoặc bụng trên.");
            word1.setUser(listUser.get(0));
            wordSet.add(word1);

            Word word2 = new Word();
            word2.setId(52);
            word2.setName("cicada");
            word2.setContent("ve sầu");
            word2.setPartOfSpeech("noun");
            word2.setPronounce("/ sɪˈkɑːdə /");
            word2.setExample("Cicadas buzzed in the heat of the day.");
            word2.setTranslatedExample("Tiếng ve kêu râm ran trong ngày nắng nóng.");
            word2.setUser(listUser.get(0));
            wordSet.add(word2);

            Word word3 = new Word();
            word3.setId(53);
            word3.setName("hatch");
            word3.setContent("nở ra");
            word3.setPartOfSpeech("verb");
            word3.setPronounce("/hætʃ/");
            word3.setExample("Ten chicks hatched (out) this morning.");
            word3.setTranslatedExample("Mười chú gà con đã nở (ra) sáng nay.");
            word3.setUser(listUser.get(0));
            wordSet.add(word3);

            Word word4 = new Word();
            word3.setId(54);
            word4.setName("cockroach");
            word4.setContent("con gián");
            word4.setPartOfSpeech("noun");
            word4.setPronounce("/ˈkɒkrəʊtʃ/");
            word4.setExample("The kitchens were discovered to be infested with cockroaches.");
            word4.setTranslatedExample("Các nhà bếp được phát hiện là bị nhiễm gián.");
            word4.setUser(listUser.get(0));
            wordSet.add(word4);

            Word word5 = new Word();
            word5.setId(55);
            word5.setName("greenfly");
            word5.setContent("ruồi xanh");
            word5.setPartOfSpeech("noun");
            word5.setPronounce("/ˈɡriːnflaɪ/");
            word5.setExample("The roses have got greenfly.");
            word5.setTranslatedExample("Hoa hồng đã có con ruồi xanh.");
            word5.setUser(listUser.get(0));
            wordSet.add(word5);

            Word word6 = new Word();
            word6.setId(56);
            word6.setName("cheat");
            word6.setContent("gian lận");
            word6.setPartOfSpeech("verb");
            word6.setPronounce("/tʃiːt/");
            word6.setExample("We will crack down on people who try to cheat the system.");
            word6.setTranslatedExample("Chúng tôi sẽ truy quét những người cố gắng gian lận hệ thống.");
            word6.setUser(listUser.get(1));
            wordSet.add(word6);

            Word word7 = new Word();
            word7.setId(57);
            word7.setName("acre ");
            word7.setContent("mẫu (Anh)");
            word7.setPartOfSpeech("noun");
            word7.setPronounce("/ˈeɪkə(r)/");
            word7.setExample("3000 acres of parkland");
            word7.setTranslatedExample("3.000 mẫu đất công viên");
            word7.setUser(listUser.get(1));
            wordSet.add(word7);

            Word word8 = new Word();
            word8.setId(58);
            word8.setName("bale");
            word8.setContent("kiện: một lượng lớn vật liệu nhẹ được ép chặt vào nhau và buộc lại");
            word8.setPartOfSpeech("noun");
            word8.setPronounce("/beɪl/");
            word8.setExample("bales of hay/straw/cotton/wool");
            word8.setTranslatedExample("kiện cỏ khô / rơm / bông / len");
            word8.setUser(listUser.get(1));
            wordSet.add(word8);

            Word word9 = new Word();
            word9.setId(59);
            word9.setName("barley");
            word9.setContent("lúa mạch ");
            word9.setPartOfSpeech("noun");
            word9.setPronounce("/ˈbɑːli/");
            word9.setExample("Malt whisky is made from malted barley.");
            word9.setTranslatedExample("Malt whisky được làm từ lúa mạch");
            word9.setUser(listUser.get(1));
            wordSet.add(word9);

            Word word10 = new Word();
            word9.setId(60);
            word10.setName("canola");
            word10.setContent("cải dầu");
            word10.setPartOfSpeech("noun");
            word10.setPronounce("/kəˈnəʊlə/");
            word10.setExample("Canola oil is low in saturated fats.");
            word10.setTranslatedExample("Dầu hạt cải có ít chất béo bão hòa.");
            word10.setUser(listUser.get(1));
            wordSet.add(word10);

            Word word11 = new Word();
            word11.setId(61);
            word11.setName("altitude");
            word11.setContent("độ cao");
            word11.setPartOfSpeech("noun");
            word11.setPronounce("/ˈæltɪtjuːd/");
            word11.setExample("The plane made a dive to a lower altitude.");
            word11.setTranslatedExample("Máy bay đã xuống độ cao thấp hơn.");
            word11.setUser(listUser.get(2));
            wordSet.add(word11);

            Word word12 = new Word();
            word12.setId(62);
            word12.setName("archipelago");
            word12.setContent("quần đảo");
            word12.setPartOfSpeech("noun");
            word12.setPronounce("/ˌɑːkɪˈpeləɡəʊ/");
            word12.setExample("the Indonesian archipelago");
            word12.setTranslatedExample("quần đảo Indonesia");
            word12.setUser(listUser.get(2));
            wordSet.add(word12);

            Word word13 = new Word();
            word13.setId(63);
            word13.setName("arid");
            word13.setContent("khô khan");
            word13.setPartOfSpeech("adjective");
            word13.setPronounce("/ˈærɪd/");
            word13.setExample("Nothing grows in these arid regions.");
            word13.setTranslatedExample("Không có gì mọc ở những vùng khô cằn này.");
            word13.setUser(listUser.get(2));
            wordSet.add(word13);

            Word word14 = new Word();
            word14.setId(64);
            word14.setName("avalanche");
            word14.setContent("tuyết lở");
            word14.setPartOfSpeech("noun");
            word14.setPronounce("/ˈævəlɑːnʃ/");
            word14.setExample("alpine villages destroyed in an avalanche");
            word14.setTranslatedExample("những ngôi làng trên núi cao bị phá hủy trong một trận tuyết lở");
            word14.setUser(listUser.get(2));
            wordSet.add(word14);

            Word word15 = new Word();
            word15.setId(65);
            word15.setName("basin");
            word15.setContent("lòng {chảo)");
            word15.setPartOfSpeech("noun");
            word15.setPronounce("/ˈbeɪsn/");
            word15.setExample("She filled the basin with warm soapy water.");
            word15.setTranslatedExample("Cô đổ đầy nước xà phòng ấm vào chậu.");
            word15.setUser(listUser.get(2));
            wordSet.add(word15);

            Word word16 = new Word();
            word16.setId(66);
            word16.setName("accommodation");
            word16.setContent("chỗ ở");
            word16.setPartOfSpeech("noun");
            word16.setPronounce("/əˌkɒməˈdeɪʃn/");
            word16.setExample("We may have to provide alternative accommodation for you.");
            word16.setTranslatedExample("Chúng tôi có thể phải cung cấp chỗ ở thay thế cho bạn.");
            word16.setUser(listUser.get(3));
            wordSet.add(word16);

            Word word17 = new Word();
            word17.setId(67);
            word17.setName("backpack");
            word17.setContent("ba lô");
            word17.setPartOfSpeech("noun");
            word17.setPronounce("/ˈbækpæk/");
            word17.setExample("He was wearing a heavy backpack.");
            word17.setTranslatedExample("Anh ta đang đeo một chiếc ba lô nặng.");
            word17.setUser(listUser.get(3));
            wordSet.add(word17);

            Word word18 = new Word();
            word18.setId(68);
            word18.setName("canal");
            word18.setContent("con kênh");
            word18.setPartOfSpeech("noun");
            word18.setPronounce("/kəˈnæl/");
            word18.setExample("the Panama/Suez Canal");
            word18.setTranslatedExample("kênh đào Panama / Suez");
            word18.setUser(listUser.get(3));
            wordSet.add(word18);

            Word word19 = new Word();
            word19.setId(69);
            word19.setName("cruise");
            word19.setContent("du thuyền");
            word19.setPartOfSpeech("noun");
            word19.setPronounce("/kruːz/");
            word19.setExample("a luxury cruise ship");
            word19.setTranslatedExample("một con tàu du lịch sang trọng");
            word19.setUser(listUser.get(3));
            wordSet.add(word19);

            Word word20 = new Word();
            word20.setId(70);
            word20.setName("excursion");
            word20.setContent("đi chơi, dã ngoại");
            word20.setPartOfSpeech("noun");
            word20.setPronounce("/ɪkˈskɜːʃn/");
            word20.setExample("They've gone on an excursion to York.");
            word20.setTranslatedExample("Họ đã đi du ngoạn đến York.");
            word20.setUser(listUser.get(3));
            wordSet.add(word20);

            Word word21 = new Word();
            word21.setId(71);
            word21.setName("explore");
            word21.setContent("đi chơi, dã ngoại");
            word21.setPartOfSpeech("verb");
            word21.setPronounce("/ɪkˈsplɔː(r)/");
            word21.setExample("They explored the land to the south of the Murray River.");
            word21.setTranslatedExample("Họ đã khám phá vùng đất ở phía nam sông Murray.");
            word21.setUser(listUser.get(4));
            wordSet.add(word21);

            Word word22 = new Word();
            word22.setId(72);
            word22.setName("maid");
            word22.setContent("người giúp việc ");
            word22.setPartOfSpeech("noun");
            word22.setPronounce("/meɪd/");
            word22.setExample("The maid was changing the sheets when we got back to our room.");
            word22.setTranslatedExample("Người giúp việc đang thay ga trải giường khi chúng tôi về phòng.");
            word22.setUser(listUser.get(4));
            wordSet.add(word22);

            Word word23 = new Word();
            word23.setId(73);
            word23.setName("overbook");
            word23.setContent("đặt trước quá nhiều");
            word23.setPartOfSpeech("verb");
            word23.setPronounce("/ˌəʊvəˈbʊk/");
            word23.setExample("The flight was heavily overbooked.");
            word23.setTranslatedExample("Chuyến bay đã được đặt trước quá nhiều.");
            word23.setUser(listUser.get(4));
            wordSet.add(word23);

            Word word24 = new Word();
            word24.setId(74);
            word24.setName("porter");
            word24.setContent("người khuân vác");
            word24.setPartOfSpeech("noun");
            word24.setPronounce("/ˈpɔːtə(r)/");
            word24.setExample("Some Sherpas act as guides and porters for mountaineering expeditions.");
            word24.setTranslatedExample("Một số người Sherpa đóng vai trò là người hướng dẫn và khuân vác cho các cuộc thám hiểm leo núi.");
            word24.setUser(listUser.get(4));
            wordSet.add(word24);

            Word word25 = new Word();
            word25.setId(75);
            word25.setName("reservation");
            word25.setContent("đặt chỗ ");
            word25.setPartOfSpeech("noun");
            word25.setPronounce("/ˌrezəˈveɪʃn/");
            word25.setExample("I'll call the restaurant and make a reservation.");
            word25.setTranslatedExample("Tôi sẽ gọi nhà hàng và đặt chỗ .");
            word25.setUser(listUser.get(4));
            wordSet.add(word25);

            Word word26 = new Word();
            word26.setId(76);
            word26.setName("staycation");
            word26.setContent("ở lại ");
            word26.setPartOfSpeech("noun");
            word26.setPronounce("/ˌsteɪˈkeɪʃn/");
            word26.setExample("UK holidaymakers opt for a staycation in Britain.");
            word26.setTranslatedExample("Những người đi nghỉ ở Vương quốc Anh lựa chọn lưu trú tại Anh.");
            word26.setUser(listUser.get(5));
            wordSet.add(word26);

            Word word27 = new Word();
            word27.setId(77);
            word27.setName("suitcase ");
            word27.setContent("chiếc vali");
            word27.setPartOfSpeech("noun");
            word27.setPronounce("/ˈsuːtkeɪs/");
            word27.setExample("to pack/unpack a suitcase");
            word27.setTranslatedExample("đóng gói / mở một vali");
            word27.setUser(listUser.get(5));
            wordSet.add(word27);

            Word word28 = new Word();
            word28.setId(78);
            word28.setName("vacancy ");
            word28.setContent("vị trí còn trống ");
            word28.setPartOfSpeech("noun");
            word28.setPronounce("/ˈveɪkənsi/");
            word28.setExample("Her going on maternity leave will create a temporary vacancy.");
            word28.setTranslatedExample("Cô ấy sẽ nghỉ sinh sẽ tạo ra một vị trí trống tạm thời.");
            word28.setUser(listUser.get(5));
            wordSet.add(word28);

            Word word29 = new Word();
            word29.setId(79);
            word29.setName("valet");
            word29.setContent("người hầu");
            word29.setPartOfSpeech("noun");
            word29.setPronounce("/ˈvæleɪ/");
            word29.setExample("His valet brought him his letters.");
            word29.setTranslatedExample("Người hầu của anh ấy đã mang cho anh ấy những bức thư của anh ấy.");
            word29.setUser(listUser.get(5));
            wordSet.add(word29);

            Word word30 = new Word();
            word30.setId(80);
            word30.setName("voyage");
            word30.setContent("hành trình");
            word30.setPartOfSpeech("noun");
            word30.setPronounce("/ˈvɔɪɪdʒ/");
            word30.setExample("an around-the-world voyage");
            word30.setTranslatedExample("một chuyến đi vòng quanh thế giới");
            word30.setUser(listUser.get(5));
            wordSet.add(word30);

            Word word31 = new Word();
            word31.setId(81);
            word31.setName("aerospace");
            word31.setContent("hàng không vũ trụ");
            word31.setPartOfSpeech("noun");
            word31.setPronounce("/ˈeərəʊspeɪs/");
            word31.setExample("the aerospace industry");
            word31.setTranslatedExample("ngành công nghiệp hàng không vũ trụ");
            word31.setUser(listUser.get(5));
            wordSet.add(word31);

            Word word32 = new Word();
            word32.setId(82);
            word32.setName("aircraft");
            word32.setContent("phi cơ");
            word32.setPartOfSpeech("noun");
            word32.setPronounce("/ˈeəkrɑːft/");
            word32.setExample("The aircraft was flown by a young American pilot.");
            word32.setTranslatedExample("Máy bay do một phi công trẻ người Mỹ lái.");
            word32.setUser(listUser.get(5));
            wordSet.add(word32);

            Word word33 = new Word();
            word33.setId(83);
            word33.setName("aviation");
            word33.setContent("hàng không");
            word33.setPartOfSpeech("noun");
            word33.setPronounce("/ˌeɪviˈeɪʃn/");
            word33.setExample("the aviation business/industry");
            word33.setTranslatedExample("kinh doanh / ngành hàng không");
            word33.setUser(listUser.get(5));
            wordSet.add(word33);

            Word word34 = new Word();
            word34.setId(84);
            word34.setName("beacon");
            word34.setContent("một đèn hiệu điều hướng");
            word34.setPartOfSpeech("noun");
            word34.setPronounce("/ˈbiːkən/");
            word34.setExample("He was a beacon of hope for the younger generation.");
            word34.setTranslatedExample("Anh ấy là một tia sáng hy vọng cho thế hệ trẻ.");
            word34.setUser(listUser.get(5));
            wordSet.add(word34);

            Word word35 = new Word();
            word35.setId(85);
            word35.setName("charter");
            word35.setContent("điều lệ");
            word35.setPartOfSpeech("noun");
            word35.setPronounce("/ˈtʃɑːtə(r)/");
            word35.setExample("a rail passenger’s charter");
            word35.setTranslatedExample("điều lệ của một hành khách đường sắt");
            word35.setUser(listUser.get(5));
            wordSet.add(word35);

            Word word36 = new Word();
            word36.setId(86);
            word36.setName("clearance");
            word36.setContent("giải tỏa");
            word36.setPartOfSpeech("noun");
            word36.setPronounce("/ˈklɪərəns/");
            word36.setExample("forest clearances");
            word36.setTranslatedExample("phát quang rừng");
            word36.setUser(listUser.get(5));
            wordSet.add(word36);

            Word word37 = new Word();
            word37.setId(87);
            word37.setName("disembark");
            word37.setContent("xuống (khỏi một cái gì đó)");
            word37.setPartOfSpeech("verb");
            word37.setPronounce("/ˌdɪsɪmˈbɑːk/");
            word37.setExample("They had just disembarked from their tour bus after a 12-hour journey.");
            word37.setTranslatedExample("Họ vừa xuống khỏi xe buýt du lịch của họ sau cuộc hành trình kéo dài 12 giờ.");
            word37.setUser(listUser.get(5));
            wordSet.add(word37);

            Word word38 = new Word();
            word38.setId(88);
            word38.setName("domestic");
            word38.setContent("nội địa");
            word38.setPartOfSpeech("adjective");
            word38.setPronounce("/dəˈmestɪk/");
            word38.setExample("Output consists of both exports and sales on the domestic market.");
            word38.setTranslatedExample("Sản lượng bao gồm cả xuất khẩu và bán hàng trên thị trường nội địa .");
            word38.setUser(listUser.get(5));
            wordSet.add(word38);

            Word word39 = new Word();
            word39.setId(89);
            word39.setName("glider");
            word39.setContent("tàu lượn");
            word39.setPartOfSpeech("noun");
            word39.setPronounce("/ˈɡlaɪdə(r)/");
            word39.setExample("A glider flew above the beach.");
            word39.setTranslatedExample("Một chiếc tàu lượn bay trên bãi biển.");
            word39.setUser(listUser.get(5));
            wordSet.add(word39);

            Word word40 = new Word();
            word40.setId(90);
            word40.setName("intercom");
            word40.setContent("liên lạc nội bộ");
            word40.setPartOfSpeech("noun");
            word40.setPronounce("/ˈɪntəkɒm/");
            word40.setExample("over the intercom to announce something over the intercom");
            word40.setTranslatedExample("qua hệ thống liên lạc nội bộ để thông báo điều gì đó qua hệ thống liên lạc nội bộ");
            word40.setUser(listUser.get(5));
            wordSet.add(word40);

            Word word41 = new Word();
            word41.setId(91);
            word41.setName("originate ");
            word41.setContent("bắt nguồn ");
            word41.setPartOfSpeech("verb");
            word41.setPronounce("/əˈrɪdʒɪneɪt/");
            word41.setExample("The disease is thought to have originated in the tropics.");
            word41.setTranslatedExample("Căn bệnh này được cho là có nguồn gốc từ vùng nhiệt đới.");
            word41.setUser(listUser.get(5));
            wordSet.add(word41);

            Word word42 = new Word();
            word42.setId(92);
            word42.setName("propeller");
            word42.setContent("cánh quạt");
            word42.setPartOfSpeech("noun");
            word42.setPronounce("/prəˈpelə(r)/");
            word42.setExample("The propeller suddenly stopped turning.");
            word42.setTranslatedExample("Cánh quạt đột ngột ngừng quay.");
            word42.setUser(listUser.get(4));
            wordSet.add(word42);

            Word word43 = new Word();
            word43.setId(93);
            word43.setName("refuel");
            word43.setContent("tiếp nhiên liệu");
            word43.setPartOfSpeech("verb");
            word43.setPronounce("/ˌriːˈfjuːəl/");
            word43.setExample("The planes needed to refuel before the next mission.");
            word43.setTranslatedExample("Các máy bay cần tiếp nhiên liệu trước nhiệm vụ tiếp theo.");
            word43.setUser(listUser.get(4));
            wordSet.add(word43);

            Word word44 = new Word();
            word44.setId(94);
            word44.setName("tailspin");
            word44.setContent("vòng xoáy");
            word44.setPartOfSpeech("noun");
            word44.setPronounce("/ˈteɪlspɪn/");
            word44.setExample("to go into a water tailspin");
            word44.setTranslatedExample("đi vào vòng xoáy nước");
            word44.setUser(listUser.get(4));
            wordSet.add(word44);

            Word word45 = new Word();
            word45.setId(95);
            word45.setName("transit");
            word45.setContent("quá cảnh");
            word45.setPartOfSpeech("noun");
            word45.setPronounce("/ˈtrænzɪt/");
            word45.setExample("The cost includes transit.");
            word45.setTranslatedExample("Chi phí đã bao gồm quá cảnh.");
            word45.setUser(listUser.get(4));
            wordSet.add(word45);

            Word word46 = new Word();
            word46.setId(96);
            word46.setName("turbulence");
            word46.setContent("sự hỗn loạn");
            word46.setPartOfSpeech("noun");
            word46.setPronounce("/ˈtɜːbjələns/");
            word46.setExample("a period of turbulence in the country’s history");
            word46.setTranslatedExample("một thời kỳ đầy biến động của lịch sử đất nước");
            word46.setUser(listUser.get(4));
            wordSet.add(word46);

            Word word47 = new Word();
            word47.setId(97);
            word47.setName("buoyant");
            word47.setContent("phát triển");
            word47.setPartOfSpeech("adjective");
            word47.setPronounce("/ˈbɔɪənt/");
            word47.setExample("a buoyant economy/market");
            word47.setTranslatedExample("một nền kinh tế / thị trường phát triển");
            word47.setUser(listUser.get(4));
            wordSet.add(word47);

            Word word48 = new Word();
            word48.setId(98);
            word48.setName("certain");
            word48.setContent("chắc chắn ");
            word48.setPartOfSpeech("adjective");
            word48.setPronounce("/ˈsɜːtn/");
            word48.setExample("I'm certain we'll think of something.");
            word48.setTranslatedExample("Tôi chắc chắn chúng tôi sẽ nghĩ về một cái gì đó.");
            word48.setUser(listUser.get(4));
            wordSet.add(word48);

            Word word49 = new Word();
            word49.setId(99);
            word49.setName("cliffhanger");
            word49.setContent("phá đám");
            word49.setPartOfSpeech("noun");
            word49.setPronounce("/ˈklɪfhæŋə(r)/");
            word49.setExample("The first part of the serial ended with a real cliffhanger.");
            word49.setTranslatedExample("Phần đầu tiên của loạt phim đã kết thúc với một kẻ phá đám thực sự.");
            word49.setUser(listUser.get(3));
            wordSet.add(word49);

            Word word50 = new Word();
            word50.setId(100);
            word50.setName("conjectural");
            word50.setContent("phỏng đoán");
            word50.setPartOfSpeech("adjective");
            word50.setPronounce("/kənˈdʒektʃərəl/");
            word50.setExample("Some of the stages of the earth’s development are purely conjectural.");
            word50.setTranslatedExample("Một số giai đoạn phát triển của trái đất chỉ là phỏng đoán.");
            word50.setUser(listUser.get(3));
            wordSet.add(word50);

            wordRepository.saveAll(wordSet);
        }
    }
}