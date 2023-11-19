package com.team2._3dinterest.domain.seunghun.controller;

import com.team2._3dinterest.domain.seunghun.repository.FileDetailDTO;
import com.team2._3dinterest.domain.seunghun.repository.UserDetailsDTO;
import com.team2._3dinterest.domain.seunghun.repository.UserFileRepository;
import com.team2._3dinterest.domain.seunghun.repository.UserRepository;
import com.team2._3dinterest.domain.seunghun.user.SiteUser;
import com.team2._3dinterest.domain.seunghun.user.UserFile;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mypage")
@RequiredArgsConstructor
public class MyPageController {

    private final UserRepository userRepository;
    private final UserFileRepository userFileRepository;

    @GetMapping("/details")
    public ResponseEntity<UserDetailsDTO> getMyPageDetails() {
        // 현재 로그인한 사용자의 정보를 가져오는 로직
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<SiteUser> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            UserDetailsDTO userDetailsDTO = UserDetailsDTO.from(user.get());
            return ResponseEntity.ok(userDetailsDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileDetailDTO>> getMyFiles() {
        // 현재 로그인한 사용자가 업로드한 파일 목록을 가져오는 로직
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<SiteUser> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            List<UserFile> userFiles = userFileRepository.findByUser(user.get());
            List<FileDetailDTO> fileDetailDTOs = userFiles.stream()
                    .map(userFile -> FileDetailDTO.from(userFile.getFileDetail()))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(fileDetailDTOs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}