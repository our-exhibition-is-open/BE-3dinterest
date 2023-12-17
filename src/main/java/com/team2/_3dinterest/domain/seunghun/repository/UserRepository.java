package com.team2._3dinterest.domain.seunghun.repository;

import java.util.Optional;
import com.team2._3dinterest.domain.seunghun.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserName(String userName);
}