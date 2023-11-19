package com.team2._3dinterest.domain.seunghun.repository;

import com.team2._3dinterest.domain.seunghun.user.SiteUser;
import lombok.Getter;

@Getter
public class UserDetailsDTO {

    private Long id;
    private String username;
    private String email;

    public static UserDetailsDTO from(SiteUser user) {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.id = user.getId();
        userDetailsDTO.username = user.getUsername();
        userDetailsDTO.email = user.getEmail();
        return userDetailsDTO;
    }
}