package com.team2._3dinterest.domain.ahyeon.post.service;


import com.team2._3dinterest.domain.ahyeon.heart.HeartEntity;
import com.team2._3dinterest.domain.ahyeon.heart.HeartRepository;
import com.team2._3dinterest.domain.ahyeon.post.Post;
import com.team2._3dinterest.domain.ahyeon.post.PostRepo;
import com.team2._3dinterest.domain.ahyeon.post.entity.PostEnti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// PostServiceImpl.java


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepository;

    @Autowired
    private HeartRepository heartRepository;

    @Override
    public Post getPostById(Long postId) {
        return postRepository.findById(postId).map(this::mapToPost).orElse(null);
    }

    @Override
    public void toggleLike(Long postId, String userId) {
        Optional<PostEnti> postEntityOptional = postRepository.findById(postId);

        if (postEntityOptional.isPresent()) {
            Post post = mapToPost(postEntityOptional.get());

            HeartEntity existingHeart = heartRepository.findByPostIdAndUserId(postId, userId);

            if (existingHeart != null) {
                // 이미 좋아요가 눌려있는 경우, 좋아요 취소
                heartRepository.delete(existingHeart);
                post.setLikes(post.getLikes() - 1);
            } else {
                // 좋아요 누르기
                HeartEntity newHeart = new HeartEntity();
                newHeart.setPostId(postId);
                newHeart.setUserId(userId);
                heartRepository.save(newHeart);
                post.setLikes(post.getLikes() + 1);
            }

            postRepository.save(mapToPostEntity(post));
        } else {
            // Handle the case where the post is not found
            throw new RuntimeException("게시물을 찾을 수 없습니다. postId: " + postId);
        }
    }
    private Post mapToPost(PostEnti postEntity) {
        Post post = new Post();
        post.setPostId(postEntity.getPostId());
        post.setLikes(postEntity.getLikes());
        // 나머지 필드들도 필요에 따라 설정
        return post;
    }

    private PostEnti mapToPostEntity(Post post) {
        PostEnti postEntity = new PostEnti();
        postEntity.setPostId(post.getPostId());
        postEntity.setLikes(post.getLikes());
        // 나머지 필드들도 필요에 따라 설정
        return postEntity;
    }
}