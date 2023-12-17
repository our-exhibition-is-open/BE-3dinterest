package com.team2._3dinterest.domain.seunghun.repository;

import com.team2._3dinterest.domain.seunghun.entity.ContributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileEntityRepository extends JpaRepository<ContributeEntity, Long> {
    List<ContributeEntity> findByParentIDPostId(String parentID);
}
