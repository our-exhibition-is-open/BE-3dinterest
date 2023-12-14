package com.team2._3dinterest.domain.yugyeong.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="contribute_table")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContributeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int post_id;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "post_id", nullable = false)
    private PostEntity parent_id;
}