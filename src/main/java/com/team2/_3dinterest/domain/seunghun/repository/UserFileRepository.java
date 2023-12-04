package com.team2._3dinterest.domain.seunghun.repository;

import com.team2._3dinterest.domain.seunghun.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFileRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByUserId(String user_id);
    List<UserEntity> findByPostId(String post_iD);
    // 다음과 같이 findPostIDsByParentID 메서드를 추가


}