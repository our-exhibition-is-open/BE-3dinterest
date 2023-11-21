package com.team2._3dinterest.domain.seunghun.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDetailRepository extends JpaRepository<ResponseFileDto, String> {
    List<ResponseFileDto> findByUserId(Long userId);
}