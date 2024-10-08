package com.team2._3dinterest.domain.seunghun.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contribute_table")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class FileContributeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "post_id", nullable = false)
    private FileEntity parentId;

    @Column(name = "post_id")
    private int postId;

}
