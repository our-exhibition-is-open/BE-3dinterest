package com.team2._3dinterest.domain.yugyeong.upload.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="post_table")
@Getter
public class UploadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;

    private String user_id;
    private String model_url;
    private String image_url;
    private boolean tag_a;
    private boolean tag_b;
    private boolean tag_c;
    private boolean tag_d;
    private int like_cnt;
    private String upload_date;
}