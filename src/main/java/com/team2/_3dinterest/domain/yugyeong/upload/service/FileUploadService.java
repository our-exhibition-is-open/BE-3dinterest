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

    public List<ResponseFileDto> save(RequestUploadDto requestUploadDto) {
        List<MultipartFile> fileList = requestUploadDto.getFileList();                      // RequestUploadDto의 File들을 List 형태로 저장
        List<ResponseFileDto> responseFileDtoList = ResponseFileDto.multipartOf(fileList);  // File들에 대한 정보를 저장

        MultipartFile uploadImage = requestUploadDto.getUploadImage();
        ResponseFileDto responseImage = ResponseFileDto.ResponseImage(uploadImage);
        responseFileDtoList.add(responseImage);                                             // 썸네일 업로드

        // path 정보와 file을 s3에 저장
        for (int i = 0; i < fileList.size(); i++) {
            MultipartFile file = fileList.get(i);
            ResponseFileDto responseFileDto = responseFileDtoList.get(i);

            amazonS3ResourceStorage.store(responseFileDto.getPath(), file); // 파일, 썸네일 업로드
        }

        return responseFileDtoList;
    }
}