package com.team2._3dinterest.domain.ahyeon.post.controller;


import com.team2._3dinterest.domain.ahyeon.post.Post;
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
    public ResponseEntity<Post> getPostById(@PathVariable Long postId) {
        Post post = postService.getPostById(postId);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    //@PathVariable Long postId,  @RequestParam String userId
    @PostMapping("/{postId}/like")
    public ResponseEntity<String> toggleLike(@PathVariable Long postId,  @RequestParam String userId) {
       postService.toggleLike(postId, userId);
        return ResponseEntity.ok().build();
    }
}

