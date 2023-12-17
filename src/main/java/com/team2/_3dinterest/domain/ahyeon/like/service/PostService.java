package com.team2._3dinterest.domain.ahyeon.like.service;

import com.team2._3dinterest.domain.ahyeon.like.entity.LikeEntity;
import com.team2._3dinterest.domain.ahyeon.like.repository.HeartRepository;
import com.team2._3dinterest.domain.ahyeon.like.dto.GetPostDto;
import com.team2._3dinterest.domain.ahyeon.like.repository.Post_Repository;
import com.team2._3dinterest.domain.ahyeon.like.entity.Post_Entity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PostService implements PostInterface {

    @Autowired
    private Post_Repository postRepository;

    public PostService(Post_Repository postRepository){
        this.postRepository=postRepository;
    }

    @Autowired
    private HeartRepository heartRepository;

    public GetPostDto getPostById(int postId) {
        return postRepository.findById(postId).map(this::mapToPost).orElse(null);
    }


    @Override
    @Transactional
    public GetPostDto updateLikeAndReturnPost(int postId, String userId) {
        return updateLike(postId, userId, true);
    }

    private GetPostDto updateLike(int postId, String userId, boolean getUpdatedPost) {
        Optional<Post_Entity> postEntityOptional = postRepository.findById(postId);

        if (postEntityOptional.isPresent()) {
            GetPostDto getPostDto = mapToPost(postEntityOptional.get());

            LikeEntity existingHeart = heartRepository.findByPostIdAndUserId(postId, userId);

            if (existingHeart != null) {
                // 좋아요 취소
                heartRepository.delete(existingHeart);
                getPostDto.setLikeCnt(Math.max(0, getPostDto.getLikeCnt() - 1));
            } else {
                // 좋아요 누르기
                LikeEntity newHeart = new LikeEntity();
                newHeart.setPostId(postId);
                newHeart.setUserId(userId);
                heartRepository.save(newHeart);
                getPostDto.setLikeCnt(Math.min(1, getPostDto.getLikeCnt() + 1));
            }

            //heartRepository.save(newHeart);
            // like_cnt 값을 post_table에 업데이트
            //post.setLikeCnt(post.getLikeCnt());
            //postRepo.save(post);
            postRepository.save(postEntityOptional.get());
//postRepository.updateLikeCnt(postId, post.getLikeCnt());

            if (getUpdatedPost) {
                return getPostDto;
            } else {
                postRepository.save(postEntityOptional.get());
                return null;
            }
        } else {
            throw new RuntimeException("게시물을 찾을 수 없습니다. postId: " + postId);
        }
    }

    private GetPostDto mapToPost(Post_Entity postEntity) {
        GetPostDto getPostDto = new GetPostDto();
        getPostDto.setPostId(postEntity.getPostId());
        getPostDto.setUserId(postEntity.getUserId());
        getPostDto.setLikeCnt(postEntity.getLikeCnt());
        getPostDto.setImageUrl(postEntity.getImageUrl());// null로 설정하지 않음
        getPostDto.setTitle(postEntity.getTitle());
        getPostDto.setModelUrl(postEntity.getModelUrl());
        getPostDto.setUploadDate(postEntity.getUploadDate());
        return getPostDto;
    }
}