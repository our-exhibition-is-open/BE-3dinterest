package com.team2._3dinterest.domain.yugyeong.upload.service;

import com.team2._3dinterest.global.common.s3.AmazonS3ResourceStorage;
import com.team2._3dinterest.domain.yugyeong.upload.dto.FileMetadataDto;
import com.team2._3dinterest.domain.yugyeong.upload.dto.RequestUploadDto;
import com.team2._3dinterest.domain.yugyeong.entity.PostEntity;
import com.team2._3dinterest.domain.yugyeong.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UploadService {
    private final AmazonS3ResourceStorage amazonS3ResourceStorage;
    private final PostRepository postRepository;

    @Transactional
    public int save(MultipartFile image, MultipartFile model, RequestUploadDto requestUploadDto) {

        // model
        FileMetadataDto metadataModelDto = FileMetadataDto.multipartOf(model);
        String model_uuid = metadataModelDto.getPath(); // model 파일의 이름을 uuid로 변환
        amazonS3ResourceStorage.store(model_uuid, model); // model s3 업로드

        // image
        FileMetadataDto metadataImageDto = FileMetadataDto.multipartOf(image);
        String image_uuid = metadataImageDto.getPath(); // image 파일의 이름을 uuid로 변환
        amazonS3ResourceStorage.store(image_uuid, image); // image s3 업로드

        LocalDateTime upload_date = metadataModelDto.getUpload_date(); // 업로드 시간을 model을 기준으로 한다.

        PostEntity postEntity = PostEntity.toEntity(requestUploadDto, model_uuid, image_uuid, upload_date); // Dto를 UploadEntity로 변환
        postRepository.save(postEntity);

        int post_id = postEntity.getPostId();

        return post_id;
    }
}