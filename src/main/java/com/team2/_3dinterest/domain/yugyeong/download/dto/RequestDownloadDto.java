package com.team2._3dinterest.domain.yugyeong.download.dto;

import com.team2._3dinterest.domain.yugyeong.entity.DownloadEntity;
import com.team2._3dinterest.domain.yugyeong.entity.PostEntity;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestDownloadDto {
    @NotNull(message = "No user_id")
    private String user_id;

    @NotNull(message = "No post_id")
    private int post_id;

    /* Dto -> Entity */
    public DownloadEntity toEntity() {
        PostEntity postEntity = new PostEntity();
        postEntity.setPostId(post_id);

        DownloadEntity downloadEntity = DownloadEntity.builder()
                .user_id(user_id)
                .postId(postEntity)
                .build();

        return downloadEntity;
    }
}