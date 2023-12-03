package com.team2._3dinterest.domain.yugyeong.entity;

import com.team2._3dinterest.domain.yugyeong.upload.dto.RequestUploadDto;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

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

    // dto를 entity로 변환하는 toEntity
    public static UploadEntity toEntity(RequestUploadDto Request, String model_url, String image_url, LocalDateTime upload_date) {
        UploadEntity.UploadEntityBuilder builder = UploadEntity.builder()

                // post_id와 like_cnt 제외
                .user_id(Request.getUser_id())
                .title(Request.getTitle())
                .model_url(model_url)
                .image_url(image_url)
                .tag_a(Request.isTagA())
                .tag_b(Request.isTagB())
                .tag_c(Request.isTagC())
                .tag_d(Request.isTagD())
                .upload_date(upload_date);

        return builder.build();
    }
}