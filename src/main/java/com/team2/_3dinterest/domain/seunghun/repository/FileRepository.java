package com.team2._3dinterest.domain.seunghun.repository;

import com.team2._3dinterest.domain.seunghun.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
    List<FileEntity> findByUserId(String user_id);
    List<FileEntity> findByPostId(int post_iD);


}