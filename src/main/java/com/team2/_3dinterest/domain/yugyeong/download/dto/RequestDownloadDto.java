package com.team2._3dinterest.domain.yugyeong.download.dto;

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
}