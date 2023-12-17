package com.team2._3dinterest.domain.seunghun.mypage.controller;

import com.team2._3dinterest.domain.seunghun.mypage.service.FileService;
import com.team2._3dinterest.domain.seunghun.mypage.dto.ResponseFileDto;
import com.team2._3dinterest.domain.seunghun.mypage.dto.UserEntityDTO;
import com.team2._3dinterest.domain.seunghun.repository.UserFileRepository;
import com.team2._3dinterest.domain.seunghun.repository.UserRepository;
import com.team2._3dinterest.domain.seunghun.entity.UserEntity;
import com.team2._3dinterest.domain.seunghun.entity.FileEntity;
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

@RestController
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {

    private final UserRepository userRepository;
    private final UserFileRepository userFileRepository;

    @GetMapping("/details")
    public ResponseEntity<UserEntityDTO> getMyPageDetails() {
        // 현재 로그인한 사용자의 정보를 가져오는 로직
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<UserEntity> user = userRepository.findByUserName(username);

        // 사용자 정보가 있을 경우 DTO로 변환하여 반환
        return user.map(value -> ResponseEntity.ok(UserEntityDTO.from(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user-files")
    public ResponseEntity<List<FileEntity>> getUserFiles() {
        // 현재 로그인한 사용자의 정보를 가져오는 로직
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<UserEntity> user = userRepository.findByUserName(username);

        // 사용자 정보가 있을 경우 해당 사용자가 올린 파일 정보를 조회하여 반환
        return user.map(siteUser -> {
            List<FileEntity> userFiles = userFileRepository.findByUserId(siteUser.getUserId());
            return ResponseEntity.ok(userFiles);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    private final FileService fileService;

    @GetMapping("/byParentID")
    public ResponseEntity<List<ResponseFileDto>> getFilesByParentID(@RequestParam String parentID) {
        List<ResponseFileDto> postIDs = fileService.getFilesByParentID(parentID);
        List<ResponseFileDto> fileDetailDTOs = fileService.getFilesByPostIDs(postIDs);
        return ResponseEntity.ok(fileDetailDTOs);
    }


}
