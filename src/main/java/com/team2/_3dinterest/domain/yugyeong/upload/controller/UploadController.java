package com.team2._3dinterest.domain.yugyeong.upload.controller;

import com.team2._3dinterest.domain.yugyeong.upload.service.FileDetail;
import com.team2._3dinterest.domain.yugyeong.upload.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UploadController {
    private final FileUploadService fileUploadService;

    @PostMapping
    public ResponseEntity<FileDetail> post(
            @RequestParam("title") String title,                            // 제목
            @RequestParam("userName") String userName,                      // 업로드한 사람
            @RequestParam("tagA") boolean tagA,                             // 태그A
            @RequestParam("tagB") boolean tagB,                             // 태그B
            @RequestParam("tagC") boolean tagC,                             // 태그C
            @RequestParam("tagD") boolean tagD,                             // 태그D
            @RequestPart("file") MultipartFile uploadImg,                   // 업로드 이미지
            @RequestPart("file") List<MultipartFile> fileList) {   // 3D 파일

        try {
            checkRequiredParameters(title, userName, tagA, tagB, tagC, tagD, uploadImg, fileList);
            return ResponseEntity.ok(fileUploadService.save(title, userName, tagA, tagB, tagC, tagD, uploadImg, fileList)); // 성공, 200 OK 생성
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // 매개변수 부족, 400 BAD_REQUEST 생성
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // 서버 에러, 500 INTERNAL_SERVER_ERROR 생성
        }
    }

    // 매개변수 체크
    private void checkRequiredParameters(String title, String userName, boolean tagA, boolean tagB, boolean tagC, boolean tagD, MultipartFile uploadImg, List<MultipartFile> multipartFileList) throws IllegalArgumentException {
        if (title == null || userName == null || uploadImg == null || multipartFileList == null) {
            throw new IllegalArgumentException("All required parameters must be provided.");
        }
    }
}