package com.team2._3dinterest.domain.yugyeong.postlist.service;

import com.team2._3dinterest.domain.yugyeong.entity.PostEntity;
import com.team2._3dinterest.domain.yugyeong.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostListService {
    private final PostRepository postRepository;

    @Transactional
    public ResponseEntity<List<PostEntity>> postlist() {
        try {
            List<PostEntity> postEntities = postRepository.findAll();
            return ResponseEntity.ok(postEntities); // 성공, 200 OK 생성

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("게시물 조회 중 오류가 발생했습니다.");
        }
    }
}