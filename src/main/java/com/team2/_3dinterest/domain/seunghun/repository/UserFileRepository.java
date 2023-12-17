package com.team2._3dinterest.domain.seunghun.repository;

import com.team2._3dinterest.domain.seunghun.mypage.dto.ResponseFileDto;
import com.team2._3dinterest.domain.seunghun.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFileRepository extends JpaRepository<FileEntity, Long> {
    List<FileEntity> findByUserId(String user_id);
    List<FileEntity> findByPostId(ResponseFileDto post_iD);
    // 다음과 같이 findPostIDsByParentID 메서드를 추가


}