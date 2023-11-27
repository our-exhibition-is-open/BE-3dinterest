package com.team2._3dinterest.domain.seunghun.user;

import lombok.*;

import javax.persistence.*;
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
    private Long postId;

    @Column(name = "user_id")
    private Long userId;

    private String title;
    private String modelUrl;
    private String imageUrl;
    private String tagA;
    private String tagB;
    private String tagC;
    private String tagD;
    private int likeCnt;

    @Column(name = "upload_date")
    private LocalDateTime uploadDate;

}
