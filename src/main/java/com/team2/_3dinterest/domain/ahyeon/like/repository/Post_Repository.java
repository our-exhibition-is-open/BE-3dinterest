package com.team2._3dinterest.domain.ahyeon.like.repository;


import com.team2._3dinterest.domain.ahyeon.like.entity.Post_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Post_Repository extends JpaRepository<Post_Entity, Integer> {
//@Transactional
   // void updateLikeCnt(int postId, int likeCnt);
    // 다른 쿼리 메서드 또는 필요한 메서드 추가 가능

}
