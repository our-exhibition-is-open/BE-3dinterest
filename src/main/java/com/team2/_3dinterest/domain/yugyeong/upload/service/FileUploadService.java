package com.team2._3dinterest.domain.yugyeong.upload.service;

import com.team2._3dinterest.domain.yugyeong.upload.AmazonS3ResourceStorage;
import com.team2._3dinterest.domain.yugyeong.upload.dto.ResponseFileDto;
import com.team2._3dinterest.domain.yugyeong.upload.dto.RequestUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileUploadService {
    private final AmazonS3ResourceStorage amazonS3ResourceStorage;

    public List<ResponseFileDto> save(MultipartFile image, List<MultipartFile> fileList, RequestUploadDto requestUploadDto) {
        List<ResponseFileDto> responseFileDtoList = ResponseFileDto.multipartOf(fileList); // File들에 대한 정보를 저장

        // model
        for (int i = 0; i < fileList.size(); i++) {
            MultipartFile file = fileList.get(i);
            ResponseFileDto responseFileDto = responseFileDtoList.get(i);

            amazonS3ResourceStorage.store(responseFileDto.getModel_path(), file); // model 업로드
        }

        // image
        ResponseFileDto responseImage = ResponseFileDto.ResponseImage(image); // File들에 대한 정보를 저장
        responseFileDtoList.add(responseImage);
        amazonS3ResourceStorage.store(responseImage.getImage_path(), image); // image 업로드

        return responseFileDtoList;
    }
}