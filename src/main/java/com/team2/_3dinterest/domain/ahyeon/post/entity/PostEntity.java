package com.team2._3dinterest.domain.ahyeon.post.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="post_table")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false, updatable = false)
    private Long postId;
    private int likes;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "model_url", nullable = false)
    private String modelUrl;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "tag_a", nullable = false)
    private boolean tagA;

    @Column(name = "tag_b", nullable = false)
    private boolean tagB;

    @Column(name = "tag_c", nullable = false)
    private boolean tagC;

    @Column(name = "tag_d", nullable = false)
    private boolean tagD;

    @Column(name = "like_cnt", nullable = false)
    private int likeCnt;

    @Column(name = "upload_date", nullable = false)
    private LocalDateTime uploadDate;


    // 생성자, Getter, Setter, 기타 메서드 생략
}
