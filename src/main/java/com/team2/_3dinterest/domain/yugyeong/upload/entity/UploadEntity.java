package com.team2._3dinterest.domain.yugyeong.upload.entity;

import com.team2._3dinterest.domain.yugyeong.upload.dto.RequestUploadDto;
import com.team2._3dinterest.domain.yugyeong.upload.dto.ResponseFileDto;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; // 포멧 확인

@Entity
@Data
@Table(name="post_table")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int post_id;
    private String user_id;
    private String title;
    private String model_url;
    private String image_url;
    private boolean tag_a;
    private boolean tag_b;
    private boolean tag_c;
    private boolean tag_d;
    private int like_cnt;
    private LocalDateTime upload_date;

    public static UploadEntity toEntity(RequestUploadDto Request, ResponseFileDto Response) {
        return UploadEntity.builder()
    public static UploadEntity toEntity(RequestUploadDto Request, List<ResponseFileDto> responseFileDtoList) {
                .user_id(Request.getUser_id())
                .title(Request.getTitle())
                .model_url(Response.getModel_path())
                .image_url(Response.getImage_path())
                .tag_a(Request.isTagA())
                .tag_b(Request.isTagB())
                .tag_c(Request.isTagC())
                .tag_d(Request.isTagD())
                .upload_date(Response.getUpload_date())
                .build();
    }
}