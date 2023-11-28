package com.team2._3dinterest.domain.yugyeong.upload.service;

import com.team2._3dinterest.domain.yugyeong.upload.s3.AmazonS3ResourceStorage;
import com.team2._3dinterest.domain.yugyeong.upload.dto.ResponseFileDto;
import com.team2._3dinterest.domain.yugyeong.upload.dto.RequestUploadDto;
import com.team2._3dinterest.domain.yugyeong.upload.entity.UploadEntity;
import com.team2._3dinterest.domain.yugyeong.upload.repository.UploadRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FileUploadService {
    private final AmazonS3ResourceStorage amazonS3ResourceStorage;
    private final UploadRepository uploadRepository;

    @Transactional
    public ResponseFileDto save(MultipartFile image, MultipartFile model, RequestUploadDto requestUploadDto) {

        // model
        ResponseFileDto responseModelDto = ResponseFileDto.multipartOf(model);
        String model_url = responseModelDto.getPath();
        amazonS3ResourceStorage.store(model_url, model); // model s3 업로드

        // image
        ResponseFileDto responseImageDto = ResponseFileDto.multipartOf(image); // file에 대한 정보를 저장
        String image_url = responseImageDto.getPath();
        amazonS3ResourceStorage.store(image_url, image); // image s3 업로드

        LocalDateTime upload_date = responseModelDto.getUpload_date();

        UploadEntity uploadEntity = UploadEntity.toEntity(requestUploadDto, model_url, image_url, upload_date); // Dto를 UploadEntity로 변환
        uploadRepository.save(uploadEntity);

        return responseModelDto;
    }
}