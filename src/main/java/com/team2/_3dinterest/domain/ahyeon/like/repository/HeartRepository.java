package com.team2._3dinterest.domain.ahyeon.like.repository;

import com.team2._3dinterest.domain.ahyeon.like.entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRepository extends JpaRepository<LikeEntity, Long>
{
    LikeEntity findByPostIdAndUserId(int postId, String userId);
}