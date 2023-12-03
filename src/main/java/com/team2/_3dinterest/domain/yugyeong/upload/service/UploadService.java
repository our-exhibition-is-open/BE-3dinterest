package com.team2._3dinterest.domain.yugyeong.upload.service;

import com.team2._3dinterest.domain.yugyeong.upload.s3.AmazonS3ResourceStorage;
import com.team2._3dinterest.domain.yugyeong.upload.dto.ResponseUploadDto;
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
    public ResponseUploadDto save(MultipartFile image, MultipartFile model, RequestUploadDto requestUploadDto) {

        // model
        ResponseUploadDto responseModelDto = ResponseUploadDto.multipartOf(model);
        String model_url = responseModelDto.getPath();
        amazonS3ResourceStorage.store(model_url, model); // model s3 업로드

        // image
        ResponseUploadDto responseImageDto = ResponseUploadDto.multipartOf(image); // file에 대한 정보를 저장
        String image_url = responseImageDto.getPath();
        amazonS3ResourceStorage.store(image_url, image); // image s3 업로드

        LocalDateTime upload_date = responseModelDto.getUpload_date();

        PostEntity postEntity = PostEntity.toEntity(requestUploadDto, model_url, image_url, upload_date); // Dto를 UploadEntity로 변환
        postRepository.save(postEntity);

        return responseModelDto;
    }
}