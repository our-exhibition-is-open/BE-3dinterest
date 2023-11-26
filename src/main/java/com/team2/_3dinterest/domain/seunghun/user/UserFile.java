package com.team2._3dinterest.domain.seunghun.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import com.team2._3dinterest.domain.seunghun.repository.ResponseFileDto;


@Table(name = "user_file")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class UserFile{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private SiteUser user;

    @OneToOne
    @JoinColumn(name = "file_detail_id", nullable = false, unique = true)
    private ResponseFileDto fileDetail;

    // 추가적인 필드 (예: 파일 설명, 태그 등)
}