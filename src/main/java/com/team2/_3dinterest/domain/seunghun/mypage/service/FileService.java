package com.team2._3dinterest.domain.seunghun.mypage.service;

import com.team2._3dinterest.domain.seunghun.mypage.dto.ResponseFileDto;
import com.team2._3dinterest.domain.seunghun.entity.ContributeEntity;
import com.team2._3dinterest.domain.seunghun.repository.FileEntityRepository;
import com.team2._3dinterest.domain.seunghun.repository.UserFileRepository;
import com.team2._3dinterest.domain.seunghun.entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {

    @Autowired
    private FileEntityRepository fileRepository;

    @Autowired
    private UserFileRepository userFileRepository;

    public List<ResponseFileDto> getFilesByParentID(String parentID) {
        List<ContributeEntity> fileEntities = fileRepository.findByParentIDPostId(parentID);

        return fileEntities.stream()
                .map(contributeEntity -> ResponseFileDto.from(contributeEntity))
                .collect(Collectors.toList());
    }

    public List<ResponseFileDto> getFilesByPostIDs(List<ResponseFileDto> postIDs) {
        return postIDs.stream()
                .flatMap(postID -> userFileRepository.findByPostId(postID).stream())
                .map((FileEntity userEntity) -> ResponseFileDto.from(FileEntity))
                .collect(Collectors.toList());
    }


}
