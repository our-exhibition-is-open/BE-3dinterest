package com.team2._3dinterest.domain.yugyeong.repository;

import com.team2._3dinterest.domain.yugyeong.entity.DownloadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DownloadRepository extends JpaRepository<DownloadEntity, Integer> {
}