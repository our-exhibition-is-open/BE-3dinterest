

package com.team2._3dinterest.domain.ahyeon.heart;


//import com.team2._3dinterest.domain.ahyeon.post.entity.PostEntity;
//import com.team2._3dinterest.domain.ahyeon.user.UserEntity;
//import jakarta.persistence.*;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "like_table")

public class HeartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long heartId;

    @Column(name = "post_id")
    private Long postId;

    @Column(name = "user_id", length = 100)
    private String userId;

    // 생성자, getter, setter 등 필요한 메서드 추가

    public HeartEntity() {
    }

    public HeartEntity(Long postId, String userId) {
        this.postId = postId;
        this.userId = userId;
    }

    public void setHeartId(Long heartId) {
        this.heartId = heartId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setUserId(String userId) {
        this.userId = String.valueOf(userId);
    }
}