package com.team2._3dinterest.domain.yugyeong.repository;

import com.team2._3dinterest.domain.yugyeong.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    PostEntity findByPostId(int postId);
}