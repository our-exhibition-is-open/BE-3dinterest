package com.team2._3dinterest.domain.ahyeon.post.controller;


import com.team2._3dinterest.domain.ahyeon.post.Post;
import com.team2._3dinterest.domain.ahyeon.post.dto.PostDto;
import com.team2._3dinterest.domain.ahyeon.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// PostController.java
@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long postId) {
        Post post = postService.getPostById(postId);
        if (post != null) {
            PostDto postDto = mapToPostDto(post);
            return ResponseEntity.ok(postDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    ///ID로 게시글 Entity 검색, 있으면 DTO 매핑, 엔드포인트로 게시글 가져옴

    //@PathVariable Long postId,  @RequestParam String userId
    @GetMapping("/{postId}/like")
    public ResponseEntity<Post> updateLike(@PathVariable Long postId, @RequestParam String userId) {
        Post updatedPost = postService.updateLikeAndReturnPost(postId, userId);
        if (updatedPost != null) {
            return ResponseEntity.ok(updatedPost); // 성공 시 업데이트된 게시물 정보 반환
        } else {
            return ResponseEntity.badRequest().build(); // 실패 시 Bad Request 상태 코드 반환
        }
    }


    private PostDto mapToPostDto(Post post) {
        PostDto postDto = new PostDto();

        postDto.setPostId(post.getPostId());
        postDto.setUserId(post.getUserId());
        postDto.setTitle(post.getTitle());
        postDto.setImageUrl(post.getImageUrl());
        postDto.setModelUrl(post.getModelUrl());
        postDto.setUploadDate(post.getUploadDate());
        postDto.setLikeCnt(post.getLikeCnt());

        return postDto;
    }
}
