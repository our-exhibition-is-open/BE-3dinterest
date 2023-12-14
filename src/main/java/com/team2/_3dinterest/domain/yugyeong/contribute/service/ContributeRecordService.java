package com.team2._3dinterest.domain.yugyeong.contribute.service;

import com.team2._3dinterest.domain.yugyeong.entity.ContributeEntity;
import com.team2._3dinterest.domain.yugyeong.entity.PostEntity;
import com.team2._3dinterest.domain.yugyeong.repository.ContributeRepository;
import com.team2._3dinterest.domain.yugyeong.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContributeRecordService {
    private final PostRepository postRepository;
    private final ContributeRepository contributeRepository;

    @Transactional
    public ResponseEntity<Void> record(int post_id, int parent_id) {
        // 부모 엔터티 조회
        PostEntity parentEntity = postRepository.findByPostId(parent_id);

        if (parentEntity == null) {
            // 부모 엔터티가 존재하지 않을 경우 예외 처리
            return ResponseEntity.notFound().build();
        }

        // ContributeEntity 생성 및 저장
        ContributeEntity contributeEntity = ContributeEntity.builder()
                .post_id(post_id)
                .parent_id(parentEntity)
                .build();

        contributeRepository.save(contributeEntity);

        return ResponseEntity.ok().build();
    }
}