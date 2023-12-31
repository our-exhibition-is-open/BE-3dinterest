package com.team2._3dinterest.domain.yugyeong.upload.controller;

import com.team2._3dinterest.domain.yugyeong.upload.dto.RequestUploadDto;
import com.team2._3dinterest.domain.yugyeong.upload.service.UploadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping( value = "/upload",
                consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE} )
@RequiredArgsConstructor
public class UploadController {
    private final UploadService uploadService;

    @PostMapping
    public ResponseEntity<Integer> post(
            @Valid @RequestPart(value = "image") MultipartFile image,
            @Valid @RequestPart(value = "model") MultipartFile model,
            @Valid @RequestPart(value = "requestUploadDto") RequestUploadDto requestUploadDto) {

        return ResponseEntity.ok(uploadService.save(image, model, requestUploadDto)); // 성공, 200 OK 생성
    }
}