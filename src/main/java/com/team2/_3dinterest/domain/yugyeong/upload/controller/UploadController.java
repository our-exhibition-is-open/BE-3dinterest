package com.team2._3dinterest.domain.yugyeong.upload.controller;

import com.team2._3dinterest.domain.yugyeong.upload.dto.ResponseFileDto;
import com.team2._3dinterest.domain.yugyeong.upload.dto.RequestUploadDto;
import com.team2._3dinterest.domain.yugyeong.upload.service.FileUploadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping(value = "/upload",
        consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE} )
@RequiredArgsConstructor
public class UploadController {
    private final FileUploadService fileUploadService;

    @PostMapping
    public ResponseEntity<List<ResponseFileDto>> post(
            @Valid @RequestPart(value =  "image") MultipartFile image,
            @Valid @RequestPart(value =  "file") List<MultipartFile> fileList,
            @Valid @RequestPart(value = "requestUploadDto") RequestUploadDto requestUploadDto) {

         return ResponseEntity.ok(fileUploadService.save(image, fileList, requestUploadDto)); // 성공, 200 OK 생성
    }
}