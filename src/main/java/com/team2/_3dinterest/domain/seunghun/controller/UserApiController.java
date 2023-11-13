package com.team2._3dinterest.domain.seunghun.controller;

import com.team2._3dinterest.domain.seunghun.repository.FileDetailDTO;
import com.team2._3dinterest.domain.seunghun.repository.UserDetailsDTO;
import com.team2._3dinterest.domain.seunghun.repository.FileDetailRepository;
import com.team2._3dinterest.domain.seunghun.repository.UserRepository;
import com.team2._3dinterest.domain.seunghun.user.UserCreateForm;
import com.team2._3dinterest.domain.seunghun.user.SiteUser;
import com.team2._3dinterest.domain.seunghun.service.UserService;
import com.team2._3dinterest.domain.yugyeong.upload.dto.FileDetail;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataIntegrityViolationException;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final FileDetailRepository fileDetailRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody UserCreateForm userCreateForm) {
        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("2개의 패스워드가 일치하지 않습니다.");
        }

        try {
            userService.create(userCreateForm.getUsername(), userCreateForm.getEmail(), userCreateForm.getPassword1());
            return ResponseEntity.status(HttpStatus.CREATED).body("사용자 등록이 성공했습니다.");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 등록된 사용자입니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping("/{username}/details")
    public ResponseEntity<UserDetailsDTO> getUserDetails(@PathVariable String username) {
        Optional<SiteUser> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            UserDetailsDTO userDetailsDTO = UserDetailsDTO.from(user.get());
            return ResponseEntity.ok(userDetailsDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{username}/files")
    public ResponseEntity<List<FileDetailDTO>> getUserFiles(@PathVariable String username) {
        Optional<SiteUser> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            List<FileDetail> files = fileDetailRepository.findByUserId(user.get().getId());
            List<FileDetailDTO> fileDetailDTOs = files.stream()
                    .map(FileDetailDTO::from)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(fileDetailDTOs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}






