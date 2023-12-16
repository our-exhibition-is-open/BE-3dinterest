package com.team2._3dinterest.domain.yugyeong.contribute.service;

import com.team2._3dinterest.domain.yugyeong.entity.DownloadEntity;
import com.team2._3dinterest.domain.yugyeong.entity.PostEntity;
import com.team2._3dinterest.domain.yugyeong.repository.DownloadRepository;
import com.team2._3dinterest.domain.yugyeong.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContributeListService {
    private final PostRepository postRepository;
    private final DownloadRepository downloadRepository;

    @Transactional
    public ResponseEntity<List<PostEntity>> list(String user_id) {
        try {
            // download_history_table에서 user_id를 조회 후 해당하는 DownloadEntity(다운로드 기록)를 가져온다.
            List<DownloadEntity> downloadEntities = downloadRepository.findByUserId(user_id);

            List<PostEntity> postEntities = new ArrayList<>();

            for (DownloadEntity downloadEntity : downloadEntities) {
                // download_history_table에서 일치하는 user_id를 찾아 해당 post_id를 모두 가져온다.
                PostEntity download_post_id = downloadEntity.getPostId();

                // post_table에서 download의 post_id와 일치하는 post_id의 PostEntity를 가져온다.
                PostEntity postEntity = postRepository.findByPostId(download_post_id.getPostId());

                if (postEntity != null) {
                    postEntities.add(postEntity);
                }
            }
            return ResponseEntity.ok(postEntities);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("컨트리뷰트 조회 중에 오류가 발생했습니다.");
        }
    }
}