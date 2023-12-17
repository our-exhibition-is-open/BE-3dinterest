package com.team2._3dinterest.domain.ahyeon.like.dto;


import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class GetPostDto {
    private int postId;
    private String userId;
    private int likeCnt;
    private String imageUrl;
    private String modelUrl;
    private String title;
    private LocalDateTime uploadDate;

    public int getPostId() {return postId;}
    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getUserId() {return userId;}
    public void setUserId(String userId) {this.userId=userId;}

    public int getLikeCnt() {return likeCnt;}
    public void setLikeCnt(int likeCnt) {
        this.likeCnt = likeCnt;
    }

    public String getImageUrl() {return imageUrl;}
    public void setImageUrl(String imageUrl) {this.imageUrl=imageUrl;}

    public String getModelUrl() {return modelUrl;}
    public void setModelUrl(String modelUrl) {this.modelUrl=modelUrl;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title=title;}

    public LocalDateTime getUploadDate() {return uploadDate;}
    public void setUploadDate(LocalDateTime uploadDate) {this.uploadDate=uploadDate;}

    // public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}

}