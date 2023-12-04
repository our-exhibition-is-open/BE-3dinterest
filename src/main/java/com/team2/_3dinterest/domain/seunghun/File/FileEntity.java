package com.team2._3dinterest.domain.seunghun.File;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "contribute_table")
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
}
