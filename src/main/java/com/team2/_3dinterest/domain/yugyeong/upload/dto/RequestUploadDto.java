package com.team2._3dinterest.domain.yugyeong.upload.dto;

import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Data
@Setter
@Builder
public class RequestUploadDto {
    @NotNull(message = "No title")
    private String title;
    @NotNull(message = "No userName")
    private String userName;

    private boolean tagA;
    private boolean tagB;
    private boolean tagC;
    private boolean tagD;
}