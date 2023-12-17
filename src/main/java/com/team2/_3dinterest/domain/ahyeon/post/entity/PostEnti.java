package com.team2._3dinterest.domain.ahyeon.post.entity;


import jakarta.persistence.*;

import lombok.*;

import org.hibernate.annotations.DynamicInsert;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@Data
@DynamicInsert
@AllArgsConstructor
@Getter
@Setter


//@NoArgsConstructor

@Table(name="post_table")
public class PostEnti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false, updatable = false)
    private int postId;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private String userId;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "model_uuid", nullable = false)
    private String modelUrl;

    @NotNull
    @Column(name = "image_uuid", nullable = false)
    private String imageUrl;

    @NotNull
    @Column(name = "tag_a", nullable = false)
    private boolean tagA;

    @NotNull
    @Column(name = "tag_b", nullable = false)
    private boolean tagB;

    @NotNull
    @Column(name = "tag_c", nullable = false)
    private boolean tagC;

    @NotNull
    @Column(name = "tag_d", nullable = false)
    private boolean tagD;

    @NotNull
    @Column(name = "like_cnt", nullable = false)
    private int likeCnt;

    @NotNull
    @Column(name = "upload_date", nullable = false)
    private LocalDateTime uploadDate;

    public PostEnti() {
    }


    // 생성자, Getter, Setter, 기타 메서드 생략

    // Parameterized constructor
    public PostEnti(String userId, String title, String modelUrl, String imageUrl,
                      boolean tagA, boolean tagB, boolean tagC, boolean tagD,
                      int likeCnt, LocalDateTime uploadDate) {
        this.userId = userId;
        this.title = title;
        this.modelUrl = modelUrl;
        this.imageUrl = imageUrl;
        this.tagA = tagA;
        this.tagB = tagB;
        this.tagC = tagC;
        this.tagD = tagD;
        this.likeCnt = likeCnt;
        this.uploadDate = uploadDate;
    }
}
