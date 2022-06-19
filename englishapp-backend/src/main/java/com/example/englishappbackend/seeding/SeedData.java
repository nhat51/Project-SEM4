package com.example.englishappbackend.seeding;

import com.example.englishappbackend.entity.Article;
import com.example.englishappbackend.entity.User;
import com.example.englishappbackend.entity.Word;
import com.example.englishappbackend.enums.UserStatus;
import com.example.englishappbackend.repo.ArticleRepository;
import com.example.englishappbackend.repo.UserRepository;
import com.example.englishappbackend.repo.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import static com.example.englishappbackend.constant.RoleConstant.ADMIN;
import static com.example.englishappbackend.constant.RoleConstant.USER;

@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    WordRepository wordRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;


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
        seedArticle();
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
            user1.setUsername("admin01");
            user1.setPasswordHash(passwordEncoder.encode("1234"));
            user1.setFullName("Nguyen Quang Nhat");
            user1.setEmail("nhatngao@gmail.com");
            user1.setPhone("(84-8) 8510847");
            user1.setRole(ADMIN);
            user1.setStatus(UserStatus.ACTIVATED);
            userSet.add(user1);

            User user2 = new User();
            user2.setUsername("admin02");
            user2.setPasswordHash(passwordEncoder.encode("1234"));
            user2.setFullName("Dang Hoang Son");
            user2.setEmail("nhaude@gmail.com");
            user2.setPhone("(84-8) 8323791");
            user2.setRole(ADMIN);
            user2.setStatus(UserStatus.ACTIVATED);
            userSet.add(user2);

            User user3 = new User();
            user3.setUsername("user01");
            user3.setPasswordHash(passwordEncoder.encode("1234"));
            user3.setFullName("Christian Le");
            user3.setEmail("sorryallday@gmail.com");
            user3.setPhone("(84-4) 39 283 977");
            user3.setRole(USER);
            user3.setStatus(UserStatus.ACTIVATED);
            userSet.add(user3);

            User user4 = new User();
            user4.setUsername("user02");
            user4.setPasswordHash(passwordEncoder.encode("1234"));
            user4.setFullName("Nguyen Thi Hong");
            user4.setEmail("goilaiemhong@gmail.com");
            user4.setPhone("(84-8) 39 570 522");
            user4.setRole(USER);
            user4.setStatus(UserStatus.ACTIVATED);
            userSet.add(user4);

            User user5 = new User();
            user5.setUsername("user03");
            user5.setPasswordHash(passwordEncoder.encode("1234"));
            user5.setFullName("Nguyen Duc Chinh");
            user5.setEmail("nguyenducchinhhhhhh@gmail.com");
            user5.setPhone("(84-8) 38 439 697");
            user5.setRole(USER);
            user5.setStatus(UserStatus.ACTIVATED);
            userSet.add(user5);

            User user6 = new User();
            user6.setUsername("nhituyetle129");
            user6.setPasswordHash(passwordEncoder.encode("1234"));
            user6.setFullName("Le Tuyet Nhi");
            user6.setEmail("tuyetnhi635465@gmail.com");
            user6.setPhone("84-0-983682958");
            user6.setRole(USER);
            user6.setStatus(UserStatus.ACTIVATED);
            userSet.add(user6);

            User user7 = new User();
            user7.setUsername("luonCaoBang");
            user7.setPasswordHash(passwordEncoder.encode("1234"));
            user7.setFullName("Phung Thanh Do");
            user7.setEmail("vohatxihoicungso@gmail.com");
            user7.setPhone("(84-64) 3 851 922");
            user7.setRole(USER);
            user7.setStatus(UserStatus.ACTIVATED);
            userSet.add(user7);

            User user8 = new User();
            user8.setUsername("torau9856");
            user8.setPasswordHash(passwordEncoder.encode("1234"));
            user8.setFullName("Truong Tue Chau");
            user8.setEmail("trauhoncun12093@gmail.com");
            user8.setPhone("(650) 3658414 ");
            user8.setRole(USER);
            user8.setStatus(UserStatus.ACTIVATED);
            userSet.add(user8);

            User user9 = new User();
            user9.setUsername("anculaunam879");
            user9.setPasswordHash(passwordEncoder.encode("1234"));
            user9.setFullName("Phong Thanh Duong");
            user9.setEmail("detuDCCC@gmail.com");
            user9.setPhone("04. 3 7 951 711");
            user9.setRole(USER);
            user9.setStatus(UserStatus.ACTIVATED);
            userSet.add(user9);

            User user10 = new User();
            user10.setUsername("cmcmcmcmcm710");
            user10.setPasswordHash(passwordEncoder.encode("1234"));
            user10.setFullName("Cristiano Messi");
            user10.setEmail("cm710@gmail.com");
            user10.setPhone("(08) 38350961");
            user10.setRole(USER);
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
            word1.setRemember(true);
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
            word2.setRemember(true);
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
            word7.setRemember(true);
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
            word8.setRemember(true);
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

    public void seedArticle(){
        if(articleRepository.count() == 0) {
            Set<Article> articleSet = new HashSet<>();

            Article article1 = new Article();
            article1.setId(1);
            article1.setTitle("GIAI ĐOẠN NƯỚC RÚT, CÓ NÊN LUYỆN CÀNG NHIỀU ĐỀ THI?");
            article1.setContent("Kỳ thi tuyển sinh vào 10 ngày căng đến gần. Ở giai đoạn gấp rút này, chắc hẳn các bạn học sinh cuối cấp đều cảm thấy vô cùng căng thẳng, mệt mỏi và lo lắng. Tuy nhiên, AMES English tin rằng, mọi nỗ lực của các bạn cuối cùng cũng sẽ tạo ra những “trái ngọt” mà thôi. Vì vậy, trong giai đoạn “chạy nước rút”, hãy cố gắng tập trung và thường xuyên luyện thật nhiều đề nhé!\n" +
                    "\nTại sao nên luyện đề thường xuyên?\n" +
                    "\n" +
                    "Làm quen với cấu trúc đề thi\n" +
                    "\n" +
                    "Bao giờ cũng vậy, đề thi môn tiếng Anh sẽ luôn có một ma trận, cấu trúc nhất định giúp thí sinh dễ dàng phân chia kiến thức và có một kế hoạch ôn tập hiệu quả. Do đó, việc làm thật nhiều đề ôn tập sẽ giúp bạn giảm cảm giác bỡ ngỡ mỗi khi cầm trên tay một tờ đề thi môn tiếng Anh.\n" +
                    "\n" +
                    "Quen với áp lực thời gian\n" +
                    "\n" +
                    "Mỗi khi luyện đề, các bạn học sinh nên tạo cho mình thói quen bấm giờ. Các bạn nên đặt thời gian trùng khớp với thời lượng khi làm bài thi thật (60 phút), bởi việc này sẽ giúp bạn luyện tập việc căn giờ, quản lý thời gian để có thể hoàn thành bài thi kịp thời.\n" +
                    "\n" +
                    "Phát hiện ra những “lỗ hổng kiến thức”\n" +
                    "\n" +
                    "Thường xuyên luyện đề đồng nghĩa với việc thí sinh sẽ có cơ hội tiếp xúc với nhiều loại câu hỏi hơn. Khi đó, thí sinh không chỉ nhận diện được những câu hỏi “bẫy”, mà đôi khi còn phát hiện được những kiến thức, kỹ năng mà bản thân chưa hoàn toàn nắm chắc để có thể tăng cường ôn luyện.\n" +
                    "\n" +
                    "Vậy, các bạn học sinh có thể tìm đề thi ở đâu?\n" +
                    "\n" +
                    "Các bạn học sinh hoàn toàn có thể tìm kiếm trên mạng những đề luyện thi, đề thi thử hay làm lại những đề thi chính thức từ những năm về trước.\n" +
                    "\n" +
                    " Ngoài ra, các bạn có thể tham gia khóa luyện đề thi tiếng Anh tốt nghiệp của AMES English. Khi tham gia vào khóa luyện đề cùng AMES English, các bạn không chỉ được quan tâm, giảng dạy và truyền đạt những bí quyết bởi những giảng viên giàu kinh nghiệm luyện đề, mà còn có cơ hội làm quen và luyện tập những dạng đề bám sát với đề thi thật. Do đó, các bạn học sinh hãy nhanh chóng đăng ký khóa học ngay hôm nay thôi nào!\n" +
                    "\n" +
                    " AMES English chúc các sĩ tử ôn tập thật tốt!");
            articleSet.add(article1);

            Article article2 = new Article();
            article2.setId(2);
            article2.setTitle("ĐỂ ĐẠT 8+ MÔN TIẾNG ANH KỲ THI TỐT NGHIỆP THPTQG, PHẢI LÀM GÌ?");
            article2.setContent("Kỳ thi THPT Quốc gia sắp đến gần, nếu bạn đang có mong muốn đạt được số điểm cực ấn tượng trong bài thi môn tiếng Anh THPT Quốc gia thì bài viết này chính là dành cho bạn đó! Hãy để AMES English chỉ ra những mẹo và phương pháp học tập cực hữu ích, giúp bạn ôn thi hiệu quả và đạt được số điểm như mong đợi nha!\n" +
                    "\n" +
                    "\n" +
                    "HIỂU RÕ CẤU TRÚC ĐỀ THI\n" +
                    "\n" +
                    "Ông bà ta thường có câu “Biết người biết ta, trăm trận trăm thắng”. Tương tự với việc luyện đề, việc nắm rõ cấu trúc, ma trận đề thi sẽ giúp thí sinh hình dung được tổng quan các dạng bài và câu hỏi thường xuyên xuất hiện. Từ đó, các sĩ tử sẽ có thể tự tạo cho mình một lộ trình ôn tập hợp lý và hiệu quả nhất. Vậy, hãy cùng AMES English tìm hiểu ma trận của một đề thi tiếng Anh THPT Quốc gia như thế nào nhé!\n" +
                    "\n" +
                    "Thông thường một đề thi tiếng Anh THPT Quốc gia bao gồm 9 dạng bài:\n" +
                    "\n" +
                    "Phát âm: 2 câu\n" +
                    "Trọng âm: 2 câu\n" +
                    "Câu hỏi từ vựng và ngữ pháp: 19 câu\n" +
                    "Giao tiếp: 2 câu\n" +
                    "Điền từ vào chỗ trống: 5 câu\n" +
                    "Đọc hiểu: 12 câu\n" +
                    "Tìm lỗi sai: 3 câu\n" +
                    "Chọn câu có nghĩa tương tự: 3 câu\n" +
                    "Câu hỏi nối câu: 2 câu\n" +
                    "CÓ CHIẾN LƯỢC ÔN TẬP HIỆU QUẢ\n" +
                    "\n" +
                    "Hiểu rõ bản thân\n" +
                    "\n" +
                    "Trước hết, mỗi học sinh hãy cố gắng hiểu rõ bản thân bằng cách làm thử những bài thi tiếng Anh THPTQG của các năm trước, hay tham gia các kỳ thi thử được tổ chức miễn phí. Nhờ việc tự đánh giá bản thân đang thuộc trình độ nào, thí sinh sẽ có thể đưa ra cho mình phương án ôn tập nhằm cải thiện dần những thiếu sót hiện có và nâng cao những điểm mạnh của bản thân trong quá trình làm bài.\n" +
                    "\n" +
                    "Tổng ôn kiến thức\n" +
                    "\n" +
                    "Tiếp theo, đừng quên tổng ôn tất cả các kiến thức. Sau khi đã đánh giá được năng lực của bản thân, hãy bắt tay ngay vào việc hệ thống lại toàn bộ kiến thức, công thức, từ vựng đã học. Việc phân loại, sắp xếp kiến thức từ cơ bản đến nâng cao sẽ giúp học sinh ôn tập đúng trọng tâm và tránh được việc ôn tập lan man.\n" +
                    "\n" +
                    "Phân bố thời gian ôn tập hợp lý\n" +
                    "\n" +
                    "Mỗi cá nhân lại có một khoảng thời gian khác nhau để thấy học tập hiệu quả nhất trong ngày, có thể là buổi sáng sớm hoặc buổi tối. Vì vậy, chúng ta cần phân chia thời gian tương ứng với hoạt động ôn tập để tối ưu lượng kiến thức cần ôn. Nhiều chuyên gia khuyên rằng các bạn học sinh nên học từ 7 giờ tối đến trước 11 giờ và dậy sớm lúc 5 giờ sáng để tiếp tục ôn tập. Bởi bộ não của chúng ta minh mẫn nhất vào buổi sáng, do đó các sĩ tử có thể dành thời gian này để nạp từ vựng và ngữ pháp tiếng Anh. Đến buổi chiều, các bạn học sinh có thể thực hiện việc luyện đề để quen với thời gian thi chính thức của bộ môn này.\n" +
                    "\n" +
                    "Tham gia khóa luyện đề của AMES English\n" +
                    "\n" +
                    "Để nâng cao chất lượng điểm thi môn tiếng Anh THPT Quốc gia, các sĩ tử hoàn toàn có thể tham gia vào khóa học luyện thi môn tiếng Anh THPT Quốc gia tại các chi nhánh AMES English trên toàn quốc. Khi tham gia vào khóa học này, các bạn không chỉ được quan tâm, giảng dạy bởi các giảng viên giàu kinh nghiệm mà còn có cơ hội được tập trung ôn tập, củng cố các kiến thức tiếng Anh trọng tâm với hệ thống bài luyện tập đa dạng, bám sát cấu trúc đề thi. Vậy nên, các sĩ tử hãy nhanh tay đăng ký tham gia vào khóa học luyện thi tốt nghiệp THPT Quốc gia môn tiếng Anh cùng với AMES English ngay hôm nay thôi nào!");
            articleSet.add(article2);

            Article article3 = new Article();
            article3.setId(3);
            article3.setTitle("3 ĐIỀU CẦN BIẾT VỀ KỲ THI CAMBRIDGE YLE");
            article3.setContent("Hiện nay có rất nhiều phụ huynh cho con đi học và thi lấy chứng chỉ Cambridge nhưng lại không biết rõ đây là loại chứng chỉ gì, tác dụng ra sao? Việc chưa tìm hiểu kĩ như vậy khiến ba mẹ tốn tiền, mất thời gian khi tìm khóa học cho con, hơn nữa còn ảnh hưởng đến định hướng phát triển của con sau này. Chính vì thế, sau đây AMES English sẽ chia sẻ về các loại chứng chỉ YLE để các bậc phụ huynh hiểu rõ hơn về các loại chứng chỉ này nhé.\n"+
                    "Chứng chỉ YLE là gì?\n" +
                    "\n" +
                    "Là chứng chỉ quốc tế được cấp bởi Hội Đồng Khảo Thí Tiếng Anh Trường Đại Học Cambridge – Anh quốc (Cambridge ESOL), và được thiết kế để đánh giá các kỹ năng tiếng Anh của trẻ em từ 4 đến 12 tuổi.\n" +
                    "\n" +
                    "Đề thi được thiết kế đặc biệt cho lứa tuổi thiếu nhi, thường bao gồm một chuỗi các bài tập vui nhộn, sinh động, khiến cho việc học tiếng Anh trở nên thú vị và khích lệ sự tiến bộ ở các em.\n" +
                    "\n" +
                    "Các cấp độ và cấu trúc bài thi YLE\n" +
                    "\n" +
                    "Kỳ thi YLE bao gồm ba bài thi với 03 cấp độ: Starters (Pre A1), Movers (A1) và Flyers (A2).\n" +
                    "\n" +
                    "* Starter: Dành cho thí sinh từ 4-7 tuổi. Đây là bài thi đầu tiên trong hệ thống các bài thi Cambridge YLE đánh giá năng lực tiếng Anh trẻ em, gồm 3 phần thi:\n" +
                    "\n" +
                    " - Listening (kỹ năng Nghe): 20 phút (4 phần, 20 câu hỏi)\n" +
                    "\n" +
                    " - Reading & Writing (kỹ năng Đọc và Viết): 20 phút (5 phần, 25 câu hỏi)\n" +
                    "\n" +
                    " - Speaking (kỹ năng Nói): 3-5 phút (4 phần nhỏ).\n" +
                    "\n" +
                    "Bài thi được thiết kế thú vị, sinh động, giúp các em dễ dàng hiểu và sử dụng các câu giao tiếp tiếng anh hàng ngày.\n" +
                    "\n" +
                    "* Movers: dành cho thí sinh từ 8 - 10 tuổi. Đây là phương pháp tuyệt vời giúp trẻ xây dựng các kỹ năng ngôn ngữ và tiến bộ hơn trong việc học tiếng Anh, bao gồm:\n" +
                    "\n" +
                    " - Listening: 25 phút (5 phần, 25 câu hỏi)\n" +
                    "\n" +
                    " - Reading & Writing: 30 phút (6 phần, 30 câu hỏi)\n" +
                    "\n" +
                    " - Speaking: 5-7 phút (4 phần nhỏ).\n" +
                    "\n" +
                    "* Flyers: dành cho thí sinh từ 11 - 12 tuổi. Ở cấp độ này, các bạn có thể nghe và tương tác bằng tiếng Anh ở mức độ cơ bản, đọc viết các ghi chú ngắn và sử dụng các từ tiếng Anh đơn giản. Bài thi gồm 3 phần:\n" +
                    "\n" +
                    "- Listening: 25 phút (5 phần, 25 câu hỏi)\n" +
                    "\n" +
                    "- Reading & Writing: 40 phút (7 phần, 44 câu hỏi)\n" +
                    "\n" +
                    "- Speaking: 7-9 phút (4 phần nhỏ).\n" +
                    "\n" +
                    "Thời hạn sử dụng chứng chỉ Cambridge YLE\n" +
                    "\n" +
                    "Chứng chỉ Cambridge YLE chỉ cần thi 1 lần và có thể sử dụng mãi mãi. Đây là một lợi thế đặc biệt của loại chứng chỉ này, vừa giúp người học tiết kiệm thời gian vừa để tiết kiệm tài chính vì không cần phải thi lại sau khi hết hạn như những chứng chỉ khác như IELTS, TOEIC hay TOEFL.\n" +
                    "\n" +
                    "* Lợi ích con nhận được khi tham gia khóa học luyện thi Cambridge:\n" +
                    "\n" +
                    "Giáo viên chất lượng, kiến thức trọng tâm\n" +
                    "\n" +
                    "Với đội ngũ giáo viên dày dặn kinh nghiệm ôn luyện, học viên sẽ nắm vững kĩ năng làm bài để tiết kiệm thời gian và đạt hiệu quả tốt nhất.\n" +
                    "\n" +
                    "Tự tin tham gia kì thi theo chuẩn Quốc tế\n" +
                    "\n" +
                    "Các dạng bài với cấu trúc đề thi Cambridge thật giúp học viên làm quen và bình tĩnh, thoải mái hơn trước những kỳ thi trong tương lai.\n" +
                    "\n" +
                    "Ưu thế của chứng chỉ Cambridge YLE\n" +
                    "\n" +
                    "Sở hữu chứng chỉ Cambridge YLE, học viên có lợi thế trong tuyển sinh vào các trường chuyên, trường dân lập chất lượng cao, hệ song bằng Cambridge.");
            articleSet.add(article3);

            Article article4 = new Article();
            article4.setId(4);
            article4.setTitle("KIẾN THỨC CẦN NHỚ ĐỂ ĐẠT TRÊN 8 ĐIỂM MÔN TIẾNG ANH THI VÀO 10");
            article4.setContent("Tiếng Anh là môn thi bắt buộc tại nhiều tỉnh thành trong kỳ thi vào 10. Kỳ thi đang đến rất gần rồi, tuy nhiên với môn tiếng Anh, học sinh không cần quá lo lắng vì nội dung chủ yếu nằm trong chương trình lớp 9 theo yêu cầu chuẩn kiến thức, kỹ năng hiện hành. Mục tiêu đạt kết quả tốt sẽ dễ dàng thực hiện khi bạn chăm chỉ ôn tập. Hôm nay AMES English sẽ giúp các bạn hệ thống các kiến thức cần ôn để đạt từ 8 điểm trở lên môn tiếng Anh nhé!\n" +
                    "️Đề thi tuyển sinh vào lớp 10 sẽ kiểm tra, đánh giá năng lực của học sinh ở 3 thành tố của ngôn ngữ: ngữ pháp, từ vựng, ngữ âm.\n" +
                    "\n" +
                    "️Về phần ngữ pháp, học sinh cần ôn tập:\n" +
                    "\n" +
                    "- Các dạng của từ: Động từ (verb tenses, infinitives, modal verbs, constructions using verbs…), Danh từ (nouns, compound nouns, nouns phrases, gerunds, nouns followed by prepositions…), Tính từ (uses of adjectives, compound adjectives, adjectives followed by prepositions, comparison of adjectives…),\n" +
                    "\n" +
                    "- Các thì của động từ: quá khứ đơn, quá khứ tiếp diễn, quá khứ hoàn thành, tương lai,..\n" +
                    "\n" +
                    "- Các cấu trúc câu: câu đơn (simple sentences), câu ghép (compound sentences), câu phức (complex sentences); câu gián tiếp (reported speech); thể bị động (passive voice), so sánh tính từ, trạng từ; mệnh đề quan hệ (hạn định, không hạn định) ; câu điều kiện (loại 1, loại 2),\n" +
                    "\n" +
                    "- Các cấu trúc khác: used to V, suggest + V-ing/clause with should, tính từ + to V hay tính từ + that + clause, despite/in spite of,…\n" +
                    "\n" +
                    "Ngoài ra, các bạn cũng cần luyện các câu giao tiếp ngắn theo tình huống (exchanges) như cảm ơn, xin lỗi, xin phép, mời, hỏi ý kiến...\n" +
                    "\n" +
                    "️Về phần từ vựng\n" +
                    "\n" +
                    "Học sinh ôn tập \n" +
                    "theo 10 chủ điểm trong sách giáo khoa, bao gồm: Local Environment, City life, Teen stress and pressure, Life in the past, Wonders of Vietnam, Then and now - VietNam, Recipes and Eating habits, Tourism, English in the world, Space travel, Changing Roles in society, My future career.\n" +
                    "\n" +
                    "Một chú ý nho nhỏ là phía cuối sách giáo khoa tiếng Anh đã có đầy đủ từ vựng theo từng chủ đề, vì vậy các bạn có thể sử dụng để ôn từ vựng.\n" +
                    "\n" +
                    "️Về phần phát âm\n" +
                    "\n" +
                    "Với bài thi vào lớp 10, đề môn Tiếng Anh thường không mang tính chất quá đánh đố học sinh mà đa phần là ở mức độ nhận biết. Học sinh cần nắm chắc các quy tắc phát âm cơ bản của nguyên âm, phụ âm, những từ kết thúc bằng “s” và “ed”, quy tắc trọng âm của từ có 2 hoặc nhiều âm tiết.\n" +
                    "\n" +
                    "Đối với những học sinh có nền tảng tốt, để đạt điểm cao (8 điểm trở lên), học sinh cần ôn luyện sâu hơn những kiến thức khó, mang tính học thuật và yêu cầu vận dụng cao. Chẳng hạn như cụm động từ (phrasal verbs), mệnh đề trong các dạng câu phức (conditionals, concessive contrast, relative clauses, clauses of reason, clauses of results, clauses of purpose…), đảo ngữ (inversion), tính từ ghép (compound adjectives), trật tự đúng của tính từ (correct order of adjectives), kết hợp từ (collocations), cụm thành ngữ hoặc tục ngữ cố định (idiomatic expressions)...\n" +
                    "\n" +
                    "Để ôn tập hiệu quả trong giai đoạn nước rút này, học sinh cần viết tóm tắt lại hoặc sơ đồ hóa những kiến thức trên. Học sinh nên hệ thống lại từ vựng theo chủ đề, sau đó đọc phát âm lại từng từ, ôn lại các lớp nghĩa của từ, xem lại các câu có sử dụng những từ vựng đó. Đây là cách vừa ôn lại từ vựng để củng cố và ghi nhớ, vừa mở rộng vốn từ cho bản thân.\n" +
                    "\n" +
                    "Cùng đón xem những bài viết chia sẻ cách ôn thi tiếng Anh hiệu quả cho kỳ thi vào 10 các bạn nhé!");
            articleSet.add(article4);

            Article article5 = new Article();
            article5.setId(5);
            article5.setTitle("ĐẠT 8.0 IELTS - ĐÂU LÀ BÍ QUYẾT");
            article5.setContent("IELTS là một trong những kỳ thi tiếng Anh đạt tiêu chuẩn Quốc tế. Học sinh, sinh viên Việt Nam chắc hẳn đã quá quen với bài thi IELTS. Bởi với kết quả IELTS cao có thể mở ra cho các bạn nhiều cơ hội và sự lựa chọn trong việc học và công việc sau này. Nhưng để có kết quả tốt nhất, các bạn học sinh nên có những bí quyết cho riêng mình. Dưới đây là một số bí quyết giúp bạn chinh phục IELTS với điểm số tốt nhất. \n" +
                    "Bí quyết chinh phục IELTS Writing\n" +
                    "\n" +
                    "Trước hết để có một kỳ thi tốt, bạn cần có sự chuẩn bị tốt, và sự chuẩn bị tốt nhất cho một kỳ thi là sự luyện tập. Bạn nên bỏ thời gian để học và tập viết theo những mẫu câu, đồng thời trau dồi từ vựng. Luyện tập để viết một cách mạch lạc với luận điểm rõ ràng chặt chẽ là một cách để ghi điểm với IELTS Writing test. Bên cạnh đó, khi làm bài, bạn nên đọc câu hỏi thật kỹ sau đó xác định nội dung, chủ đề nhằm xây dựng cấu trúc bài logic, rõ ràng với 3 phần mở, thân, kết. Ngoài ra, việc sử dụng những từ vựng mang tính học thuật cao cũng là một cách để có điểm tốt.\n" +
                    "\n" +
                    "Bí quyết chinh phục IELTS Speaking\n" +
                    "\n" +
                    "Với phần thi này, ngoài việc luyện tập thường xuyên trước khi thi, bạn nên bình tĩnh, thoải mái và tự tin trả lời ban giám khảo. Ở phần thi này, giám khảo sẽ đánh giá qua khả năng thể hiện gồm ngữ điệu, ngữ âm và vốn từ vựng. Vì vậy các bạn học sinh nên chọn lựa từ vựng một cách có chọn lọc và sử dụng đúng hoàn cảnh, đồng thời tránh lặp lại từ. Để tránh khoảng thời gian trống trong bài nói của mình, các bạn nên lập dàn ý về những chủ đề được hỏi nhằm dễ dàng mở rộng câu trả lời của mình với các ý liên quan.\n" +
                    "\n" +
                    "Bí quyết chinh phục IELTS Reading\n" +
                    "\n" +
                    "Ở phần thi IELTS Reading, để có được điểm cao yếu tố quan trọng ấy nằm ở sự luyện tập từ trước. Có lẽ những bài mẫu cũng không quá xa lạ với những bạn ôn thi. Nhưng để tránh sự nhàm chán, bạn nên chọn những chủ đề bạn có hứng thú. Để làm tốt bài đọc, các bạn cần chú ý đến 2 kỹ năng đọc lướt - skimming và đọc tìm ý chính scanning để tìm thông tin quan trọng. Bên cạnh đó, bạn nên đọc kỹ câu hỏi, phân tích, xác định chủ đề và nội dung mỗi đoạn đồng thời tìm và gạch ý chính để có câu trả lời nhanh nhất. Khi làm bài thi IELTS Reading, ta nên chú ý đến thời gian và biết kiểm soát thời gian. Đây có thể là yếu tố tiên quyết để có bài thi IELTS Reading điểm cao.\n" +
                    "\n" +
                    "Bí quyết chinh phục IELTS Listening\n" +
                    "\n" +
                    "Ở phần thi này, các bạn cần chú ý đọc kỹ hướng dẫn và đề bài, có thể ghi chú lên đề thi và gạch dưới những từ khóa chính trong câu hỏi nhằm xác định phần nghe. Thay vì nghe từng đoạn riêng lẻ, ta nên nghe toàn bộ đoạn văn. Độ khó của bài Listening sẽ tăng dần vì thế đồi hỏi thí sinh phải trả lời nhiều câu hỏi cùng lúc. Vì vậy nếu không trả lời được câu hỏi, bạn có thể bỏ qua và quay lại khi còn thời gian. Lưu ý khi làm bài là bạn không nên bỏ trống câu hỏi mà có thể suy đoán những từ đó.\n" +
                    "\n" +
                    "Trên đây là những bí quyết có thể giúp bạn vượt qua bài thi IELTS một cách tốt nhất. Hi vọng các bạn sẽ tìm được phương pháp phù hợp với bản thân để có thể tự tin đạt kết quả tốt nhất cho kỳ thi này.");
            articleSet.add(article5);

            Article article6 = new Article();
            article6.setId(6);
            article6.setTitle("GẠT BỎ RÀO CẢN, CHINH PHỤC TIẾNG ANH GIAO TIẾP");
            article6.setContent("Mức lương khởi điểm cao hơn đến 20% trung bình, những cơ hội thăng tiến rộng mở cùng khả năng trúng tuyển vào các công ty, tập đoàn lớn đáng mơ ước nhờ có khả năng giao tiếp tiếng Anh trôi chảy nghe quả thực vô cùng hấp dẫn phải không? Tuy nhiên, trên thực tế, trong quá trình học tiếng Anh giao tiếp, không ít người trong độ tuổi đi làm gặp phải những khó khăn gây cản trở con đường chinh phục tiếng Anh của mình.\n" +
                    "\nVậy, những khó khăn đó là gì?\n" +
                    "\n" +
                    "☑️Khó khăn trong việc quản lý thời gian học tiếng Anh\n" +
                    "\n" +
                    "☑️Khó khăn trong việc ghi nhớ và tập trung\n" +
                    "\n" +
                    "☑️E ngại về độ tuổi học tiếng Anh\n" +
                    "\n" +
                    "☑️Thiếu kiên nhẫn trong việc học tập\n" +
                    "\n" +
                    "Hiểu được những lo ngại phổ biến của mọi người, AMES English sẽ gợi ý cho bạn – những người đang trong độ tuổi đi làm một số cách học tiếng Anh cực thú vị giúp bạn gạt bỏ ngay những chướng ngại ngăn cản bạn nâng cao khả năng tiếng Anh giao tiếp trôi chảy. Hãy cùng AMES tìm hiểu xem đó là những cách gì nhé!\n" +
                    "\n" +
                    "ĐẮM CHÌM TRONG TIẾNG ANH BẰNG NHỮNG BỘ PHIM, CHƯƠNG TRÌNH TRUYỀN HÌNH ANH – MỸ.\n" +
                    "\n" +
                    "Quả thực rất khó để phủ nhận độ phổ biến và sức hút của những chương trình truyền hình, những bộ phim điện ảnh với hiệu ứng mãn nhãn và những series hài sitcom cười rớt nước mắt của nền giải trí Hoa Kỳ đối với công chúng. Do vậy, việc vừa thưởng thức, đắm chìm trong những thước phim tuyệt vời, vừa học tiếng Anh sẽ giúp bạn dễ dàng hấp thụ và lĩnh hội những từ vựng, cấu trúc câu một cách từ từ, thụ động mà chắc chắn. Quả là một công đôi việc phải không!\n" +
                    "\n" +
                    "ÁP DỤNG NGAY PHƯƠNG PHÁP “SHADOWING” THẦN THÁNH.\n" +
                    "\n" +
                    "Trong khi bạn đang thưởng thức một bộ phim, nghe một số podcast hay một bài hát USUK rất bắt tai, đừng quên áp dụng ngay phương pháp “Shadowing” trong suốt quá trình nghe nhé. “Shadowing” chính là phương pháp nghe và lặp lại nội dung, ngữ điệu của đoạn video hoặc audio một cách chính xác và nhanh nhất có thể. Phương pháp này không chỉ giúp bạn cải thiện phát âm mà nó còn giúp bạn tăng khả năng phản xạ tiếng Anh, giúp câu nói của bạn trở nên tự nhiên và mạch lạc như người bản xứ vậy.\n" +
                    "\n" +
                    "ĐĂNG KÝ NGAY MỘT KHÓA HỌC TIẾNG ANH GIAO TIẾP TRỰC TUYẾN PHÙ HỢP.\n" +
                    "\n" +
                    "Với tính linh hoạt về cả thời gian lẫn địa điểm của việc học tiếng Anh trực tuyến, bạn hoàn toàn có thể tiết kiệm được rất nhiều thời gian so với việc phải đi lại trung tâm Anh ngữ. Ngoài ra, bạn có thể tự mình kiểm soát, cân bằng thời gian đi làm và học tiếng Anh. Bên cạnh đó, việc đăng ký khóa giao tiếp 1:1 với người bản xứ không chỉ giúp bạn có thêm động lực học tập mà còn nó giúp bạn cải thiện đồng thời các kỹ năng nghe, nói và tăng khả năng xử lý, phản xạ trước các tình huống thực tiễn. Hơn nữa, một khóa học với lộ trình rõ ràng, bài bản sẽ giúp bạn chinh phục mục tiêu nhanh và chắc chắn hơn đáng kể.");
            articleSet.add(article6);

            Article article7 = new Article();
            article7.setId(7);
            article7.setTitle("04 LỢI ÍCH KHI HỌC IELTS TỪ CẤP 3");
            article7.setContent("Trong môi trường hội nhập như ngày nay, ngoại ngữ được xem như chiếc chìa khóa để mở rộng cánh cửa tri thức và cơ hội việc làm. Trong đó, tiếng Anh là ngôn ngữ phổ biến, thông dụng mà bất cứ ai cũng nên biết. Vậy nên, nếu con trẻ được tiếp xúc với tiếng Anh ngay từ lúc còn nhỏ là một lợi thế vô cùng to lớn. Bên cạnh đó, các khóa học thi các chứng chỉ như IELTS đã và đang dành được sự quan tâm lớn của phụ huynh bởi đây sẽ là cơ hội lớn để con vừa rèn luyện tiếng Anh, vừa có được bằng học thuật. Nhưng thời điểm nào thích hợp để bắt đầu cho các con tham gia học IELTS vẫn là băn khoăn của khá nhiều các bậc phụ huynh.\n" +
                    "\n" +
                    "Khi bước vào giai đoạn Trung học phổ thông, các em bắt đầu bước vào giai đoạn học tập chuyên sâu và đủ khả năng để tiếp thu nhiều kiến thức. Chính vì thế, đây chính là thời điểm tốt nhất để học sinh tiếp xúc với IELTS. Hơn nữa rất nhiều chuyên gia cũng khuyên rằng, bố mẹ nên cho con học IELTS từ năm lớp 10, lớp 11.\n" +
                    "Được miễn thi tiếng Anh THPT\n" +
                    "\n" +
                    "Từ năm 2015, bộ Giáo dục đã ra quyết định miễn thi tốt nghiệp ngoại ngữ đối với học sinh có chứng chỉ IELTS 4.0. Như vậy, chỉ cần có chứng chỉ IELTS 4.0 không hề khó mà đã giảm được áp lực to lớn trong kỳ thi tốt nghiệp THPT.\n" +
                    "\n" +
                    "Đặc biệt, nếu có điểm IELTS cao, từ 6.0 trở lên thì các em sẽ được xét tương đương điểm 10 của môn tiếng Anh vào một số trường Đại học. Vừa có kiến thức, được rèn luyện tư duy vừa đỡ áp lực khi thi tốt nghiệp thì thật tốt phải không? Có thể nói, đây là lợi ích cực lớn để giải thích tại sao phải học IELTS từ cấp 3.\n" +
                    "\n" +
                    "Chuẩn bị tốt cho ước mơ du học, săn học bổng\n" +
                    "\n" +
                    "Với nhiều gia đình, cho con du học tại những quốc gia tiên tiến là định hướng và mong muốn con được có thêm trải nghiệm, trau dồi tri thức. Và IELTS chính là điều kiện bắt buộc giúp mở rộng cánh cửa du học bởi nhiều quốc gia, nhiều trường học danh tiếng trên thế giới yêu cầu bằng IELTS. Mức điểm IELTS là khác nhau đối với từng nước, từng ngành học. Thế nhưng, không có chứng chỉ IELTS thì khó hoàn thành hồ sơ du học.\n" +
                    "\n" +
                    "Đặc biệt, nếu bài thi có kết quả tốt thì các em còn có thể săn được những suất học bổng hấp dẫn. Chính vì thế, nếu bố mẹ muốn tạo điều kiện cho con du học thì chắc hẳn phải biết lợi thế tại sao phải học IELTS từ cấp 3. Càng giỏi tiếng Anh, càng dễ sang nước ngoài mở mang tầm mắt, học tập và sống tự lập càng tốt hơn.\n" +
                    "\n" +
                    "Nâng cao trình độ tiếng Anh, tự tin giao tiếp với người bản xứ\n" +
                    "\n" +
                    "Trong xu hướng hội nhập quốc tế, tiếng Anh từ lâu đã trở thành một môn học bắt buộc trong hệ thống giáo dục tại Việt nam. Việc được tiếp xúc với IELTS từ sớm sẽ khiến những bài học của con ở trường không còn là trở ngại đối với học sinh.\n" +
                    "\n" +
                    "Bởi bài thi IELTS được thiết kế mang đến kiến thức đầy đủ và toàn diện với 4 kỹ năng toàn diện Nghe – Nói – Đọc – Viết . Từ đó, các em sẽ được rèn luyện và phát triển kỹ năng tiếng Anh toàn diện hơn. Điểm tiếng Anh ở trường cũng sẽ cao hơn và đem lại kết quả học tập tốt hơn cho các bạn.\n" +
                    "\n" +
                    "Học IELTS giúp rèn luyện tư duy, phát triển toàn diện\n" +
                    "\n" +
                    "Một lợi ích nữa giải thích lý do tại sao phải học IELTS từ cấp 3 là bởi vì IELTS giúp học sinh phát triển vượt bậc về khả năng tư duy logic và trí tuệ. Trong quá trình học, các em sẽ được tiếp xúc với các chủ đề thông dụng trong cuộc sống hằng ngày. Từ giáo dục, hoạt động vui chơi cho đến đến vấn đề liên quan môi trường, y tế. Điều này giúp các em có sự hiểu biết nhiều hơn, trưởng thành hơn các bạn đồng trang lứa.\n" +
                    "\n" +
                    "Vậy phụ huynh nên cho con học IELTS ở đâu?\n" +
                    "\n" +
                    "Với những lợi thế mà tấm bằng IELTS đem lại, chắc hẳn các bậc phụ huynh đang nóng lòng muốn tìm cho con một địa chỉ luyện thi IELTS chất lượng.");
            articleSet.add(article7);

            Article article8 = new Article();
            article8.setId(8);
            article8.setTitle("GIỎI TIẾNG ANH NHỜ PHƯƠNG PHÁP POMODORO “THẦN THÁNH”");
            article8.setContent("Thay vì dành hàng giờ đồng hồ liên tục chỉ để đắm mình trong những tin tức nóng hổi, giật gân, những video xu hướng trên mạng xã hội, hay cùng hội bạn thân tán gẫu, “facetime” cả đêm, sẽ thật tuyệt vời nếu chúng ta có thể sử dụng tối đa và hiệu quả quỹ thời gian mình đang có để ôn tập lại kiến thức, hoàn thành hết bài tập được giao hoặc nạp thêm một vài cấu trúc, từ vựng tiếng Anh mới phải không. Tuy nhiên, câu hỏi được đặt ra chính là làm thế nào để chúng ta có thể quản lý quỹ thời gian của mình thật tốt và cải thiện khả năng tập trung một cách hiệu quả? Hãy cùng AMES English áp dụng phương pháp Pomodoro “thần thánh” ngay nhé!\n" +
                    "Phương pháp Pomodoro là gì?\n" +
                    "\n" +
                    "Phương pháp Pomodoro hay còn gọi là phương pháp quả cà chua Pomodoro là một kỹ thuật tối ưu việc quản lý thời gian và tăng năng suất công việc được nhà quản lý Francesco Cirilo lên ý tưởng lần đầu tiên vào năm 1987. Sở dĩ, phương pháp này được đặt cho một cái tên hết sức dễ thương như vậy là bởi vì ông đã thực hiện rất tốt việc quản lý thời gian và nâng cao hiệu quả làm việc nhờ sử dụng chiếc đồng hồ bấm giờ hình quả cà chua của mình. Sau này, kỹ thuật Pomodoro được phổ biến rộng rãi và được nhiều người biết đến nhờ cách áp dụng vô cùng đơn giản mà đem lại hiệu quả không ngờ. \n" +
                    "\n" +
                    " \n" +
                    "Ai có thể áp dụng phương pháp này? \n" +
                    "\n" +
                    "Bất cứ ai có mong muốn đảm bảo việc quản lý, sử dụng tối ưu thời gian đang có, và gia tăng sự tập trung, hiệu suất học tập, làm việc đều có thể sử dụng phương pháp Pomodoro. Đặc biệt, phương pháp này sẽ rất phù hợp cho những bạn học sinh, sinh viên đòi hỏi sự tập trung cao độ trong quá trình ôn tập để chuẩn bị cho những kỳ thi quan trọng chẳng hạn như thi học kỳ, thi đại học hay thi lấy chứng chỉ IELTS,....\n" +
                    "\n" +
                    "Vậy, chúng ta có thể áp dụng phương pháp này như thế nào?\n" +
                    "\n" +
                    "Bước 1: Lên kế hoạch\n" +
                    "\n" +
                    "Việc lên kế hoạch luôn là bước quan trọng nhất và quyết định xem quá trình học tập và làm việc của chúng ta có thành công hay không. Do đó, trước khi bắt đầu “thực chiến”, các bạn trẻ đừng quên tạo cho mình một danh sách “To-do list” gồm tất cả những đầu việc hoặc bài tập cần hoàn thành để quá trình thực hành của chúng mình diễn ra nhanh chóng, suôn sẻ và hiệu quả hơn nhé!\n" +
                    "\n" +
                    "Bước 2: Chuẩn bị \n" +
                    "\n" +
                    "Rất đơn giản, bên cạnh những đồ dùng học tập, sách vở và đề kiểm tra, tất cả những gì bạn cần chuẩn bị chỉ là một dụng cụ có khả năng đếm giờ được đặt tại góc học tập chẳng hạn như điện thoại, máy tính có chức năng đếm giờ, các phần mềm được thiết lập dựa theo phương pháp Pomodoro, hoặc là một chiếc đồng hồ đếm ngược hình quả cà chua Pomodoro cũng là một lựa chọn tuyệt vời. \n" +
                    "\n" +
                    "Bước 3: Thực hành\n" +
                    "\n" +
                    "Trong suốt quá trình học tập, hãy luôn để dụng cụ đếm thời gian của mình ở bên cạnh và cứ sau 25 phút tập trung cao độ cho việc học tập, bạn sẽ có 5 phút nghỉ ngơi ngắn hạn. Nhà quản lý Francesco gọi những phiên làm việc kéo dài 25 phút này là một “Pomodoro”. Sau khi hoàn thành từ 3 đến 4 phiên làm việc, bạn sẽ được tận hưởng thời gian giải lao dài hơn (15-30 phút). Lưu ý rằng bạn sẽ cần tập trung hoàn toàn 100% tâm trí cho việc học tập trong suốt 25 phút, và nếu bắt buộc phải gián đoạn thì Pomodoro sẽ được tính lại từ đầu. \n" +
                    "\n" +
                    "Đối với việc học tiếng Anh, phương pháp này mang lại hiệu quả như thế nào? \n" +
                    "\n" +
                    "Ghi nhớ được nhiều từ vựng chỉ trong một đêm\n" +
                    "\n" +
                    "Nếu bình thường bạn luôn cảm thấy chán nản và lo lắng vì cả một buổi tối chỉ học được rất ít từ vựng hoặc thậm chí không học thêm được bất kỳ từ mới nào, thì bây giờ, với việc áp dụng phương pháp Pomodoro, cứ 25 phút bạn tập trung cao độ học một lượng từ vựng thì sau 3-4 phiên học tập, số lượng từ vựng bạn nạp được chắc chắn sẽ tăng lên gấp nhiều lần. \n" +
                    "\n" +
                    "Giải được nhiều đề tiếng Anh hơn\n" +
                    "\n" +
                    "Áp lực về thời gian bắt buộc bạn phải hoàn thành đề kiểm tra trước khi kết thúc một phiên Pomodoro. Điều này rất phù hợp cho những bạn đang ôn thi IELTS, đặc biệt là bài thi Reading bởi thời gian trung bình để hoàn thành một phần thi thông thường là 20 phút. \n" +
                    "\n" +
                    "Luôn giữ được cảm hứng học tập liên tục\n" +
                    "\n" +
                    "Kết thúc một phiên Pomodoro đồng nghĩa với việc bạn đang tiến rất gần với mục tiêu hoàn thành bài tập. Áp lực về thời gian sẽ giúp đẩy nhanh tiến trình học của bạn, tuy nhiên nó cũng sẽ đem lại cho bạn sự phấn khích sau mỗi lần hoàn thành một phiên học tập. \n" +
                    "\n" +
                    "Chỉ với cách áp dụng cực kỳ đơn giản mà đem lại hiệu quả học tập vô cùng tuyệt vời, các bạn còn chần chừ gì mà không thực hành ngay phương pháp quả cà chua Pomodoro này ngay hôm nay nhỉ!\n" +
                    "\n");
            articleSet.add(article8);

            Article article9 = new Article();
            article9.setId(9);
            article9.setTitle("6 TIPS XÓA TAN NỖI SỢ IELTS WRITNG TASK 2");
            article9.setContent("IELTS Writing gồm 2 phần thi và Task 2 thường là nỗi ám ảnh đối với các sĩ tử. Đây là phần chiếm trọng điểm của kỹ năng này khi chiếm tới ⅔ số điểm tổng và đòi hỏi thí sinh có tư duy nhạy bén, ngữ pháp và từ vựng tốt để có thể đạt được điểm cao. Task 2 sẽ yêu cầu thí sinh trả lời những câu hỏi gần gũi, quen thuộc mà mọi người trên thế giới đều đang quan tâm bằng một đoạn văn khoảng 250 từ. Vậy làm cách nào để có thể đạt được điểm số cao ở phần thi quan trọng này? Ở bài viết dưới đây, AMES English sẽ chia sẻ tới bạn 6 mẹo nhỏ giúp bạn tự tin hơn trước khi bước vào kỳ thi nhé!\n" +
                    "\n" +
                    "1/ TIP 1: Phân tích kỹ câu hỏi\n" +
                    "\n" +
                    "Để đạt được điểm cao, điều tối quan trọng đó là bạn cần trả lời đầy đủ câu hỏi mà đề bài yêu cầu. Nếu không trả lời đầy đủ, việc bạn đạt điểm trên 5 là không thể. Rèn luyện tính kiên trì nghiên cứu câu hỏi cũng là một kỹ năng cần thiết khi bạn bắt tay vào luyện thi IELTS Writing. Trả lời câu hỏi một cách đầy đủ, chỉ đơn giản là bạn hãy dành thời gian nghiên cứu thật kỹ câu hỏi và nắm bắt được người ra đề muốn bạn đưa ra ý kiến, quan điểm về những vấn đề gì. Hãy đọc và nghiền ngẫm câu hỏi cẩn thận, kỹ lưỡng để tìm ra những từ khóa chính, các từ khóa phụ và hướng dẫn của đề bài. Để làm rõ điều này, hãy cùng phân tích đề bài sau đây:\n" +
                    "\n" +
                    "“Young people who commit crimes should be treated the same way as adults. To what extent do you agree or disagree?”\n" +
                    "\n" +
                    "Từ khóa đầu tiên có thể tìm thấy được đó là “Những người trẻ phạm pháp (Young people who commit crimes)”. Đây là từ khóa chính của đề bài này và chúng ta cần tập trung làm rõ. Tuy nhiên ta không được phép trả lời chung chung về việc giới trẻ phạm pháp, vì vậy cần tiếp tục tới bước số 2 đó là tìm từ khóa phụ.\n" +
                    "\n" +
                    "Hai từ khóa phụ có thể nhận thấy được là “Nên bị đối xử (should be treated)” và “Giống với những người lớn tuổi (the same way as adults)” . Ta cần tìm kiếm thêm thông tin về 2 dữ kiện này để giải quyết cho từ khóa chính. Bước cuối cùng là sử dụng hướng dẫn “Đồng ý hay không?”. Nhờ đó ta sẽ tập trung để đưa những điều này vào trong bài viết của mình\n" +
                    "\n" +
                    "2/ TIP 2: Lập dàn ý\n" +
                    "\n" +
                    "Sau khi phân tích câu hỏi một cách kỹ lưỡng, hãy dành tiếp thời gian để lập nên một dàn bài cụ thể những gì bạn sẽ viết vào bài của mình. Điều này sẽ giúp bạn ghi ra được những thông tin cần thiết mà bạn đã tập hợp được sau khi hiểu rõ đề bài. Hơn nữa việc lập dàn ý sẽ giúp bạn tránh được việc để sót thông tin, tránh được việc viết hết ý rồi mới nhận ra thiếu mất thông tin quan trọng. Hãy nghĩ rằng việc lập dàn ý cũng như việc bạn đi du lịch vậy, bạn càng chuẩn bị kỹ càng khâu tìm hiểu và lên kế hoạch thì kết quả bạn nhận được sẽ càng tuyệt vời.\n" +
                    "\n" +
                    "3/ TIP 3: Sử dụng các cấu trúc chính xác\n" +
                    "\n" +
                    "IELTS Writing task 2 thường tuân theo một quy chuẩn nhất định, vì vậy bạn nên viết dựa theo những format có sẵn. Tuy nhiên AMES không khuyến khích bạn học thuộc lòng các template hay các mẫu câu có sẵn, điều này là hoàn toàn không nên. Thay vào đó hãy ghi nhớ những dạng dàn bài cụ thể đối với mỗi cấu trúc đề khác nhau. Ví dụ với đề bài PROBLEMS, CAUSES, SOLUTIONS, bạn có thể sử dụng dạng thân bài sau đây:\n" +
                    "\n" +
                    "Introduction:\n" +
                    "\n" +
                    "Diễn đạt lại thông tin và diễn đạt lại các thông tin được đưa ra trong đề bài (Paraphrase)\n" +
                    "\n" +
                    "Đưa ra nội dung mà bạn sẽ triển khai trong bài\n" +
                    "\n" +
                    "Chỉ ra rằng hai đoạn thân bài của bạn sẽ giải quyết Problems và Solutions/ Causes và Effects/ Causes và Solutions\n" +
                    "\n" +
                    "Body 1:\n" +
                    "\n" +
                    "Đưa ra nguyên nhân 1/nêu vấn đề đó là gì\n" +
                    "\n" +
                    "Giải thích nguyên nhân 1/vấn đề 1\n" +
                    "\n" +
                    "Đưa ra ví dụ\n" +
                    "\n" +
                    "Body 2:\n" +
                    "\n" +
                    "Đưa ra ảnh hưởng / giải pháp cho vấn đề 1\n" +
                    "\n" +
                    "Giải thích giải pháp này giải quyết vấn đề 1 thế nào\n" +
                    "\n" +
                    "Đưa ra ví dụ\n" +
                    "\n" +
                    "Conclusion:\n" +
                    "\n" +
                    "Tóm lại ý chính trong 2 đoạn thân bài- Nêu dự đoán/ đánh giá về vấn đề\n" +
                    "\n" +
                    "Với dạng bài này, bạn nên đưa ra 2 cặp nguyên nhân kết quả để giúp bài viết có chiều sâu hơn.\n" +
                    "\n" +
                    "4/ TIP 4: Thể hiện sự gắn kết và liền mạch giữa các ý\n" +
                    "\n" +
                    "Việc sắp xếp được các ý chính trong bài để tạo ra một tổng thể hoàn chỉnh, logic và liền mạch giúp người đọc dễ dàng theo dõi và hiểu được nội dung mà bạn truyền tải. Để sắp xếp được các ý một cách logic, bạn hãy trau chuốt ngay từ TIP số 2. Bên cạnh đó, hãy sử dụng Topic Sentence ở đầu mỗi đoạn để người đọc biết được chủ đề của đoạn văn đó đang nói tới.Không những thế, việc sử dụng những linking word (từ nối) đóng vai trò quan trọng trong việc kết nối các câu từ với nhau, tạo nên một đoạn văn hoàn chỉnh và mang tính gắn kết cao. Ngoài ra hãy cố gắng đưa ra một ví dụ nhỏ cho mỗi luận điểm mà bạn nhắc tới. Điều này sẽ giúp người đọc dễ dàng liên hệ với ý kiến mà bạn đã đưa ra trước đó.\n" +
                    "\n" +
                    "5/ TIP 5: Đưa ra các ý kiến và làm rõ ý kiến của mình\n" +
                    "\n" +
                    "Writing Task 2 sẽ yêu cầu bạn làm rõ luận điểm của mình, đồng ý hoặc là không đồng ý. Hãy làm rõ ý kiến của mình ở phần mở bài, đưa ra luận điểm và lí do để thể hiện lập trường của mình và chốt lại ý kiến ở phần kết bài. Hãy chắc chắn rằng quan điểm của bạn được nêu ra ở ngay đầu bài viết. Bạn có thể sử dụng những mẫu câu sau để nêu ra quan điểm của mình:\n" +
                    "\n" +
                    "I believed that…\n" +
                    "\n" +
                    "It is agreed that..\n" +
                    "\n" +
                    "It is disagreed that…\n" +
                    "\n" +
                    "6/ TIP 6: Chú ý trong việc sử dụng ngôn từ\n" +
                    "\n" +
                    "Vì đây là phần thi học thuật nên việc sử dụng từ ngữ cần nhiều sự tinh tế và có một chút nghiêm chỉnh. Không sử dụng các từ viết tắt như là “don’t”, “isn’t”, “won’t”. Hãy luôn luôn viết “do not”, “is not”, “will not”. Bên cạnh đó, tránh sử dụng ngôn ngữ nói như là “I’m gonna”, “I wanna”. Ngoài ra bạn cũng cần tránh việc sử dụng những từ ngữ thể hiện cảm xúc và đưa ra những ví dụ của cá nhân.");
            articleSet.add(article9);

            Article article10 = new Article();
            article10.setId(10);
            article10.setTitle("5 TIPS ĐỂ NÓI TIẾNG ANH NHƯ NGƯỜI BẢN XỨ");
            article10.setContent("Mục tiêu học tiếng Anh của nhiều bạn là có thể giao tiếp với người bản xứ một cách trôi chảy, mạch lạc, có thể truyền tải được suy nghĩ của mình một cách dễ dàng hơn. Hai chất giọng phổ biến nhất mà người học tiếng Anh hay hướng tới là Anh-Anh và Anh-Mỹ. Nhiều người cho rằng mình không có bạn bè hay người thân sống ở nước ngoài nên việc luyện tập giọng điệu là không thể. Tuy nhiên, với những tips mà AMES English chia sẻ trong bài viết dưới đây, bạn hoàn toàn có thể làm được điều đó!\n" +
                    "TIP 1: Hãy lựa chọn giọng điệu mà bạn muốn hướng tới\n" +
                    "\n" +
                    "Trên thế giới có rất nhiều nước sử dụng tiếng Anh như ngôn ngữ chính và mỗi vùng sẽ có giọng điệu khác nhau. Nhưng 2 loại giọng điệu phổ biến nhất hiện nay là Anh-Anh và Anh-Mỹ. Vì vậy, tùy vào sở thích và mục tiêu, hãy lựa chọn cho mình một giọng điệu mà bạn cảm thấy là phù hợp nhất.\n" +
                    "\n" +
                    "TIP 2: Phát âm chuẩn\n" +
                    "\n" +
                    "Trong tiếng Anh có rất nhiều âm không có trong tiếng Việt, và để phát âm chuẩn thì trước hết bạn cần nhận biết được các âm này và phát âm được chuẩn nhất. Khi đã thuần thục việc phát âm thì bạn mới có thể nói giống người bản xứ được. Để học các âm này bạn hãy tìm hiểu về bảng phiên âm tiếng Anh (IPA).\n" +
                    "\n" +
                    "TIP 3: Hãy chú ý tới trọng âm\n" +
                    "\n" +
                    "Học để phát âm theo người bản xứ là mục tiêu mà nhiều bạn hướng tới. Tuy nhiên vì quá mải mê tập trung vào ngữ điệu mà lại quên đi một phần vô cùng quan trọng khi giao tiếp đó là trọng âm. Nếu bạn đặt sai trọng âm, người khác có thể không hiểu từ bạn đang nói là gì. Vì vậy, hãy tập trung cả vào trọng âm khi học giao tiếp nữa nhé!\n" +
                    "\n" +
                    "TIP 4: Luyện nghe\n" +
                    "\n" +
                    "Nghe có vẻ không liên quan, nhưng phương pháp tốt nhất để học phát âm và ngữ điệu đó là luyện nghe. Có rất nhiều phương tiện để bạn luyện nghe, có thể là qua Tivi, mạng xã hội, các kênh podcast hay các bài hát của ca sĩ US-UK. Trong quá trình nghe hãy cố gắng chú ý vào giọng điệu của những người bản xứ để học tập cách phát âm của họ. Ngoài ra cũng cần chú ý tới các lỗi sai khi phát âm của người khác để rút kinh nghiệm cho chính mình.\n" +
                    "\n" +
                    "TIP 5: Luyện ngữ điệu\n" +
                    "\n" +
                    "Điều quan trọng nhất để có ngữ điệu giống người bản xứ đó là luyện tập phát âm. Hãy luyện tập với những mẫu câu giao tiếp ngắn để có thể làm quen với ngữ điệu mà bạn mong muốn. Khi đã thuần thục và nhuần nhuyễn hơn thì bạn có tăng tốc độ lên và tập với những câu giao tiếp dài hơn hoặc với các đoạn hội thoại. Đây là tip cuối cùng và cũng là quan trọng nhất để có thể nói tiếng Anh “như Tây”. Hãy luyện tập thường xuyên và kiên trì để đạt được kết quả tốt nhất nhé!");
            articleSet.add(article10);

            Article article11 = new Article();
            article11.setId(11);
            article11.setTitle("TOP 3 CUỐN SÁCH LUYỆN IELTS LISTENING HAY NHẤT CHO NGƯỜI MỚI BẮT ĐẦU");
            article11.setContent("Hiện nay, trên thị trường có rất nhiều sách luyện Listening IELTS, nhưng bạn đã biết những cuốn sách giúp cải thiện kỹ năng Listening và nâng band điểm của bạn chưa? Hôm nay, AMES English sẽ giới thiệu cho bạn top 3 cuốn sách luyện thi Listening IELTS hay nhất dành cho người mới bắt đầu nhé!\n" +
                    "1.Listen Carefully – sách luyện thi IELTS cho người mới bắt đầu\n" +
                    "\n" +
                    "Ngay từ bìa sách, người học cũng có thể thấy rõ đối tượng mà sách hướng tới là cho những người mới bắt đầu học IELTS muốn cải thiện kỹ năng nghe hiểu. Cuốn sách này dành cho những người học Tiếng Anh ở mức độ A2, nó cũng tương đương với trình độ IELTS 3.5 đó. \n" +
                    "\n" +
                    "Trong đó, khi ở trình độ này, người học có thể hiểu được:\n" +
                    "\n" +
                    "Từ vựng cơ bản, các từ xoay quanh chủ đề gia đình và công việc\n" +
                    "\n" +
                    "Các câu, từ được nói chậm và rõ ràng\n" +
                    "\n" +
                    "Các văn bản ngắn, đơn giản về chủ đề quen thuộc\n" +
                    "\n" +
                    "Ưu điểm\n" +
                    "Sách được phân loại nội dung theo từng chủ đề quen thuộc và cơ bản để người học có thể ứng dụng trong các bài thi. \n" +
                    "\n" +
                    "Mục lục sách rõ ràng, liệt kê đầy đủ các chương có trong sách và các mục nhỏ. Điều này sẽ giúp cho người học dễ dàng tiếp cận đến nội dung cần học và luyện tập.\n" +
                    "\n" +
                    "Đa dạng các loại bài tập theo mức độ từ dễ đến khó, người mới bắt đầu học sẽ dễ dàng học và từ từ cải thiện kỹ năng nghe hiểu của mình, mà không bị nản vì làm những những bài tập quá khó.\n" +
                    "\n" +
                    "Các chủ đề nghe rất gần gũi với cuộc sống thường ngày, không chứa các chủ đề khoa học hay học thuật. Vì thế, các bạn sẽ không cảm thấy nhàm chán khi luyện nghe mỗi ngày. \n" +
                    "\n" +
                    "Nhược điểm\n" +
                    "Sách được xuất bản lần đầu vào năm 1990. Vì thế, bản cứng của sách trên thị trường hay các sàn thương mại điện tử tại Việt Nam, không thuận lợi cho người học tìm mua sách và băng CD.\n" +
                    "\n" +
                    "Tuy nhiên, người học vẫn có thể tải bản mềm ở định dạng file pdf và file audio ở trên mạng Internet. Đây cũng chính là khuyết điểm của cuốn sách với những người quen dùng sách giấy.\n" +
                    "\n" +
                    "Tổng kết\n" +
                    "Listen Carefully là một cuốn sách luyện thi IELTS khá lâu đời, tuy nhiên, sách sẽ giúp bạn rất nhiều trong việc luyện tập cải thiện Listening IELTS.  Đây là một trong những lựa chọn tuyệt vời nếu bạn là người mới bắt đầu học Tiếng Anh và đang tìm kiếm tài liệu để có thể tự ôn luyện kỹ năng nghe.\n" +
                    "\n" +
                    "LINK PDF + AUDIO:\n" +
                    "https://bitly.com.vn/o3vkbd\n" +
                    "\n" +
                    "2.Basic IELTS Listening\n" +
                    "\n" +
                    "Basic IELTS Listening cung cấp cho người học về cấu trúc và các dạng đề của bài thi IELTS Listening một cách tổng quan nhất. Cuốn sách này phù hợp với những người mới bắt đầu học IELTS và muốn làm quen với bài thi IELTS để ôn luyện.\n" +
                    "\n" +
                    "Ưu điểm\n" +
                    "\n" +
                    "Sách có được trình bày với bố cục rõ ràng và hợp lý. Trong đó, mỗi Unit có các mục cần lưu ý đều được làm nổi bật bằng cách đóng khung hay tô đậm. Điều này sẽ giúp cho người học dễ dàng ghi nhớ hơn.  \n" +
                    "\n" +
                    "Được sắp xếp theo mức độ từ dễ, căn bản đến khó theo từng chủ đề. Các chủ đề trong sách đều là các chủ đề phổ biến trong đề thi IELTS. Sách có 5 unit sau: Name and Places, Number, Survival English, Popular Science, Academic English.\n" +
                    "\n" +
                    "Hơn nữa, sách còn chia sẻ các tips, chiến lược làm bài hiệu quả cho người học với từng dạng bài sẽ xuất hiện ở phần thi Listening.\n" +
                    "\n" +
                    "Bài tập trong sách đa dạng và là các dạng đề thông dụng trong bài thi IELTS Listening. Điều này sẽ giúp người học làm quen với đề thi thật từ sớm.\n" +
                    "\n" +
                    "Ngoài ra, từ vựng, ngữ pháp và file nghe được sử dụng sách cũng quá khó học, phù hợp với trình độ của người học. Cuối sách cũng sẽ có Answer keys để bạn check lại đáp án, từ đó bạn hãy xem mình cuốn yếu phần nào để tập trung ôn luyện và cải thiện nó nhé.\n" +
                    "\n" +
                    "Cuối cùng, trong sách còn có một số hình ảnh minh họa, giúp người học hứng thú hơn khi đọc sách.\n" +
                    "\n" +
                    "Nhược điểm\n" +
                    "Đối tượng người học sách bị hạn chế ở trình độ A2.\n" +
                    "\n" +
                    "File audio của cuốn sách vẫn còn hạn chế về accents (giọng điệu), nó không hỗ trợ người học nhiều trong việc việc làm quen với các giọng điệu khác nhau. \n" +
                    "\n" +
                    "Tổng kết\n" +
                    "Basic IELTS Listening là 1 cuốn sách luyện thi IELTS phù hợp cho những người mới bắt đầu tìm hiểu về bài thi IELTS Listening, đồng thời muốn cải thiện Tiếng Anh. Để có cho mình một nền tảng vững chắc thì chắc chắn bạn không thể bỏ qua những cuốn sách này rồi.");
            articleSet.add(article11);

            Article article12 = new Article();
            article12.setId(12);
            article12.setTitle("6 SAI LẦM ĐIỂN HÌNH KHIẾN BẠN KHÔNG THỂ HỌC GIỎI TIẾNG ANH");
            article12.setContent("Việc học tiếng Anh chắc chắn sẽ khiến nhiều bạn gặp trở ngại, đặc biệt là những người bắt đầu từ con số 0. Muốn thành thạo một loại ngôn ngữ, bạn cần đặc biệt dành nhiều thời gian và sự quyết tâm cho nó. Nếu bạn thấy mình đã cố gắng học tuy nhiên kết quả vẫn dậm chân tại chỗ, và chưa được như mong muốn thì có lẽ bạn đang mắc phải một số lỗi cơ bản. Trong bài viết này AMES sẽ chỉ ra 6 lỗi sai điển hình bạn cần thay đổi ngay nếu muốn cải thiện tình hình học tập.\n" +
                    "1/ Không dành nhiều thời gian cho việc học tiếng Anh\n" +
                    "\n" +
                    "Như đã đề cập ở trên, việc học ngoại ngữ yêu cầu bạn phải đầu tư thời gian và thực sự cố gắng. Tuy nhiên thực trạng chung của những người mới học đó là chỉ dành thời gian học thụ động trên lớp và cất sách vở lại khi về nhà. Theo BBC, để một người thoát khỏi cảnh mất gốc tiếng Anh cần 120 tiếng học liên tục. Làm một phép tính đơn giản, nếu bạn dành 1 tiếng/ngày để học tiếng Anh, thì bạn sẽ mất 120 tiếng tương đương gần 4 tháng. Tuy nhiên tùy vào khả năng nhận thức của mỗi người, thời gian này có thể khác nhau. Có người chỉ mất một nửa thời gian đó, cũng có người sẽ mất tới 1 năm trời để có thể nắm bắt được tiếng Anh cơ bản.\n" +
                    "\n" +
                    "Để có thể thành thạo tiếng Anh bạn cần chủ động trong việc học của mình. Nếu bạn không dành ra được 1 tiếng mỗi ngày để tự học những kỹ năng nghe, nói, đọc, viết, việc học của bạn sẽ dậm chân tại chỗ đó.\n" +
                    "\n" +
                    "2/ Xấu hổ khi giao tiếp bằng tiếng Anh\n" +
                    "\n" +
                    "Tiếng Anh, cũng như các loại ngôn ngữ khác, mục đích chính của nó là giao tiếp. Vì vậy nếu bạn không tháo bỏ được cảm giác xấu hổ thì giao tiếp thì công sức học tập chẳng khác nào đổ sông đổ bể. Hãy cố gắng luyện tập thật nhiều để trở nên tự tin hơn, bạn càng tự tin giao tiếp trước nhiều người thì cảm giác xấu hổ càng nhanh biến mất. Bạn có thể luyện tập 1 mình hoặc luyện tập trước gương trước.\n" +
                    "\n" +
                    "3/ Quá tập trung vào ngữ pháp mà bỏ quên các kỹ năng khác\n" +
                    "\n" +
                    "Ngữ pháp là một phần vô cùng quan trọng trong tiếng Anh tuy nhiên việc dành quá nhiều thời gian để học ngữ pháp sẽ khiến quỹ thời gian cho các kỹ năng khác không có nhiều. Tiếng Anh giao tiếp sẽ không cần quá chú trọng tới ngữ pháp mà người ta thường để ý tới ngữ âm, ngữ điệu, cách nhấn nhá. Trong một cuộc hội thoại nhanh và dài bạn sẽ không có đủ thời gian để chú ý tới ngữ pháp, điều này sẽ khiến bạn trở nên ấp úng trước đối phương. Ngữ pháp có thể được trau dồi qua quá trình bạn học các kỹ năng nghe, nói, đọc, viết, vì vậy việc quá chú trọng vào ngữ pháp là lưỡi dao ảnh hưởng trực tiếp tới việc giao tiếp của bạn.\n" +
                    "\n" +
                    "Tuy nhiên sẽ là sai lầm nếu bạn bỏ qua hoàn toàn ngữ pháp. Chính vì vậy hãy tạo ra sự cân bằng cần thiết giữa việc giao tiếp và việc rèn luyện ngữ pháp.\n" +
                    "\n" +
                    "4/ Bỏ qua phần trọng âm\n" +
                    "\n" +
                    "Đây là một lỗi sai cực cơ bản mà hầu như ai cũng mắc phải. Tiếng Anh khác với tiếng Việt ở chỗ, tiếng Anh cần nhấn nhá nhiều. Đặc biệt việc nhấn nhá trọng âm cũng giúp bạn thể hiện cảm xúc của mình với người đối diện. Ngoài ra việc bỏ qua trọng âm sẽ dễ khiến người nghe hiểu nhầm nghĩa của từ. Bên cạnh đó, việc nhấn nhá và sử dụng trọng âm sẽ giúp bạn có chất giọng nghe “Tây” hơn, giống người bản xứ hơn. Nếu bạn không biết bắt đầu từ đâu, hãy sử dụng bảng phiên âm tiếng Anh IPA để học những âm cơ bản trước nhé.\n" +
                    "\n" +
                    "5/ Sử dụng phương pháp sai dẫn tới việc học tiếng Anh không đem lại hiệu quả\n" +
                    "\n" +
                    "Để đạt được hiệu quả tốt cần một phương pháp đúng đắn. Trên mạng có rất nhiều phương pháp, mỗi phương pháp lại đem lại hiệu quả khác nhau. Vì vậy hãy nghiên cứu thật kỹ trước khi lựa chọn phương pháp học tập để đem lại kết quả tốt nhất cho bạn. Bên cạnh đó, hãy kết hợp với lịch cá nhân cùng với thể trạng để lựa chọn được lối đi đúng đắn nhất. Một kế hoạch cụ thể ngay từ đầu sẽ phần nào giúp bạn không lạc lối trên con đường học tập.\n" +
                    "\n" +
                    "6/ Không có mục đích và định hướng học tập\n" +
                    "\n" +
                    "VIệc không có mục đích cụ thể cũng là nguyên nhân khiến kết quả học tập của bạn vẫn đứng yên tại chỗ. Nếu bạn không xác định được mình học để làm gì, học sẽ đem lại lợi ích gì cho mình thì bạn sẽ không thể cố gắng và quyết tâm được. Mục tiêu của bạn là đi du học? Đạt 7.5 IELTS? Hay đơn giản hơn là giao tiếp tiếng Anh thành thạo? Hãy đặt cho mình 1 mục tiêu cụ thể và từng bước phấn đấu đạt được nó. Đó sẽ là một quá trình dài đầy khó khăn, hãy cố gắng hết sức, không gì là không thể!");
            articleSet.add(article12);

            Article article13 = new Article();
            article13.setId(13);
            article13.setTitle("CHA MẸ KHÔNG THỂ BỎ LỠ ĐỘ TUỔI NÀY KHI CHO CON BẮT ĐẦU HỌC TIẾNG ANH");
            article13.setContent("Ngày nay, hầu hết các bậc phụ huynh đều nhận thấy tầm quan trọng của việc học ngoại ngữ, vì vậy ai cũng muốn cho con tiếp xúc với ngoại ngữ từ sớm. Nhưng thời điểm “sớm” đó là khi nào? Đâu là độ tuổi vàng cho con bắt đầu học ngoại ngữ thì không phải cha mẹ nào cũng biết.\n" +
                    "Độ tuổi vàng cho trẻ học tiếng Anh \n" +
                    "\n" +
                    "Cha mẹ ai cũng mong muốn con mình sẽ giỏi ngoại ngữ. Tuy nhiên để làm được điều này, quan trọng là cha mẹ cần biết nắm bắt thời cơ lý tưởng để bắt đầu cho con học tiếng Anh.\n" +
                    "\n" +
                    "Các chuyên gia cho rằng, độ tuổi vàng để trẻ học Tiếng Anh là từ 3 – 7 tuổi. Ở giai đoạn này, nếu trẻ được tiếp cận sớm với ngoại ngữ thì chúng sẽ tiếp thu kiến thức rất nhanh. Đây cũng được xem là độ tuổi lý tưởng để con có nền tảng vững chắc hỗ trợ cho việc học tiếng Anh sau này.\n" +
                    "\n" +
                    "Có thể nói, giai đoạn từ 3-7 tuổi là giai đoạn trẻ phát triển kỹ năng giao tiếp, lắng nghe, đặc biệt là khi con bắt chước, vì thế, con sẽ học ngoại ngữ rất nhanh. Lúc này, con đã có thể nghe chính xác âm và việc cho con học tiếng Anh như ngôn ngữ thứ 2 sẽ rất tốt. Điều này sẽ giúp con phát huy khả năng học nói tiếng Anh chuẩn như người bản xứ. Cha mẹ nên cho con tập nói, trò chuyện với trẻ thông qua các trò chơi, hoạt động hằng ngày, v.v\n" +
                    "\n" +
                    "Lợi ích khi cho trẻ học tiếng Anh ở độ tuổi vàng\n" +
                    "\n" +
                    "1. Trẻ có thể học song ngữ hiệu quả\n" +
                    "\n" +
                    "Các nghiên cứu chỉ ra rằng, nếu bé học cả 2 ngôn ngữ trước 6 tuổi sẽ có khả năng nghe, nói, đọc,viết và phân tích tốt hơn rất nhiều so với bé chỉ biết 1 ngôn ngữ. Vì thế, việc học thêm 1 ngoại ngữ cũng sẽ giúp bé biết thêm nhiều từ ở tiếng mẹ đẻ, giúp việc học song ngữ hiệu quả.\n" +
                    "\n" +
                    "2. Kích thích não bộ phát triển\n" +
                    "\n" +
                    "Bé có thể rèn luyện và kích thích trí não nếu trẻ biết nhiều ngoại ngữ. Các nghiên cứu cũng cho rằng, nếu trẻ học ngôn ngữ mới từ nhỏ, mật độ chất xám trong não bộ cũng sẽ tăng lên rất nhiều.\n" +
                    "\n" +
                    "3. Phát âm tiếng Anh chuẩn từ nhỏ\n" +
                    "\n" +
                    "Bé sẽ có thể phát âm chuẩn ngay từ nhỏ khi học đúng phương pháp, điều này sẽ tạo nền tảng cho việc nói tiếng Anh trôi chảy, lưu loát sau này. Đồng thời việc này cũng sẽ giúp bé trau dồi và tích lũy thêm kiến thức cho 4 kỹ năng Nghe – Nói – Đọc – Viết. \n" +
                    "\n" +
                    "4. Tự tin, độc lập trong giao tiếp\n" +
                    "\n" +
                    "Học tiếng Anh đúng độ tuổi vàng từ 3-7 tuổi này sẽ giúp trẻ làm quen và thích nghi với môi trường học từ bé. Từ đó, trẻ cũng sẽ có cơ hội thể hiện khả năng của mình nhiều hơn, xây dựng cho trẻ sự tự tin trong việc giao tiếp với mọi người xung quanh .\n" +
                    "\n" +
                    "Vì vậy, hãy để việc học “ĐÚNG PHƯƠNG PHÁP, ĐÚNG ĐỘ TUỔI” giúp con yêu đạt được những lợi ích về lâu dài, ba mẹ nhé!");
            articleSet.add(article13);

            Article article14 = new Article();
            article14.setId(14);
            article14.setTitle("ĐỪNG BỎ QUA 3 THỜI ĐIỂM NÀY NẾU BẠN MUỐN CẢI THIỆN TIẾNG ANH");
            article14.setContent("Nhiều người nghĩ rằng buổi sáng sẽ là khoảng thời gian tốt nhất trong ngày đã bắt tay vào học tập. Đây cũng là kết quả nghiên cứu của hai nhà tâm lý học  Pamela Thacher và Serge Onyper thuộc Đại học St Lawrence (Mỹ). Tuy nhiên theo nhiều nghiên cứu khoa học, khoảng thời gian thích hợp nhất để tiếp thu những kiến thức mới là 10-14h và 16-22h. Vậy phải làm thế nào để nắm bắt được thời điểm vàng trong ngày để ôn luyện tiếng Anh?\n" +
                    "1/ 5h-7h sáng: Thời điểm vàng để ghi nhớ từ vựng\n" +
                    "\n" +
                    "Khoảng thời gian từ 5-7h được xem là thời điểm tuyệt vời để học từ vựng. Các nghiên cứu cho thấy rằng, cơ thể con người sau khi nạp năng lượng từ một giấc ngủ sâu sẽ tạo ra cảm giác sảng khoái, thoải mái. Tâm lý này sẽ giúp chúng ta tỉnh táo và rất dễ tiếp thu những kiến thức mới. Ngoài ra đây cũng là thời điểm yên tĩnh nên việc tiếp thu cũng dễ dàng hơn khi con người đang ở trạng thái tập trung cao độ.\n" +
                    "\n" +
                    "Mặc dù đây là thời điểm vàng cho việc tiếp thu tuy nhiên bạn cũng không nên ôm đồm quá nhiều từ mới trong một buổi sáng. Hãy học 15-20 từ trong một lần, điều này sẽ giúp bạn ghi nhớ lâu hơn đó. Bên cạnh đó, hãy cố gắng đưa những từ vựng đó vào những ngữ cảnh cụ thể. Việc học từ vựng qua hình ảnh sẽ giúp não bộ ghi nhớ từ mới đó 2 lần, khi đặt vào ngữ cảnh tương tự, não bộ sẽ phản ứng nhanh hơn giúp bạn nhớ ngay ra từ vựng đó\n" +
                    "\n" +
                    "2/ 12h-13h: Thời gian tuyệt vời để luyện nghe\n" +
                    "\n" +
                    "Mặc dù đây là khoảng thời gian để nghỉ ngơi chuẩn bị cho một buổi chiều nhiều năng lượng, tuy nhiên bạn vẫn có thể tận dụng một cách khoa học để cải thiện kỹ năng nghe của mình. Bạn chỉ cần một chiếc tai nghe cùng với một chiếc điện thoại thông minh hoặc máy tính để có thể luyện nghe trong thời gian này. Bạn cũng có thể kết hợp vừa ăn trưa vừa nghe. Trong khoảng thời gian này, không cần quá tập trung tới việc dịch nghĩa mà bạn hãy cố gắng nghe ngữ điệu, cách phát âm, nhấn nhá của người bản xứ. Điều này còn có thể giúp ích cho bạn ở kỹ năng nói nữa đó. Hãy tận dụng một cách thông minh này nhưng đừng tiêu hết khoảng thời gian nghỉ ngơi của bạn. Cố gắng dành 15-20 phút cho việc luyện nghe là tuyệt vời rồi.\n" +
                    "\n" +
                    "3/ Sau 20h: Luyện tập tổng hợp\n" +
                    "\n" +
                    "Khoảng thời gian sau 20h là thời điểm mà não bộ hoạt động tốt nhất trong ngày. Não bộ sẽ ở trạng thái tư duy tốt và hoạt động rất hiệu quả, vì vậy bạn có thể kết hợp ôn tập 3 kỹ năng nói, đọc, viết vào thời điểm này. Hãy cố gắng sắp xếp hoàn thành công việc cá nhân để tránh ảnh hưởng tới việc ôn tập. Bạn có thể dành ra tới 2-3 tiếng buổi tối để tận dụng được khoảng thời gian thăng hoa của não bộ.\n" +
                    "\n" +
                    "Đây là những thời điểm được cho là vô cùng hiệu quả để bạn có thể cải thiện kỹ năng tiếng Anh của mình. Tuy nhiên bạn cũng có thể sắp xếp sao cho phù hợp với đồng hồ sinh học của cơ thể cũng như phù hợp với lịch trình cá nhân nhé. Ngoài ra tinh thần tự giác và chăm chỉ cũng là một yếu tố không thể thiếu. Hãy cố gắng hết sức để đạt được hiệu quả cao nhất nhé!");
            articleSet.add(article14);

            Article article15 = new Article();
            article15.setId(15);
            article15.setTitle("20 IDIOMS chủ đề FINANCE giúp tăng band điểm IELTS Speaking");
            article15.setContent("Chủ đề Tài chính hay Tiền bạc cũng là chủ đề rất gần gũi với cuộc sống và có khả năng xuất hiện trong bài thi IELTS Speaking.\n" +
                    "Vì vậy nếu bạn có vốn từ vựng nâng cao ở chủ đề này, bạn sẽ tăng khả năng dành được điểm cao từ người chấm thi.\n" +
                    "Trong bài viết này, AMES sẽ chia sẻ tới bạn những Idioms về chủ Finance nhé.\n" +
                    " \n" +
                    "\n" +
                    "1. To tighten one’s belt: Thắt lưng buộc bụng, ý chỉ sự tiết kiệm\n" +
                    "\n" +
                    "Ex: Living on my own during college taught me how to tighten my belt and get by on not very much.\n" +
                    "\n" +
                    "2. Daylight robbery: Cướp giữa ban ngày - ý chỉ giá cao cắt cổ\n" +
                    "\n" +
                    "Ex: I need to find another mechanic because this bill is just daylight robbery! I can't believe how much he charged for a simple repair.\n" +
                    "\n" +
                    "3. Almighty dollar: Thần tiền\n" +
                    "\n" +
                    "Ex: Everyone is ultimately motivated by self-interest and the pursuit of the almighty dollar.\n" +
                    "\n" +
                    "4. To be in the lap of luxury: Sống trong sự sung túc, giàu sang\n" +
                    "\n" +
                    "Ex: After winning the lottery, they moved to Paris so they could live in the lap of luxury.\n" +
                    "\n" +
                    "5. As phony as a $3 bill: Lừa đảo\n" +
                    "\n" +
                    "Ex: The course claims to teach you how to get rich in a hurry, but I can tell it's as phony as a three-dollar bill.\n" +
                    "\n" +
                    "6. A penny saved is a penny earned: Được sử dụng như một lời khuyên nhằm khuyên nhủ người khác không nên tiêu xài hoang phí\n" +
                    "\n" +
                    "Ex: I'm trying not to spend much money right now because, you know what they say, a penny saved is a penny earned.\n" +
                    "\n" +
                    "7. To make ends meet: Làm vừa đủ chi tiêu\n" +
                    "\n" +
                    "Ex: Through better budgeting, I am learning to make both ends meet.\n" +
                    "\n" +
                    "8. To be in the red: Tiêu nhiều hơn là kiếm được\n" +
                    "\n" +
                    "Ex: The company has been in the red for the last three quarters.\n" +
                    "\n" +
                    "9. A fool and his money are soon parted: Những người không suy nghĩ chín chắn, khờ dại, tiêu tiền phung phí\n" +
                    "\n" +
                    "Ex: Go ahead and buy a diamond collar for your dog if you really want to. A fool and his money are soon parted.\n" +
                    "\n" +
                    "10. Kill the goose that lays the golden eggs: Phá bỏ đi nguồn thu nhập chính\n" +
                    "\n" +
                    "Ex: Firing the programmer who created your most successful app is like killing the goose that lays the golden egg.\n" +
                    "\n" +
                    "11. Money talks: Ý chỉ sức mạnh của đồng tiền\n" +
                    "\n" +
                    "Ex: If you want us to help you out, here's some advice—money talks.\n" +
                    "\n" +
                    "12. Money doesn’t grow on trees: Tiền không mọc trên cây - ý chỉ kiếm được tiền không dễ dàng\n" +
                    "\n" +
                    "Ex: I can't believe you would spend your entire allowance on a silly video game. Money doesn't grow on trees, you know!\n" +
                    "\n" +
                    "13. Have money to burn: Ý chỉ ai đó có nhiều tiền và tiêu xài nhiều (theo nghĩa hoang phí)\n" +
                    "\n" +
                    "Ex: That upscale boutique caters to bored housewives who have money to burn—who else would spend $400 on a candle?\n" +
                    "\n" +
                    "14. All that glitters is not gold: Đừng đánh giá qua vẻ bề ngoài\n" +
                    "\n" +
                    "Ex: I don't know if that necklace from the flea market will have the resale value you're anticipating. All that glitters is not gold, you know.\n" +
                    "\n" +
                    "15. On a shoestring: Ý chỉ sự tiết kiệm, tránh lãng phí khi làm một việc gì đó\n" +
                    "\n" +
                    "Ex: We were living on a shoestring for a while after our baby was born, but, luckily, I got a promotion, and our situation has improved a bit.\n" +
                    "\n" +
                    "16. There’s no such thing as a free lunch: Không có gì là miễn phí\n" +
                    "\n" +
                    "Ex: I get to travel with my job but the downside is I have to give talks.\" \"Well, there's no such thing as a free lunch\n" +
                    "\n" +
                    "17. To cost an arm and a leg: Đắt tiền\n" +
                    "\n" +
                    "Ex: I'd love to buy a Porsche, but they cost an arm and a leg.\n" +
                    "\n" +
                    "18. To be in the black: Kiếm được nhiều hơn số tiền mà bạn tiêu\n" +
                    "\n" +
                    "Ex: This year our business is in the black.\n" +
                    "\n" +
                    "19. As poor as a church mouse: Rất nghèo\n" +
                    "\n" +
                    "Ex: They'll take one look at my clothes and know I'm as poor as a church mouse.\n" +
                    "\n" +
                    "20. A light purse is a heavy curse: Nghèo đói khiến con người không hạnh phúc\n" +
                    "\n" +
                    "Ex: I know you can't comprehend why there's so much depression, anxiety, and anger in this part of the country, but that's because you've never been forced to live in poverty. If you had, you'd understand that a light purse makes a heavy heart.");
            articleSet.add(article15);

            Article article16 = new Article();
            article16.setId(16);
            article16.setTitle("TOP 4 CUỐN SÁCH LUYỆN ĐỀ IELTS SĨ TỬ KHÔNG NÊN BỎ QUA");
            article16.setContent("Chuẩn bị cho kỳ thi IELTS cần rất nhiều quyết tâm, thời gian, tinh thần chăm chỉ và đương nhiên không thể thiếu được những cuốn sách ôn luyện. Ở bài viết này, AMES English sẽ chia sẻ với các bạn 4 đầu sách hay giúp các bạn có thể luyện bước đà tốt trong kì thi IELTS nhé. Đây là 4 cuốn sách được đánh giá rất cao và được tin dùng bởi rất nhiều học giả trên thế giới.\n" +
                    "1. Road to IELTS\n" +
                    "\n" +
                    "Road to IELTS là bộ tài liệu ôn tập được đánh giá khá sát với đề thi thật. Với cuốn sách này người sử dụng có thể luyện tập và tự đánh giá được trình độ của bản thân, từ đó sẽ tự định hình được kế hoạch cụ thể. \n" +
                    "\n" +
                    "Về tổng quan, đây là tài liệu cực hay dành cho mọi trình độ từ beginner đến advanced. Bạn hoàn toàn có thể sử dụng nó ở band 3.0 và có thể đạt được 9.0 nhờ sự trợ giúp từ Road to IELTS.\n" +
                    "\n" +
                    "2. The Official Cambridge Guide to IELTS\n" +
                    "\n" +
                    "The Official Cambridge guide to IELTS được viết bởi các tác giả Pauline Cullen cùng với Amanda French và Vanessa Jakeman, xuất bản ngày 30 tháng 4 năm 2014 dưới dạng bìa mềm. Sách được cung cấp bởi nhà xuất bản Cambridge cho cả 2 hình thức thi là Academic và General. Sách được chia cụ thể thành 3 phần:\n" +
                    "\n" +
                    "Phần 1: Giới thiệu tổng quan về kì thi IELTS bao gồm các nội dung thi, các kỹ năng thi, các tiêu chí đánh giá bài thi IELTS\n" +
                    "\n" +
                    "Phần 2: Phần này sẽ bao gồm các bài học theo 4 kỹ năng Nghe, Nói, Đọc, Viết. Mỗi bài học sẽ tập trung vào dạng bài cụ thể, truyền tải tới người đọc những kỹ năng mà dạng bài đó yêu cầu. Ngoài ra sách còn bổ sung cho người đọc cách làm bài cũng như chiến lược ôn tập và luyện thi hiệu quả cho từng dạng bài. Không những thế, các bài tập trong sách cũng được đưa ra cùng dạng giúp người học dễ dàng ôn tập và ghi nhớ những kiến thức đã được học.\n" +
                    "\n" +
                    "Phần 3: Đây là phần các bài kiểm tra. Sách có tổng cộng 8 bài kiểm tra giúp người sử dụng có thể luyện tập cho cả 4 kỹ năng. Các bài kiểm tra này đều dựa trên bài kiểm tra chính thức và sẽ có lời giải chi tiết cho từng câu. Bài đầu tiên sẽ giúp người sử dụng làm quen với sách nên sẽ đi kèm các gợi ý và hướng dẫn để “xử đẹp” dạng bài cụ thể.\n" +
                    "\n" +
                    "Cuốn sách sẽ mang đến những kiến thức cơ bản nhất cho người học về cấu trúc bài thi, các dạng đề, các dạng bài hay xuất hiện trong kì thi. Ngoài ra sách sẽ định hướng cho người sử dụng quá trình ôn tập hiệu quả nhất. Sách sẽ phù hợp cho người đang ở band 4.0 với mục tiêu đạt 6.5+.\n" +
                    "\n" +
                    "3. Cambridge IELTS Trainer 2\n" +
                    "\n" +
                    "IELTS Trainer 2 là cuốn sách của nhà xuất bản Cambridge, nơi được biết tới như một nguồn cung cấp những bài đánh giá năng lực chất lượng được công nhận bởi nhiều nơi trên thế giới. Cuốn IELTS Trainer 2 được xuất bản năm 2019 cho hình thức Học thuật. Sách bao gồm 6 bài thi với đầy đủ 4 kỹ năng Nghe, Nói, Đọc, Viết. IELTS Trainer 2 được chia làm 6 bài thi với 2 bài Training and Exam Test và 4 bài Practice Tests. Đối với các bài của phần Training and Exam Tests sẽ bao gồm các thông tin tổng quát về từng phần của bài thi. Người sử dụng sẽ được giới thiệu về yêu cầu của từng dạng bài và được hướng dẫn đưa ra kế hoạch học tập cụ thể. Ngoài ra người đọc sẽ được tiếp cận với các dạng bài có liên quan để làm quen với form đề thi, đồng thời trau dồi kiến thức đã được ôn luyện. Không những vậy người sử dụng còn được nhận những lời khuyên của chuyên giá về những lỗi sai phổ biến .\n" +
                    "\n" +
                    "Phần tiếp theo bạn sẽ được làm các bài thi để giúp vận dụng những kiến thức đã được học. Đối với các bài thi thực hành, bạn sẽ làm bài mà không có hướng dẫn và chiến lược kèm theo. Đây là cách mà cuốn sách giúp bạn vận dụng được tất cả các tips đã được học vào trong thực tế.\n" +
                    "\n" +
                    "Phần cuối cùng là đáp án sẽ được cung cấp tại Explanatory Answer key và có thể tải xuống tại esource.cambridge.org. Ngoài ra đáp án phần nghe và đọc sẽ được giải thích chi tiết ở từng đáp án.\n" +
                    "\n" +
                    "Cuốn sách phù hợp cho những người mục tiếu 6.0+ và đã có nền tảng ở mức band 5.0.\n" +
                    "\n" +
                    "4. IELTS Simulation Test\n" +
                    "\n" +
                    "Cuốn sách là sản phẩm của nhà xuất bản New Oriental, là hệ thống giáo dục lớn tại Trung Quốc. Đây cũng là nhà xuất bản uy tín hàng đầu trong lĩnh vực ôn tập cho các kì thi IELTS quốc tế như IELTS, SAT,..\n" +
                    "\n" +
                    "Sách được chia làm 3 phần trong đó:\n" +
                    "\n" +
                    "10 đề thi IELTS Academic\n" +
                    "\n" +
                    "2 đề thi IELTS General\n" +
                    "\n" +
                    "Đáp án và tapescript của bài nghe\n" +
                    "\n" +
                    "Với phần 10 đề thi IELTS Academic, mỗi đề sẽ bao gồm đầy đủ 4 kỹ năng được sắp xếp theo thứ tự. Đi kèm theo sách sẽ là 1 đĩa CD để phục vụ cho phần làm kỹ năng nghe. Phần ghi âm có tốc độ nhanh ở cuốn sách này sẽ có nhiều câu khó, tập trung ở section 4. Ngoài ra phần thi đọc ở cuốn sách này cần vận dụng nhiều kiến thức mới có thể đưa ra được các đáp án chính xác. Những đề thuộc cuốn sách này được đánh giá rất sát với đề thi thật, phù hợp cho việc ôn luyện.\n" +
                    "\n" +
                    "Ở phần 2 đề thi IELTS General, bài đọc sẽ ngắn hơn và có độ khó thấp hơn so với phần Academic. 2 đề này cũng sẽ bao gồm đầy đủ 4 kỹ năng Nghe, Nói, Đọc, Viết. Cuốn sách này chủ yếu dành cho mục đích ôn luyện IELTS Học thuật (Academic) nên phần luyện tập cho IELTS Tổng quan chỉ mang tính chất tham khảo.\n" +
                    "\n" +
                    "Cuối cùng là phần đáp án, người học có thể so sánh phần bài làm của mình với đáp án được cung cấp ở cuối sách. Các đáp án được viết rất chi tiết giúp người dùng nhận ra được lỗi sai của mình để khắc phục. Cuốn sách sẽ phù hợp cho những người đặt mục tiêu 6.0-6.5.");
            articleSet.add(article16);

            Article article17 = new Article();
            article17.setId(17);
            article17.setTitle("\"BÍ KÍP\" TỐI ƯU HÓA ĐIỂM THI IELTS SPEAKING");
            article17.setContent("Phần thi IELTS Speaking có lẽ là phần khiến nhiều thí sinh cảm thấy lo lắng nhất vì đây là bài thi mang nhiều yếu tố tâm lý khi phải ngồi đối diện với giám khảo chấm thi. Nhiều thí sinh khi luyện thi đạt được điểm rất cao nhưng không chuẩn bị kỹ về mặt tâm lý nên không nhận được kết quả như mong muốn trong ngày thi chính thức. Trong bài viết này, AMES English sẽ chia sẻ với các bạn 8 tips nhỏ rất hữu ích mà các bạn có thể áp dụng vào ngày thi IELTS Speaking của mình. \n" +
                    "\n" +
                    "Tip 1: Đừng cố gắng nhớ tất cả những câu trả lời mẫu\n" +
                    "\n" +
                    "Có rất nhiều những mẫu câu trả lời được gợi ý phù hợp với mọi câu hỏi tình huống trong phần thi Speaking part 1 và part 2. Tuy nhiên, việc lạm dụng những mẫu câu trả lời có sẵn sẽ khiến giám khảo không đánh giá chính xác được năng lực thực sự của bạn. Và nếu không may mắn bị giám khảo phát hiện bạn sử dụng mẫu câu có sẵn, sẽ rất bất lợi tới điểm số của bạn.\n" +
                    "\n" +
                    "Tip 2: Đừng cố gắng sử dụng những từ ngữ không phổ biến\n" +
                    "\n" +
                    "Nhiều thí sinh cố gắng sử dụng những cụm từ mới lạ, khác biệt nhằm đem lại sự bất ngờ trong bài thi của mình. Tuy nhiên việc sử dụng những từ ngữ không quen thuộc với bản thân có thể dẫn tới những hiểu nhầm hoặc sai sót nếu đặt không đúng ngữ cảnh. Vì vậy, thay vì cố gắng sử dụng những từ ngữ không phổ biến ấy, các bạn nên đưa vào bài nói của mình các phrasal verb, idioms, collocations,... mà các bạn có thể sử dụng một cách thuần thục.\n" +
                    "\n" +
                    "Tip 3: Cố gắng nghe thật kỹ ‘KEY WORD’\n" +
                    "\n" +
                    "Đây là kỹ năng giúp các bạn có thể xác định được nội dung câu hỏi và tránh lạc đề. Ví dụ câu hỏi mà giám khảo đưa ra là “Why do people like to visit different places in their free time?”. Từ khóa ở đây là ‘different’, nếu bạn không nắm bắt được từ khóa này sẽ dẫn đến trả lời lan man về lý do tại sao mọi người thích đi du lịch vào thời gian rảnh rỗi, và kết quả là câu trả lời của bạn không đúng với mục đích của câu hỏi.\n" +
                    "\n" +
                    "Tip 4: Trả lời đúng trọng tâm\n" +
                    "\n" +
                    "Nhiều bạn cho rằng câu trả lời càng dài sẽ càng nhận được điểm cao. Tuy nhiên, điều này chỉ có thể áp dụng với những thí sinh có khả năng nói tốt. Đối với những thí sinh có kỹ năng chưa tốt thì điều này sẽ dẫn đến nhiều sai sót trong câu từ. Vậy nên các bạn nên trả lời ngắn gọn đúng trọng tâm để hạn chế những sai sót về từ vựng và ngữ pháp nhé!\n" +
                    "\n" +
                    "Tip 5: Hãy sử dụng đa dạng những cấu trúc ngữ pháp khác nhau\n" +
                    "\n" +
                    "Khi chấm thi, giám khảo sẽ dựa trên 4 tiêu chí:\n" +
                    "\n" +
                    "Sự lưu loát, mạch lạc\n" +
                    "\n" +
                    "Vốn từ vựng\n" +
                    "\n" +
                    "Ngữ pháp và độ chính xác\n" +
                    "\n" +
                    "Phát âm\n" +
                    "\n" +
                    "Hãy cố gắng sử dụng linh hoạt các thì trong tiếng anh, các cấu trúc ngữ pháp từ đơn giản đến phức tạp để có thể truyền tải nội dung bài nói của mình một cách hiệu quả. Luyện nói với bạn bè hay tự thu âm cũng là những cách tối ưu để kiểm tra cách sử dụng ngữ pháp, cách phát âm của bản thân đó!\n" +
                    "\n" +
                    "Tip 6: Đừng im lặng khi suy nghĩ câu trả lời\n" +
                    "\n" +
                    "Việc bạn dừng lại để suy nghĩ không có gì sai, tuy nhiên hãy sử dụng vài câu nói để giám khảo biết bạn chưa kết thúc bài thi của mình. Những mẫu câu thông dụng mà bạn có thể áp dụng là:\n" +
                    "\n" +
                    "I have never thought about that, but…\n" +
                    "\n" +
                    "Let me see\n" +
                    "\n" +
                    "That’s a good point\n" +
                    "\n" +
                    "That’s a difficult question, but I’ll try and answer it\n" +
                    "\n" +
                    "Well, some people say that is the case, however, I think…\n" +
                    "\n" +
                    "Let me think about that for a minute\n" +
                    "\n" +
                    "Tip 7: Tránh sử dụng những từ đệm\n" +
                    "\n" +
                    "Sẽ có những lúc bạn phải dừng lại để suy nghĩ cho câu trả lời của mình. Đây sẽ khoảng thời gian khá bối rối và ấp úng, vì vậy bạn cần tránh sử dụng những từ đệm vì giám khảo sẽ cho rằng bạn không đủ vốn từ. Bạn cần tránh sử dụng những từ đệm sau:\n" +
                    "\n" +
                    "Ahh\n" +
                    "\n" +
                    "Uhm\n" +
                    "\n" +
                    "Well\n" +
                    "\n" +
                    "Yeah\n" +
                    "\n" +
                    "You Know\n" +
                    "\n" +
                    "Tip 8: Hãy mỉm cười\n" +
                    "\n" +
                    "Việc nở một nụ cười tươi có thể giúp bạn trở nên tự tin hơn, và có thể một phần cải thiện được kỹ năng phát âm của mình. Hãy nhớ nở một nụ cười tươi khi trả lời với giám khảo chấm thi nhé!\n" +
                    "\n" +
                    "Trên đây là những tips hữu ích nên áp dụng vào ngày thi IELTS Speaking, hy vọng các bạn có thể ứng dụng vào bài thi của mình để đạt được kết quả như mong muốn!");
            articleSet.add(article17);

            Article article18 = new Article();
            article18.setId(18);
            article18.setTitle("PHƯƠNG PHÁP KHUYẾN KHÍCH TRẺ TỰ TIN NÓI TIẾNG ANH");
            article18.setContent("1. Hãy học cùng con\n" +
                    "Khi ba mẹ học cùng con sẽ giúp con có thêm động lực và cảm hứng. Người ta thường nói trẻ con là tấm gương phản chiếu của cha mẹ. Vì vậy, khi nhìn thấy ba mẹ của mình đọc sách, xem phim và giao tiếp bằng tiếng Anh, trẻ sẽ cảm thấy hứng thú hơn để học theo.\n" +
                    "\n" +
                    "Thay vì bắt trẻ tự học thì ba mẹ nên tham gia vào quá trình học Tiếng Anh của con một cách chủ động. Để giúp trẻ có thêm động lực học và giao tiếp Tiếng Anh một cách tự tin thì ba mẹ nên khen ngợi những nỗ lực của con trẻ, động viên hay hỗ trợ con trong quá trình học. Nếu như có ba mẹ là người đồng hành thì sẽ giúp con tự tin hơn rất nhiều !\n" +
                    "\n" +
                    "2. Đừng sửa lỗi khi trẻ đang nói\n" +
                    "\n" +
                    "Khi thấy trẻ phát âm sai thì ba mẹ không nên ngắt lời trẻ và yêu cầu con sửa lại ngay vì điều này sẽ khiến trẻ thiếu tự tin khi nói Tiếng Anh, dẫn đến việc trẻ sợ mắc lỗi và ngại sử dụng Tiếng Anh. \n" +
                    "\n" +
                    "Vì thế, hãy lắng nghe trẻ nói, đợi con nói hết, không ngắt lời của con. Nếu muốn giúp trẻ sửa lỗi sai, ba mẹ hãy nói: “ Con nghe bố/mẹ nói nhé...\", hoặc các bạn chỉ nói lại từ trẻ phát âm sai, và chúng sẽ bắt chước và đọc theo. Nên tránh sử dụng những câu như \"Con nói sai rồi...\",  \"Từ này không nói như vậy...\", \"Con phải nói thế này...\"\n" +
                    "\n" +
                    "3. Tạo ra các tình huống thú vị\n" +
                    "\n" +
                    "Ba mẹ nên khuyến khích trẻ giao tiếp bằng tiếng Anh thông qua các tình huống. Ví dụ như đóng vai người mua hàng, nhân viên bán hàng cần sự giúp đỡ bằng tiếng Anh khi đi trên xe buýt, hay tại nhà hàng,v.v. \n" +
                    "\n" +
                    "Việc trẻ học tiếng Anh qua các tình huống như vậy sẽ giúp trẻ phản xạ tốt hơn và tạo động lực cho trẻ, giúp trẻ tăng sự tự tin khi nói tiếng Anh. Và sau này trẻ có thể áp dụng vào thực tế trong cuộc sống.\n" +
                    "\n" +
                    "4. Tìm cách để trẻ giao tiếp bằng tiếng Anh\n" +
                    "\n" +
                    "Khi gặp các tình huống giao tiếp thực tế thì trẻ sẽ có động lực sử dụng tiếng Anh hơn. Để trẻ tăng sự tự tin khi giao tiếp Tiếng Anh thì ba mẹ có thể đăng ký cho bé những lớp học Tiếng Anh phù hợp với trình độ.\n" +
                    "\n" +
                    "Đây là một môi trường lý tưởng để con có thể phát triển bản thân, tăng khả năng phản xạ Tiếng Anh, và giúp bé phát âm chuẩn, nói Tiếng Anh một cách trôi chảy và tự nhiên hơn.");
            articleSet.add(article18);

            Article article19 = new Article();
            article19.setId(19);
            article19.setTitle("HỌC TỪ VỰNG IELTS VỚI PHƯƠNG PHÁP SPACED REPETITION");
            article19.setContent("Trong những phương pháp học từ vựng phổ biến như dùng flashcards, học theo ngữ cảnh, sử dụng sơ đồ tư duy,...bạn đã từng nghe đến phương pháp Spaced Repetition? Để biết được phương pháp này là gì cũng như cách áp dụng phương pháp này ra sao trong việc học từ vựng tiếng Anh nói chung và học từ vựng IELTS nói riêng, các bạn hãy đọc bài viết này thật kỹ nha!\n" +
                    "\n" +
                    "1. Phương pháp Spaced Repetition là gì?\n" +
                    "Spaced Repetition hay còn gọi là phương pháp Lặp lại ngắt quãng được hiểu đơn giản là cách học ngắt quãng thời gian, người học sẽ ôn đi ôn lại những kiến thức đã học từ trước. \n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "2. Tại sao nên áp dụng phương pháp Spaced Repetition?\n" +
                    "Phương pháp Spaced Repetition nổi trội hơn những phương pháp học từ vựng khác ở những điểm sau:\n" +
                    "\n" +
                    "Giúp người học khắc phục được tình trạng quên lãng sau khi tiếp nhận một lượng từ vựng lớn.\n" +
                    "\n" +
                    "Giúp người học dễ dàng lấy lại những kiến thức từ vựng đã quên và ghi nhớ từ vựng mới một cách nhanh chóng.\n" +
                    "\n" +
                    "Giúp người học phân loại được từ vựng theo mức độ dễ – trung bình – khó để người học không học tràn lan mà chỉ phân bổ thời gian và công sức tập trung vào những từ vựng khó.\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "3. Áp dụng phương pháp Spaced Repetition như thế nào?\n" +
                    "Để áp dụng phương pháp Spaced Repetition đạt hiệu quả tối ưu, các bạn hãy làm theo các bước sau:\n" +
                    "\n" +
                    "Làm một bộ flashcards cho các từ vựng cần học (bạn có thể mua flashcards hoặc tự viết). Nếu bạn tự làm flashcards thì nhớ viết cả phát âm, nghĩa và ví dụ kèm theo từ vựng ấy nhé!\n" +
                    "\n" +
                    "Chuẩn bị 5 hộp rỗng để đựng flashcards vừa chuẩn bị (Nhớ đánh số hộp để đỡ bị nhầm nha).\n" +
                    "\n" +
                    "Bỏ hết flashcards mới cần học vào hộp 1 và bắt đầu học (Cách học là bạn sẽ xem từng flashcard rồi ghi nhớ từ vựng trong đó).\n" +
                    "\n" +
                    "Sau đó, tự kiểm tra xem bạn đã nhớ các từ vựng ở hộp 1 chưa. Từ nào nhớ rồi thì bỏ nó sang hộp 2, còn từ nào chưa nhớ thì vẫn để ở hộp 1.\n" +
                    "\n" +
                    "Lặp lại quá trình tương tự với các hộp tiếp theo. Ví dụ, ở hộp 2, những flashcards trả lời đúng sẽ được di chuyển sang hộp 3, những từ trả lời sai sẽ bị đưa về hộp 1. Cứ như thế cho đến khi tất cả các flashcards của bạn đến được hộp 5, đồng nghĩa với việc đã kết thúc chu kỳ ôn tập.\n" +
                    "\n" +
                    "Để tránh bối rối và khó tìm được khoảng thời gian ôn tập hợp lý cho mỗi hộp từ vựng, bạn nên có một lịch trình cụ thể ghi chép lại thời gian nào cần ôn hộp nào. Ví dụ, bạn sẽ ôn lại hộp thứ 2 sau mỗi 3 ngày, hộp thứ 3 sau mỗi 5 ngày,…");
            articleSet.add(article19);

            Article article20 = new Article();
            article20.setId(20);
            article20.setTitle("Chứng chỉ IELTS giúp thí sinh có cơ hội trúng tuyển vào nhiều trường đại học?");
            article20.setContent("Nhiều trường ĐH, học viện xét tuyển chứng chỉ kết hợp trong mùa tuyển sinh 2021, tạo điều kiện giúp thí sinh có nhiều cơ hội khi xét tuyển vào những trường, ngành học cạnh tranh.\n" +
                    "Tuyển sinh bằng các chứng chỉ tiếng Anh quốc tế là phương thức được nhiều trường Đại học lớn trên thế giới sử dụng. Ở nước ta, từ năm 2018, rất nhiều trường đại học ở Việt Nam cũng đã bổ sung phương thức này trong quy chế tuyển sinh, tạo điều kiện giúp các em học giỏi Tiếng Anh có nhiều cơ hội khi xét tuyển vào những trường, ngành học cạnh tranh.\n" +
                    "\n" +
                    "Cùng với đó, trong những năm gần đây, Bộ GD-ĐT cũng triển khai nhiều hình thức, phương thức tuyển sinh mới, đặc biệt là những bạn có điểm tiếng Anh IELTS từ 4.0 trở lên hay TOEFL iBT 45 điểm được miễn thi Ngoại ngữ trong xét công nhận tốt nghiệp THPT Quốc gia.\n" +
                    "\n" +
                    "Trong năm 2021, nếu đạt chứng chỉ IELTS với điểm số từ 4.0 – 6.5, các thí sinh sẽ có cơ hội trúng tuyển vào nhiều trường đại học trên toàn quốc.\n" +
                    "\n" +
                    "1. ĐH Bách khoa Hà Nội\n" +
                    "Trong các phương án tuyển sinh của Trường ĐH Bách khoa Hà Nội, trường đưa ra phương án xét tuyển thẳng đối với những thí sinh có chứng chỉ IELTS Academic đạt từ 6.5 trở lên (hoặc tương đương) và có điểm trung bình chung học tập từng năm học lớp 10, 11, 12 đạt 8.0 trở lên. Nếu đạt những yêu cầu này, thí sinh sẽ được xét tuyển thẳng vào các ngành Ngôn ngữ Anh và Kinh tế quản lý.\n" +
                    "\n" +
                    "2. ĐH Công nghiệp Hà Nội\n" +
                    "Năm 2021, Trường ĐH Công nghiệp Hà Nội sẽ xét tuyển với những thí sinh có điểm trung bình các môn của từng học kỳ lớp 10, 11, 12 đạt từ 7 trở lên và có chứng chỉ IELTS Academic từ 5.5 trở lên.\n" +
                    "\n" +
                    "Với những đối tượng này, điểm xét tuyển được tính theo công thức: Điểm xét tuyển = (Điểm quy đổi từ chứng chỉ hoặc giải) x 2 + Điểm trung bình chung các học kỳ lớp 10, 11, 12 + Điểm ưu tiên (nếu có).\n" +
                    "\n" +
                    "Trong đó, nếu đạt 5.5 IELTS sẽ tương đương 8 điểm quy đổi; 6.0 IELTS tương đương 9 điểm quy đổi; IELTS 6.5 – 9.0 tương đương 10 điểm quy đổi.\n" +
                    "\n" +
                    "Tổng chỉ tiêu đối với các thí sinh đoạt giải học sinh giỏi cấp tỉnh/thành phố và thí sinh có chứng chỉ quốc tế dự kiến là 350. Trường sẽ xét từ cao xuống thấp cho tới khi hết chỉ tiêu.\n" +
                    "\n" +
                    "3. Học viện Chính sách và Phát triển\n" +
                    "Học viện Chính sách và Phát triển cũng tuyển thẳng thí sinh có chứng chỉ IELTS từ 4.5 trở lên (hoặc tương đương) và có điểm trung bình chung học tập lớp 12 đạt từ 7 trở lên.\n" +
                    "\n" +
                    "4. ĐH Giao thông Vận tải Hà Nội\n" +
                    "Trường ĐH Giao thông Vận tải sẽ xét tuyển kết hợp (áp dụng với các chương trình tiên tiến chất lượng cao) đối với những thí sinh có chứng chỉ IELTS từ 5.0 trở lên và có tổng điểm 2 môn thi tốt nghiệp THPT năm 2021 thuộc tổ hợp xét tuyển đạt từ 12 điểm trở lên (trong đó có môn Toán và 1 môn khác không phải Ngoại ngữ).\n" +
                    "\n" +
                    "5. ĐH FPT\n" +
                    "Trường ĐH FPT cũng tuyển những thí sinh có chứng chỉ IELTS Academic từ 6.0 hoặc quy đổi tương đương (áp dụng đối với ngành Ngôn Ngữ Anh).\n" +
                    "\n" +
                    "Trong khi đó, Học viện Nông nghiệp Việt Nam tuyển thí sinh có học lực đạt loại Khá ít nhất 1 năm tại các trường THPT và có điểm chứng chỉ IELTS đạt từ 4.0 điểm trở lên.\n" +
                    "\n" +
                    "6. ĐH Mỏ - Địa Chất\n" +
                    "Trường ĐH Mỏ - Địa Chất cũng tuyển thí sinh có chứng chỉ IELTS đạt từ 4.5 trở lên và có tổng điểm 2 môn thi tốt nghiệp THPT theo tổ hợp môn xét tuyển của trường (trừ môn thi Tiếng Anh) đạt từ 10 điểm trở lên, trong đó có môn thi Toán. Số lượng thí sinh tuyển theo hình thức này không chiếm quá 2% tổng chỉ tiêu tuyển sinh.\n" +
                    "\n" +
                    "7. ĐH Kinh tế Quốc dân\n" +
                    "Xét tuyển kết hợp theo đề án tuyển sinh của Trường, trong đó có kết hợp điểm thi tốt nghiệp THPT và Chứng chỉ Tiếng Anh quốc tế. Năm 2021, trường chưa thông báo cụ thể nhưng theo năm 2020, yêu cầu IELTS từ 5.5 trở lên cùng điểm thi tốt nghiệp 2 môn (Toán và 1 môn bất kỳ trừ TA) đạt từ 14 điểm trở lên (gồm điểm ưu tiên). Năm 2019, lại yêu cầu IELTS từ 6.5 trở lên.\n" +
                    "\n" +
                    "8. ĐH Mỏ Địa chất\n" +
                    "Xét tuyển thẳng cho HSG các cấp quốc gia quốc tế, thí sinh có chứng chỉ tiếng anh quốc tế còn thời hạn, thí sinh có 4,5 IELTS trở lên, TOEFL ITP đạt 450 trở lên, TOEFL iBT 53 trở lên và có môn Toán và một môn thi tốt nghiệp đạt điểm 10. Phương thức này lấy 2% tổng chỉ tiêu.\n" +
                    "\n" +
                    "9. Học viện Phụ nữ Việt Nam\n" +
                    "Học viện Phụ nữ Việt Nam cũng xét tuyển thẳng thí sinh có chứng chỉ tiếng Anh quốc tế còn giá trị sử dụng tính đến ngày xét tuyển, tương đương IELTS 5.5 trở lên.\n" +
                    "\n" +
                    "10. ĐH Thương mại\n" +
                    "Theo phương án tuyển sinh của Trường ĐH Thương mại trong năm 2021, trường này cũng xét tuyển kết hợp dựa vào kết quả trong kỳ thi tốt nghiệp THPT hoặc kết quả học bạ và chứng chỉ tiếng Anh IELTS Academic. Tuy nhiên, hiện nhà trường chưa đưa ra mức điểm cụ thể cần đạt với hình thức xét tuyển kết hợp này.\n" +
                    "\n" +
                    "11. ĐH Quốc gia Hà Nội\n" +
                    "ĐH Quốc gia Hà Nội dự kiến cũng sẽ xét tuyển đối với những thí sinh có điểm chứng chỉ tiếng Anh quốc tế IELTS từ 5.5 trở lên và có tổng điểm 2 môn thi còn lại trong tổ hợp xét tuyển tại kỳ thi tốt nghiệp THPT năm 2021 đạt tối thiểu 12 điểm.\n" +
                    "\n" +
                    "12. ĐH Sư phạm Kỹ thuật TP.HCM\n" +
                    "Xét tuyển thẳng, ưu tiên xét tuyển thẳng của trường ĐH Sư phạm kỹ thuật TP HCM năm 2021.\n" +
                    "\n" +
                    "- Các ngành đại trà hoặc CLC, điểm trung bình học bạ 5 học kỳ của từng môn theo tổ hợp từ 6,0 trở lên, IELTS từ 5.0 trở lên.\n" +
                    "\n" +
                    "- Sư phạm tiếng Anh và Ngôn ngữ Anh, điểm trung bình học bạ 5 học kỳ của từng môn theo tổ hợp từ 6,0 trở lên, IELTS từ 6.0 trở lên.\n" +
                    "\n" +
                    "13. ĐH Phenikaa\n" +
                    "Trường ĐH Phenikaa cũng tuyển thẳng những học sinh tốt nghiệp THPT và có chứng chỉ tiếng Anh quốc tế  tương đương IELTS từ 5.5 trở lên; đồng thời có tổng điểm trung bình lớp 10, lớp 11 và học kỳ 1 lớp 12 của tổ hợp môn xét tuyển bằng kết quả học tập bậc THPT đạt từ 22.5 điểm trở lên.\n" +
                    "\n" +
                    "14. ĐH Luật TP.HCM\n" +
                    "Ưu tiên xét tuyển thẳng thí sinh có chứng chỉ Tiếng Anh IELTS đạt điểm từ 5,0 trở lên còn giá trị đến ngày 30-6-2021 và phải có điểm trung bình của 5 học kỳ THPT (trừ học kỳ 2 lớp 12) của 3 môn thuộc tổ hợp đăng ký xét tuyển đạt tổng điểm từ 21 trở lên.\n" +
                    "\n" +
                    "15. ĐH Ngân hàng TP.HCM\n" +
                    "Ưu tiên xét tuyển và xét học bạ theo quy chế xét tuyển của trường, áp dụng cho chương trình chất lượng cao và 85 chỉ tiêu Chương trình Đại học Chính quy Quốc tế song bằng. Thí sinh có IELTS từ 5.0 trở lên.\n" +
                    "\n" +
                    "16. ĐH Ngoại thương\n" +
                    "Trường ĐH Ngoại thương hiện nay chưa phê duyệt Đề án tuyển sinh năm 2021. Tuy nhiên, về chủ trương, nhà trường cơ bản sẽ vẫn giữ 5 phương thức tuyển sinh của năm 2020, trong đó có xét tuyển kết hợp giữa chứng chỉ ngoại ngữ quốc tế và kết quả học tập dành cho thí sinh hệ chuyên và hệ không chuyên; xét tuyển kết hợp giữa chứng chỉ ngoại ngữ quốc tế và kết quả thi THPT.\n" +
                    "\n" +
                    "Năm ngoái, muốn đăng ký vào các chương trình giảng dạy bằng tiếng Anh, điều kiện để thí sinh đăng ký xét tuyển là phải có chứng chỉ IELTS Academic từ 6.5 trở lên hoặc các chứng chỉ ngoại ngữ quốc tế tương đương; cùng các yêu cầu cụ thể khác về điểm trung bình chung học tập.\n" +
                    "\n" +
                    "17. ĐH Tôn Đức Thắng\n" +
                    "Ưu tiên xét tuyển theo quy định của TDTU. Thí sinh có chứng chỉ IELTS ≥ 5.0 (hoặc chứng chỉ quốc tế tương đương) còn thời hạn trong vòng 2 năm tính đến ngày 01/10/2021 xét tuyển thẳng vào chương trình đại học bằng tiếng Anh, hoàn tất chương trình lớp 12 bậc THPT năm 2021 và tốt nghiệp THPT năm 2021.");
            articleSet.add(article20);

            articleRepository.saveAll(articleSet);
        }
    }
}