package com.team2._3dinterest.domain.yugyeong.upload.entity;

import com.team2._3dinterest.domain.yugyeong.upload.dto.RequestUploadDto;
import com.team2._3dinterest.domain.yugyeong.upload.dto.ResponseFileDto;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

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
    public static UploadEntity toEntity(RequestUploadDto Request, List<ResponseFileDto> responseFileDtoList) {
        UploadEntity.UploadEntityBuilder builder = UploadEntity.builder()
                // RequestUploadDto 추가
                .user_id(Request.getUser_id())
                .title(Request.getTitle())
                .tag_a(Request.isTagA())
                .tag_b(Request.isTagB())
                .tag_c(Request.isTagC())
                .tag_d(Request.isTagD());

        // 여러 개의 responseFileDtoList 추가
        for (ResponseFileDto responseFileDto : responseFileDtoList) {
            // model 추가
            builder.model_url(responseFileDto.getModel_path());

            // image가 있는 경우에만 추가(한 번)
            if (responseFileDto.getImage_path() != null) {
                builder.image_url(responseFileDto.getImage_path());
            }

            // 파일을 올린 시점의 upload_date 추가
            builder.upload_date(responseFileDto.getUpload_date());
        }

        return builder.build();
    }
}