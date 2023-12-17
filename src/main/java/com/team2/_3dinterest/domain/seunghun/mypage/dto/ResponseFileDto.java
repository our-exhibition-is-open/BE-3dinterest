package com.team2._3dinterest.domain.seunghun.mypage.dto;

import com.team2._3dinterest.domain.seunghun.entity.ContributeEntity;
import lombok.*;

import java.time.LocalDateTime;
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

    public static ResponseFileDto from(ContributeEntity userEntity) {
        return ResponseFileDto.builder()
                .id(userEntity.getuserId())
                .name(userEntity.getTitle())
                .path(userEntity.getImage_uuid())  // 이미지 URL을 path로 사용하는 예시입니다. 필요에 따라 수정해주세요
                .createdAt(userEntity.getUpload_date())
                .build();
    }
}
