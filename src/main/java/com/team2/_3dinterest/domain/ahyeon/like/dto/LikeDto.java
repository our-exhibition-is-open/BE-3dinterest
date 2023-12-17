package com.team2._3dinterest.domain.ahyeon.like.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeDto {
    private int heartId;
    private int postId;
    private String userId;
}