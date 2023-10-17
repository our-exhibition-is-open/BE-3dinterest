package com.team2._3dinterest.domain.yugyeong.upload.dto;

import com.team2._3dinterest.global.util.MultipartUtil;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class FileDetail {
    private String id;      // 36자리의 UUID
    private String name;    // 파일 업로드 시점의 파일명
    private String format;  // 파일 확장자
    private String path;    // 파일의 실제 물리적 경로값
    private long bytes;     // 바이트

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    public static FileDetail multipartOf(MultipartFile multipartFile) {
        final String fileId = MultipartUtil.createFileId();
        final String format = MultipartUtil.getFormat(multipartFile.getContentType());
        return FileDetail.builder()
                .id(fileId)
                .name(multipartFile.getOriginalFilename())
                .format(format)
                .path(MultipartUtil.createPath(fileId, format))
                .bytes(multipartFile.getSize())
                .build();
    }
}