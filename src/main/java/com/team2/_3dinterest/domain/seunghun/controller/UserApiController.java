package com.team2._3dinterest.domain.seunghun.controller;

import com.team2._3dinterest.domain.seunghun.repository.FileDetailDTO;
import com.team2._3dinterest.domain.seunghun.repository.UserDetailsDTO;
import com.team2._3dinterest.domain.seunghun.repository.FileDetailRepository;
import com.team2._3dinterest.domain.seunghun.repository.UserRepository;
import com.team2._3dinterest.domain.seunghun.user.UserCreateForm;
import com.team2._3dinterest.domain.seunghun.user.SiteUser;
import com.team2._3dinterest.domain.seunghun.service.UserService;
import com.team2._3dinterest.domain.yugyeong.upload.dto.FileDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Value;

import lombok.RequiredArgsConstructor;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final FileDetailRepository fileDetailRepository;
    private final AuthenticationManager authenticationManager;

    @Value("${jwt.secret}") //application.yml에 설정된 시크릿 키 값을 가져옴
    private String secretKey;


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
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        // Spring Security를 사용하여 인증 수행
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            // 성공적으로 인증이 완료되면 토큰을 발급하거나 세션 처리 등을 수행
            String token = generateToken(username);

            return ResponseEntity.ok(token);
        } catch (Exception e) {
            // 인증 실패 시 처리
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("인증 실패");
        }
    }
    // JWT 토큰 생성
    private String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    @GetMapping("/{username}/files/{fileId}")
    public ResponseEntity<FileDetailDTO> getFileDetails(@PathVariable String username, @PathVariable String fileId) {
        // 파일 상세 정보 조회 로직 추가
        Optional<FileDetail> fileDetail = fileDetailRepository.findById(fileId);

        if (fileDetail.isPresent()) {
            FileDetailDTO fileDetailDTO = FileDetailDTO.from(fileDetail.get());
            return ResponseEntity.ok(fileDetailDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}