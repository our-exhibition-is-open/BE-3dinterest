package com.team2._3dinterest.domain.ahyeon.post.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDto {

    private int postId;
    private String userId;
    private int likeCnt;
    private String title;
    private String imageUrl;
    private String modelUrl;
    private LocalDateTime uploadDate;


}