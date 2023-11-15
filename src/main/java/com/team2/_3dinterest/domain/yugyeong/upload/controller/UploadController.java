package com.team2._3dinterest.domain.yugyeong.upload.controller;

import com.team2._3dinterest.domain.yugyeong.upload.dto.FileDetail;
import com.team2._3dinterest.domain.yugyeong.upload.dto.PostFileDto;
import com.team2._3dinterest.domain.yugyeong.upload.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UploadController {
    private final FileUploadService fileUploadService;

    @PostMapping
    public ResponseEntity<FileDetail> post(
            @RequestPart PostFileDto postFileDto) {

        try {
            checkRequiredParameters(postFileDto);
            return ResponseEntity.ok(fileUploadService.save(postFileDto)); // 성공, 200 OK 생성
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // 매개변수 부족, 400 BAD_REQUEST 생성
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // 서버 에러, 500 INTERNAL_SERVER_ERROR 생성
        }
    }

    // 매개변수 체크
    private void checkRequiredParameters(PostFileDto postFileDto) throws IllegalArgumentException {
        if (postFileDto.getTitle() == null
                || postFileDto.getUserName() == null
                || postFileDto.getUploadImage() == null
                || postFileDto.getFileList() == null) {
            throw new IllegalArgumentException("All required parameters must be provided.");
        }
    }
}