package com.team2._3dinterest.domain.seunghun.repository;

import com.team2._3dinterest.domain.seunghun.user.UserFile;
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
    private String parentID;

    private String id;      // 36자리의 UUID
    private String name;    // 파일 업로드 시점의 파일명
    private String format;  // 파일 확장자
    private String path;    // 파일의 실제 물리적 경로값
    private long bytes;     // 바이트

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    public static ResponseFileDto from(UserFile userFile) {
        ResponseFileDto responseFileDto = ResponseFileDto.builder()
                .parentID(userFile.getFileDetail().getParentID())
                .id(userFile.getFileDetail().getParentID())
                .name(userFile.getFileDetail().getName())
                .format(userFile.getFileDetail().getFormat())
                .path(userFile.getFileDetail().getPath())
                .bytes(userFile.getFileDetail().getBytes())
                .createdAt(userFile.getFileDetail().getCreatedAt())
                .build();
        return responseFileDto;
    }
}