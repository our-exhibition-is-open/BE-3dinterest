package com.team2._3dinterest.domain.yugyeong.upload.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Data
public class PostFileDto {
    private String title;
    private String userName;
    private boolean tagA;
    private boolean tagB;
    private boolean tagC;
    private boolean tagD;
    private MultipartFile uploadImage;
    private List<MultipartFile> fileList;

    @Builder
    public PostFileDto(String title, String userName,
                       boolean tagA, boolean tagB, boolean tagC, boolean tagD,
                       MultipartFile uploadImage, List<MultipartFile> fileList) {
        this.title = title;
        this.userName = userName;
        this.tagA = tagA;
        this.tagB = tagB;
        this.tagC = tagC;
        this.tagD = tagD;
        this.uploadImage = uploadImage;
        this.fileList = fileList;
    }
}

