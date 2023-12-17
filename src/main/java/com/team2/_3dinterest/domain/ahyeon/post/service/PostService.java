package com.team2._3dinterest.domain.ahyeon.post.service;


import com.team2._3dinterest.domain.ahyeon.post.Post;



public interface PostService {
    Post getPostById(int postId);
    Post updateLikeAndReturnPost(int postId, String userId);


}