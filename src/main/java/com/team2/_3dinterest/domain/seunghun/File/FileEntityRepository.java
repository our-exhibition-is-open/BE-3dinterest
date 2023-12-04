package com.team2._3dinterest.domain.seunghun.File;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileEntityRepository extends JpaRepository<FileEntity, Long> {
    List<String> findPostIDsByParentID(String parentID);
}
