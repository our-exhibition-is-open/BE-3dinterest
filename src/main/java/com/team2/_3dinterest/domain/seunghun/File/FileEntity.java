package com.team2._3dinterest.domain.seunghun.File;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "file_entity")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parent_id")
    private String parentID;

    @Column(name = "post_id")
    private String postID;

    private String name;
    private String format;
    private String path;
    private long bytes;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
