package com.ssafy.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "music_recommend")

public class MusicRec {

    @Id
    @Column(name = "music_recommend_id")
    int musicRecommendId;
    @Column(name = "user_id")
    int userId;
    @Column(name = "music")
    String music;

    public MusicRec(int userId) {
        this.userId = userId;
    }


    public MusicRec() {

    }
}
