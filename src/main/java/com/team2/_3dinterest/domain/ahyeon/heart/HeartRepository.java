package com.team2._3dinterest.domain.ahyeon.heart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRepository extends JpaRepository<HeartEntity, Long>
{
    HeartEntity findByPostIdAndUserId(Long postId, String userId);
}