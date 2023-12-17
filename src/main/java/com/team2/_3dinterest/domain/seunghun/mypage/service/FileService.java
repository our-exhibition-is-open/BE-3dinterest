package com.team2._3dinterest.domain.seunghun.mypage.service;


import com.team2._3dinterest.domain.seunghun.entity.FileEntity;
import com.team2._3dinterest.domain.seunghun.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;


    public List<FileEntity> getFilesByParentID(int parentID) {
        List<FileEntity> fileEntities = fileRepository.findByPostId(parentID);
    return fileEntities;
    }


}
