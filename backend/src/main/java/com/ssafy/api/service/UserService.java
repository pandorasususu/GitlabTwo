package com.ssafy.api.service;

import com.ssafy.db.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User getUserByUserEmail(String userEmail);

    User createUser(String email, String nickname, String img);
}
