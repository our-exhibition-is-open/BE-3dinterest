package com.team2._3dinterest.domain.seunghun.repository;

import java.util.Optional;
import com.team2._3dinterest.domain.seunghun.user.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findByUserName(String username);
}