package com.team2._3dinterest.domain.ahyeon.user;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_table")
public class UserEntity {

    @Id
    @Column(name = "user_id", nullable = false, length = 100)
    private String userId;

    @Column(name = "user_password", nullable = false, length = 100)
    private String userPassword;

    @Column(name = "tag_a_cnt", nullable = false)
    private int tagACnt;

    // 생성자, getter, setter 등 필요한 메서드 추가

    // 기본 생성자
    public UserEntity() {
    }

    // 매개변수를 받는 생성자
    public UserEntity(String userId, String userPassword, int tagACnt) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.tagACnt = tagACnt;
    }

    // getter 및 setter 메서드는 필요에 따라 추가
    // toString, equals, hashCode 등의 메서드도 필요에 따라 추가
}
