package com.team2._3dinterest.domain.seunghun.repository;

import com.team2._3dinterest.domain.seunghun.entity.FileContributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FileContributeRepository extends JpaRepository<FileContributeEntity, Integer> {
    List<FileContributeEntity> findByParentId_PostId(int parentId);
}