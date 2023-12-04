package com.team2._3dinterest.domain.yugyeong.upload.dto;

import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Data
@Getter
@Builder
public class RequestUploadDto {
    @NotNull(message = "No user_id")
    private String user_id;

    @NotNull(message = "No title")
    private String title;

    @NotNull(message = "No tagA")
    private boolean tagA;

    @NotNull(message = "No tagB")
    private boolean tagB;

    @NotNull(message = "No tagC")
    private boolean tagC;

    @NotNull(message = "No tagD")
    private boolean tagD;
}