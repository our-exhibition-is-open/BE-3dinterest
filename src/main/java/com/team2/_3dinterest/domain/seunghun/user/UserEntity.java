package com.team2._3dinterest.domain.seunghun.user;

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
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private String postId;

    @Column(name = "user_id")
    private String userId;

    private String title;
    private String model_url;
    private String image_url;
    private String tag_a;
    private String tag_b;
    private String tag_c;
    private String tag_d;
    private int like_cnt;

    @Column(name = "upload_date")
    private LocalDateTime upload_date;

}
