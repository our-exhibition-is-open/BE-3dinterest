package com.team2._3dinterest.domain.yugyeong.postlist.controller;

import com.team2._3dinterest.domain.yugyeong.entity.PostEntity;
import com.team2._3dinterest.domain.yugyeong.postlist.service.PostListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping( value = "/postlist" )
@RequiredArgsConstructor
public class PostListController {
    private final PostListService postListService;

    @GetMapping
    public ResponseEntity<List<PostEntity>> postlist() {
        return postListService.postlist(); // 성공, 200 OK 생성
    }
}