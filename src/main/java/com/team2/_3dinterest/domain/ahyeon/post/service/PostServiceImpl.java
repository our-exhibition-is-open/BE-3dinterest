package com.team2._3dinterest.domain.ahyeon.post.service;


import com.team2._3dinterest.domain.ahyeon.heart.HeartEntity;
import com.team2._3dinterest.domain.ahyeon.heart.HeartRepository;
import com.team2._3dinterest.domain.ahyeon.post.Post;
import com.team2._3dinterest.domain.ahyeon.post.PostRepo;
import com.team2._3dinterest.domain.ahyeon.post.entity.PostEnti;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepository;

    public PostServiceImpl(PostRepo postRepository){
        this.postRepository=postRepository;
    }

    @Autowired
    private HeartRepository heartRepository;

    public Post getPostById(int postId) {
        return postRepository.findById(postId).map(this::mapToPost).orElse(null);
    }


    @Override
    @Transactional
    public Post updateLikeAndReturnPost(int postId, String userId) {
        return updateLike(postId, userId, true);
    }

    private Post updateLike(int postId, String userId, boolean getUpdatedPost) {
        Optional<PostEnti> postEntityOptional = postRepository.findById(postId);

        if (postEntityOptional.isPresent()) {
            Post post = mapToPost(postEntityOptional.get());

            HeartEntity existingHeart = heartRepository.findByPostIdAndUserId(postId, userId);

            if (existingHeart != null) {
                // 좋아요 취소
                heartRepository.delete(existingHeart);
                post.setLikeCnt(Math.max(0, post.getLikeCnt() - 1));
            } else {
                // 좋아요 누르기
                HeartEntity newHeart = new HeartEntity();
                newHeart.setPostId(postId);
                newHeart.setUserId(userId);
                heartRepository.save(newHeart);
                post.setLikeCnt(Math.min(1, post.getLikeCnt() + 1));
            }

            //heartRepository.save(newHeart);
            // like_cnt 값을 post_table에 업데이트
            //post.setLikeCnt(post.getLikeCnt());
            //postRepo.save(post);
            postRepository.save(postEntityOptional.get());
//postRepository.updateLikeCnt(postId, post.getLikeCnt());

            if (getUpdatedPost) {
                return post;
            } else {
                postRepository.save(postEntityOptional.get());
                return null;
            }
        } else {
            throw new RuntimeException("게시물을 찾을 수 없습니다. postId: " + postId);
        }
    }

    private Post mapToPost(PostEnti postEntity) {
        Post post = new Post();
        post.setPostId(postEntity.getPostId());
        post.setUserId(postEntity.getUserId());
        post.setLikeCnt(postEntity.getLikeCnt());
        post.setImageUrl(postEntity.getImageUrl());// null로 설정하지 않음
        post.setTitle(postEntity.getTitle());
        post.setModelUrl(postEntity.getModelUrl());
        post.setUploadDate(postEntity.getUploadDate());
        return post;
    }
}