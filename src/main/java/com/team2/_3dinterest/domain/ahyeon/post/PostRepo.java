package com.team2._3dinterest.domain.ahyeon.post;


import com.team2._3dinterest.domain.ahyeon.post.entity.PostEnti;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<PostEnti, Integer> {
//@Transactional
   // void updateLikeCnt(int postId, int likeCnt);
    // 다른 쿼리 메서드 또는 필요한 메서드 추가 가능

}
