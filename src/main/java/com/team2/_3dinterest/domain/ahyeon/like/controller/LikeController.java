package com.team2._3dinterest.domain.ahyeon.like.controller;

import com.team2._3dinterest.domain.ahyeon.like.dto.GetPostDto;
import com.team2._3dinterest.domain.ahyeon.like.dto.PostDto;
import com.team2._3dinterest.domain.ahyeon.like.service.PostInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// PostController.java
@RestController
@RequestMapping("/api/posts")
public class LikeController {

    @Autowired
    private PostInterface postInterface;

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable int postId) {
        GetPostDto getPostDto = postInterface.getPostById(postId);
        if (getPostDto != null) {
            PostDto postDto = mapToPostDto(getPostDto);
            return ResponseEntity.ok(postDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    ///ID로 게시글 Entity 검색, 있으면 DTO 매핑, 엔드포인트로 게시글 가져옴

    //@PathVariable Long postId,  @RequestParam String userId
    @GetMapping("/{postId}/like")
    public ResponseEntity<GetPostDto> updateLike(@PathVariable int postId, @RequestParam String userId) {
        GetPostDto updatedGetPostDto = postInterface.updateLikeAndReturnPost(postId, userId);
        if (updatedGetPostDto != null) {
            return ResponseEntity.ok(updatedGetPostDto); // 성공 시 업데이트된 게시물 정보 반환
        } else {
            return ResponseEntity.badRequest().build(); // 실패 시 Bad Request 상태 코드 반환
        }
    }


    private PostDto mapToPostDto(GetPostDto getPostDto) {
        PostDto postDto = new PostDto();

        postDto.setPostId(getPostDto.getPostId());
        postDto.setUserId(getPostDto.getUserId());
        postDto.setTitle(getPostDto.getTitle());
        postDto.setImageUrl(getPostDto.getImageUrl());
        postDto.setModelUrl(getPostDto.getModelUrl());
        postDto.setUploadDate(getPostDto.getUploadDate());
        postDto.setLikeCnt(getPostDto.getLikeCnt());

        return postDto;
    }
}
