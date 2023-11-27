package com.team2._3dinterest.domain.seunghun.user;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_table")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "tag_a_cnt")
    private int tagACnt;

    @Column(name = "tag_b_cnt")
    private int tagBCnt;

    @Column(name = "tag_c_cnt")
    private int tagCCnt;

    @Column(name = "tag_d_cnt")
    private int tagDCnt;

    // 추가 필드 및 메서드는 필요에 따라 정의
}
