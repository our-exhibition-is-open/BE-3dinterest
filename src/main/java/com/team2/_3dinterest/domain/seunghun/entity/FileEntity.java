package com.team2._3dinterest.domain.seunghun.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "post_table")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;

    @Column(name = "user_id")
    private String userId;

    private String title;
    private String model_uuid;
    private String image_uuid;
    private boolean tag_a;
    private boolean tag_b;
    private boolean tag_c;
    private boolean tag_d;
    private int like_cnt;

    @Column(name = "upload_date")
    private LocalDateTime upload_date;

}
