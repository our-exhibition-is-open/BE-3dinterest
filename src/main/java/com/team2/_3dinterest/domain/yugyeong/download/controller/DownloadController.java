package com.team2._3dinterest.domain.yugyeong.download.controller;

import com.team2._3dinterest.domain.yugyeong.download.dto.RequestDownloadDto;
import com.team2._3dinterest.domain.yugyeong.download.service.DownloadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/download" )
@RequiredArgsConstructor
public class DownloadController {
    private final DownloadService downloadService;

    @GetMapping
    public ResponseEntity<byte[]> download(
            @RequestParam(name = "post_id") int post_id,
            @RequestParam(name = "user_id") String user_id) {
        RequestDownloadDto requestDownloadDto = new RequestDownloadDto();
        requestDownloadDto.setPost_id(post_id);
        requestDownloadDto.setUser_id(user_id);

        return downloadService.download(requestDownloadDto);
    }
}