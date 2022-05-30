package com.example.englishappbackend.service.user;

import com.example.englishappbackend.entity.User;
import com.example.englishappbackend.enums.UserStatus;
import com.example.englishappbackend.repo.UserRepository;
import com.example.englishappbackend.service.user.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    final
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> getAllUser(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return userRepository.findAll(pageRequest);
    }

    @Override
    public User userDetail(int user_id) {
        Optional<User> user = userRepository.findById(user_id);
        return user.orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int user_id, User user) {
        Optional<User> userExist = userRepository.findById(user_id);
        if (userExist.isPresent()){
            userExist.get().setEmail(user.getEmail());
            userExist.get().setPhone(user.getPhone());
            userExist.get().setFullName(user.getFullName());
            return userRepository.save(userExist.get());
        }
        return null;
    }

    @Override
    public User getToken(int user_id, String token  ) {
        Optional<User> user = userRepository.findById(user_id);
        if (user.isPresent()){
            user.get().setUserDeviceToken(token);
            return userRepository.save(user.get());
        }
        return null;
    }

    @Override
    public User setRemindTime(int user_id, int start_time, int end_time) {
        return null;
    }

    @Override
    public User deleteUser(int user_id){
        Optional<User> userExist = userRepository.findById(user_id);
        if (userExist.isPresent()){
            userExist.get().setStatus(UserStatus.NON_ACTIVATED);
            return userRepository.save(userExist.get());
        }
        return null;
    }
}
