package com.team2._3dinterest.domain.seunghun.controller;

import com.team2._3dinterest.domain.seunghun.repository.FileDetailDTO;
import com.team2._3dinterest.domain.seunghun.repository.ResponseFileDto;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {

    private final UserRepository userRepository;
    private final UserFileRepository userFileRepository;

    @GetMapping("/details")
    public ResponseEntity<UserDetailsDTO> getMyPageDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<SiteUser> user = userRepository.findByUsername(username);

        return user.map(value -> ResponseEntity.ok(UserDetailsDTO.from(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/files")
    public ResponseEntity<List<ResponseFileDto>> getMyFiles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<SiteUser> user = userRepository.findByUsername(username);

        return user.map(siteUser -> {
            List<UserFile> userFiles = userFileRepository.findByUser(siteUser);
            List<ResponseFileDto> fileDetailDTOs = userFiles.stream()
                    .map(userFile -> ResponseFileDto.builder()
                            .id(userFile.getFileDetail().getParentID())
                            .name(userFile.getFileDetail().getName())
                            .format(userFile.getFileDetail().getFormat())
                            .path(userFile.getFileDetail().getPath())
                            .bytes(userFile.getFileDetail().getBytes())
                            .createdAt(userFile.getFileDetail().getCreatedAt())
                            .build())
                    .collect(Collectors.toList());
            return ResponseEntity.ok(fileDetailDTOs);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/files/byParentID")
    public ResponseEntity<List<ResponseFileDto>> getFilesByParentID(@RequestParam String parentID) {
        List<String> postIDs = userFileRepository.findPostIDsByParentID(parentID);

        List<ResponseFileDto> fileDetailDTOs = postIDs.stream()
                .map(postID -> userFileRepository.findByPostID(postID))
                .flatMap(List::stream)
                .map(userFile -> ResponseFileDto.builder()
                        .id(userFile.getFileDetail().getParentID())
                        .name(userFile.getFileDetail().getName())
                        .format(userFile.getFileDetail().getFormat())
                        .path(userFile.getFileDetail().getPath())
                        .bytes(userFile.getFileDetail().getBytes())
                        .createdAt(userFile.getFileDetail().getCreatedAt())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(fileDetailDTOs);
    }
}
