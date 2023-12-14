package com.team2._3dinterest.domain.yugyeong.contribute.controller;

import com.team2._3dinterest.domain.yugyeong.contribute.service.ContributeRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/contribute_record" )
@RequiredArgsConstructor
public class ContributeRecordController {
    private final ContributeRecordService contributeRecordService;

    @PostMapping
    public ResponseEntity<Void> contribute_record(
            @Valid @RequestParam(value = "post_id") int post_id,
            @Valid @RequestParam(value = "parent_id") int parent_id ) {
        contributeRecordService.record(post_id, parent_id);

        return ResponseEntity.ok().build();
    }
}