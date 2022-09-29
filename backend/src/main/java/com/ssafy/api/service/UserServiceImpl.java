package com.ssafy.api.service;

import com.ssafy.db.entity.User;
import com.ssafy.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public User getUserByUserEmail(String userEmail) {
        User user = userRepository.getUserByUserEmail(userEmail);
        return user;
    }

    @Override
    public User createUser(String email, String nickname, String img) {
        User user = new User(email, nickname, img);
        userRepository.save(user);
        return user;
    }
}
