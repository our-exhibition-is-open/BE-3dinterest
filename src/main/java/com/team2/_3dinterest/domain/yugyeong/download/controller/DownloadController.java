package com.team2._3dinterest.domain.yugyeong.download.controller;

import com.team2._3dinterest.domain.yugyeong.download.dto.RequestDownloadDto;
import com.team2._3dinterest.domain.yugyeong.download.service.DownloadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/download",
                consumes = {MediaType.APPLICATION_JSON_VALUE} )
@RequiredArgsConstructor
public class DownloadController {
    private final DownloadService downloadService;

    @PostMapping
    public String download(@Valid @RequestBody RequestDownloadDto requestDownloadDto) {
        return downloadService.download(requestDownloadDto);
    }
}