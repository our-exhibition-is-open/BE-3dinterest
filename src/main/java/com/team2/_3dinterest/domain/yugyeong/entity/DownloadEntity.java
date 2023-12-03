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
    private int id;

    private String user_id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity postId;
}