package com.team2._3dinterest.domain.ahyeon.like.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "like_table")

public class LikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private int heartId;

    @Column(name = "post_id")
    private int postId;

    @Column(name = "user_id", length = 100)
    private String userId;

    // 생성자, getter, setter 등 필요한 메서드 추가

    public LikeEntity() {
    }

    public LikeEntity(int postId, String userId) {
        this.postId = postId;
        this.userId = userId;
    }

    public void setHeartId(int heartId) {
        this.heartId = heartId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setUserId(String userId) {
        this.userId = String.valueOf(userId);
    }


}