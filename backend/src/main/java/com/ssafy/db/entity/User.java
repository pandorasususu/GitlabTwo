package com.ssafy.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table (name = "user")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    int userId;

    @Column(name = "user_email")
    String userEmail;

    @Column(name = "user_nickname")
    String userNickname;

    @Column(name = "user_img")
    String userImg;

    public User(String email, String nickname, String img) {
        this.userEmail = email;
        this.userNickname = nickname;
        this.userImg = img;
    }
}
