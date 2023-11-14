package com.team2._3dinterest.domain.yugyeong.upload.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="post_table")
@Getter
@Setter
public class UploadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;

    private String user_id; // 자동 생성
    private String file_url;
    private boolean tagA;
    private boolean tagB;
    private boolean tagC;
    private boolean tagD;
    private int like_cnt; // 자동 생성
    private String upload_date;
}
