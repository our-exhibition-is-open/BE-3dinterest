package com.team2._3dinterest.domain.ahyeon.like.service;

import com.team2._3dinterest.domain.ahyeon.like.dto.GetPostDto;



public interface PostInterface {
    GetPostDto getPostById(int postId);
    GetPostDto updateLikeAndReturnPost(int postId, String userId);


}