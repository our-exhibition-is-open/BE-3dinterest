package com.team2._3dinterest.domain.seunghun.repository;

import com.team2._3dinterest.domain.seunghun.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserFileRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByUserId(Long user_id);
    List<UserEntity> findByPostID(String postID);
    // 다음과 같이 findPostIDsByParentID 메서드를 추가


}