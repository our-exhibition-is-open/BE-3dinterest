package com.team2._3dinterest.domain.yugyeong.contribute.controller;

import com.team2._3dinterest.domain.yugyeong.contribute.service.ContributeListService;
import com.team2._3dinterest.domain.yugyeong.entity.PostEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping( value = "/contribute_list" )
@RequiredArgsConstructor
public class ContributeListController {
    private final ContributeListService contributeListService;

    @GetMapping
    public ResponseEntity<List<PostEntity>> contribute_list(
            @Valid @RequestParam(value = "user_id") String user_id) {

        return contributeListService.list(user_id);
    }
}