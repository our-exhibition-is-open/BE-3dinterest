package com.team2._3dinterest.domain.yugyeong.repository;

import com.team2._3dinterest.domain.yugyeong.entity.DownloadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DownloadRepository extends JpaRepository<DownloadEntity, Integer> {
    List<DownloadEntity> findByUserId(String userId); // contribute에서 download_table의 userId 조회
}