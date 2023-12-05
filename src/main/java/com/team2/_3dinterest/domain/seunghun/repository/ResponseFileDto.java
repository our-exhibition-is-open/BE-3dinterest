package com.team2._3dinterest.domain.seunghun.repository;

import com.team2._3dinterest.domain.seunghun.user.UserEntity;
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

    public static ResponseFileDto from(UserEntity userEntity) {
        return ResponseFileDto.builder()
                .parentID(userEntity.getPostId().toString())
                .id(userEntity.getPostId().toString())
                .name(userEntity.getTitle())
                .format("unknown")  // 파일 확장자 정보가 없어서 임의의 값을 넣었습니다. 실제로는 파일 업로드 로직에서 추출해야 합니다.
                .path(userEntity.getImage_url())  // 이미지 URL을 path로 사용하는 예시입니다. 필요에 따라 수정해주세요.
                .bytes(0)  // 파일 크기 정보가 없어서 임의의 값을 넣었습니다.
                .createdAt(userEntity.getUpload_date())
                .build();
    }
}
