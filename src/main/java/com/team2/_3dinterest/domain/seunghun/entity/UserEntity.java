package com.team2._3dinterest.domain.seunghun.user;

import jakarta.persistence.*;
import lombok.*;





@Entity
@Table(name = "user_table")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private String userId;

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

}
