package com.team2._3dinterest.domain.seunghun.repository;

import com.team2._3dinterest.domain.seunghun.user.SiteUser;
import com.team2._3dinterest.domain.seunghun.user.UserEntity;
import lombok.*;

import javax.persistence.Column;
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

    public static UserEntityDTO from(SiteUser siteUser) {
        return UserEntityDTO.builder()
                // 필요한 필드들을 SiteUser에서 가져와서 설정
                .userId(Long.valueOf(siteUser.getUserId()))
                .userName(siteUser.getUserName())
                .userEmail(siteUser.getUserEmail())
                .tagACnt(siteUser.getTagACnt())
                .tagBCnt(siteUser.getTagBCnt())
                .tagCCnt(siteUser.getTagCCnt())
                .tagDCnt(siteUser.getTagDCnt())
                // 추가 필드에 대한 설정도 필요하다면 여기에 추가
                .build();
    }
}
