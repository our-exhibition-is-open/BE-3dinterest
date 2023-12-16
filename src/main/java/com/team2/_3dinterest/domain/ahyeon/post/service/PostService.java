package com.team2._3dinterest.domain.ahyeon.post.service;


import com.team2._3dinterest.domain.ahyeon.post.Post;



public interface PostService {
    Post getPostById(Long postId);
    Post updateLikeAndReturnPost(Long postId, String userId);


}