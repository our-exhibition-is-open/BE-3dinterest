package com.team2._3dinterest.domain.yugyeong.repository;

import com.team2._3dinterest.domain.yugyeong.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    PostEntity findByPostId(int postId);    // download에서 post_table의 postId 조회
}