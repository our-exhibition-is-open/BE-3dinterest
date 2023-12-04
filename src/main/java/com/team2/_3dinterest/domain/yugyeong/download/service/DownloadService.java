package com.team2._3dinterest.domain.yugyeong.download.service;

import com.team2._3dinterest.domain.yugyeong.download.dto.RequestDownloadDto;
import com.team2._3dinterest.domain.yugyeong.entity.DownloadEntity;
import com.team2._3dinterest.domain.yugyeong.repository.DownloadRepository;
import com.team2._3dinterest.domain.yugyeong.entity.PostEntity;
import com.team2._3dinterest.domain.yugyeong.repository.PostRepository;
import com.team2._3dinterest.global.common.s3.S3Download;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DownloadService {
    private final DownloadRepository downloadRepository;
    private final PostRepository postRepository;
    private final S3Download s3Download;

    @Transactional
    public ResponseEntity<byte[]> download(RequestDownloadDto requestDownloadDto) {
        try {
            // post_id를 조회 후 해당하는 PostEntity를 가져온다.
            PostEntity postEntity = postRepository.findByPostId(requestDownloadDto.getPost_id());

        if (postEntity != null) {
            // DownloadEntity 생성 및 저장
            DownloadEntity downloadEntity = DownloadEntity.builder()
                    .user_id(requestDownloadDto.getUser_id())
                    .postId(postEntity)
                    .build();

            downloadRepository.save(downloadEntity);

                // S3에서 모델을 다운로드하고 처리하는 로직을 구현
                // String original_name = postEntity.getOriginal_name();
                String model_url = postEntity.getModel_url();

                return s3Download.getObject(model_url); // s3에서 다운로드 후 byte 배열 반환
            } else {
                // post_id에 해당하는 정보가 없을 경우 예외 처리
                throw new EntityNotFoundException("post_id에 해당하는 정보가 없습니다.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("모델 다운로드 중에 오류가 발생했습니다.");
        }
    }
}