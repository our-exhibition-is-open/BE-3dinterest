package com.team2._3dinterest.domain.seunghun.repository;


import com.team2._3dinterest.domain.seunghun.user.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
}