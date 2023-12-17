package com.team2._3dinterest.domain.seunghun.mypage.dto;

import com.team2._3dinterest.domain.seunghun.entity.UserEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class UserEntityDTO {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private int tagACnt;
    private int tagBCnt;
    private int tagCCnt;
    private int tagDCnt;
    private int likeCnt;

    private String image;
    private List<String> fileList;
    private String parentID;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    public static UserEntityDTO from(UserEntity userEntity) {
        return UserEntityDTO.builder()
                // 필요한 필드들을 SiteUser에서 가져와서 설정
                .userId(Long.valueOf(userEntity.getUserId()))
                .userName(userEntity.getUserName())
                .userEmail(userEntity.getUserEmail())
                .tagACnt(userEntity.getTagACnt())
                .tagBCnt(userEntity.getTagBCnt())
                .tagCCnt(userEntity.getTagCCnt())
                .tagDCnt(userEntity.getTagDCnt())
                // 추가 필드에 대한 설정도 필요하다면 여기에 추가
                .build();
    }

}
