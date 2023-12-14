package com.team2._3dinterest.domain.yugyeong.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="download_history_table")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DownloadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="user_id")
    private String userId;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_id", nullable = false)
    private PostEntity postId;
}