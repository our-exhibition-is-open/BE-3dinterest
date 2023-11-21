package com.team2._3dinterest.domain.seunghun.repository;

import com.team2._3dinterest.global.util.MultipartUtil;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class ResponseFileDto {
    private String image;
    private List<String> fileList;

    private String id;      // 36자리의 UUID
    private String name;    // 파일 업로드 시점의 파일명
    private String format;  // 파일 확장자
    private String path;    // 파일의 실제 물리적 경로값
    private long bytes;     // 바이트

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    public static List<com.team2._3dinterest.domain.yugyeong.upload.dto.ResponseFileDto> multipartOf(List<MultipartFile> fileList) {
        List<com.team2._3dinterest.domain.yugyeong.upload.dto.ResponseFileDto> responseFileDtoList = new ArrayList<>();

        for (MultipartFile file : fileList) {
            final String fileId = MultipartUtil.createUUID();
            final String format = MultipartUtil.getFormat(file.getContentType());

            com.team2._3dinterest.domain.yugyeong.upload.dto.ResponseFileDto responseFileDto = com.team2._3dinterest.domain.yugyeong.upload.dto.ResponseFileDto.builder()
                    .id(fileId)
                    .name(file.getOriginalFilename())
                    .format(format)
                    .path(MultipartUtil.createPath(fileId, format))
                    .bytes(file.getSize())
                    .build();

            responseFileDtoList.add(responseFileDto);
        }
        return responseFileDtoList;
    }

    public static com.team2._3dinterest.domain.yugyeong.upload.dto.ResponseFileDto ResponseImage(MultipartFile image) {
        final String fileId = MultipartUtil.createUUID();
        final String format = MultipartUtil.getFormat(image.getContentType());

        return com.team2._3dinterest.domain.yugyeong.upload.dto.ResponseFileDto.builder()
                .id(fileId)
                .name(image.getOriginalFilename())
                .format(format)
                .path(MultipartUtil.createPath(fileId, format))
                .bytes(image.getSize())
                .build();
    }
}