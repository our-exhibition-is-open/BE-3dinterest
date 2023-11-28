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
    public List<ResponseFileDto> save(MultipartFile image, List<MultipartFile> fileList, RequestUploadDto requestUploadDto) {
        List<ResponseFileDto> responseFileDtoList = ResponseFileDto.multipartOf(fileList); // File들에 대한 정보를 저장

        // model
        ResponseFileDto responseModelDto = ResponseFileDto.multipartOf(model);
        String model_url = responseModelDto.getPath();
        amazonS3ResourceStorage.store(model_url, model); // model s3 업로드

        // image
        ResponseFileDto responseImage = ResponseFileDto.ResponseImage(image); // File들에 대한 정보를 저장

        responseFileDtoList.add(responseImage);
        amazonS3ResourceStorage.store(responseImage.getImage_path(), image); // image s3 업로드

        // Dto를 UploadEntity로 변환
        UploadEntity uploadEntity = UploadEntity.toEntity(requestUploadDto, responseImage);
        uploadRepository.save(uploadEntity);

        return responseModelDto;
    }
}