package com.team2._3dinterest.domain.seunghun.user;

import com.team2._3dinterest.domain.seunghun.File.ContributeEntity;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "post_table")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private String postId;

    @Column(name = "user_id")
    private String userId;

    private String title;
    private String model_uuid;
    private String image_uuid;
    private String tag_a;
    private String tag_b;
    private String tag_c;
    private String tag_d;
    private int like_cnt;

    @Column(name = "upload_date")
    private LocalDateTime upload_date;

    @OneToMany(mappedBy = "parentID", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContributeEntity> files;

}
