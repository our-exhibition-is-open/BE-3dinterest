package com.team2._3dinterest.domain.seunghun.repository;

import com.team2._3dinterest.domain.seunghun.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFileRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByUserId(String userId);
    List<UserEntity> findByPostId(String postId);
}