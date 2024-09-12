package com.team2._3dinterest.domain.seunghun.mypage.controller;


import com.team2._3dinterest.domain.seunghun.entity.FileEntity;
import com.team2._3dinterest.domain.seunghun.entity.UserEntity;

import com.team2._3dinterest.domain.seunghun.mypage.dto.PageDTO;
import com.team2._3dinterest.domain.seunghun.mypage.service.FileService;
import com.team2._3dinterest.domain.seunghun.repository.FileRepository;
import com.team2._3dinterest.domain.seunghun.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

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

    private FileService fileService;

    @Autowired
    public MyPageController(FileService fileService) {
        this.fileService = fileService;
    }


    @GetMapping("/byParentID")
    public ResponseEntity<List<FileEntity>> getFileEntitiesByParentID(@RequestParam int parentID) {
        List<FileEntity> fileEntities = fileService.getFileEntitiesByParentID(parentID);
        return ResponseEntity.ok(fileEntities);
    }


}