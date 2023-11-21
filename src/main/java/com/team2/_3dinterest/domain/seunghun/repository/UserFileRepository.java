package com.team2._3dinterest.domain.seunghun.repository;

import com.team2._3dinterest.domain.seunghun.user.UserFile;
import com.team2._3dinterest.domain.seunghun.user.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserFileRepository extends JpaRepository<UserFile, Long> {
    List<UserFile> findByUser(SiteUser user);
    List<UserFile> findByPostID(String postID);
    @Query("SELECT DISTINCT uf.postID FROM UserFile uf WHERE uf.parentID = :parentID")
    List<String> findPostIDsByParentID(@Param("parentID") String parentID);
}