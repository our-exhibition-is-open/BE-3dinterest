package com.team2._3dinterest.domain.seunghun.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.team2._3dinterest.domain.yugyeong.upload.dto.FileDetail;
public interface FileDetailRepository extends JpaRepository<FileDetail, String> {
    List<FileDetail> findByUserId(Long userId);
}