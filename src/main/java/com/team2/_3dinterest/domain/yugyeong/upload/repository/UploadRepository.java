package com.team2._3dinterest.domain.yugyeong.upload.repository;

import com.team2._3dinterest.domain.yugyeong.upload.entity.UploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadRepository extends JpaRepository<UploadEntity, Integer> {
}