package com.team2._3dinterest.domain.seunghun.mypage.service;

import com.team2._3dinterest.domain.seunghun.entity.FileContributeEntity;
import com.team2._3dinterest.domain.seunghun.entity.FileEntity;
import com.team2._3dinterest.domain.seunghun.repository.FileContributeRepository;
import com.team2._3dinterest.domain.seunghun.repository.FileRepository;
import com.team2._3dinterest.domain.yugyeong.entity.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileContributeRepository fileContributeRepository;
    private final FileRepository fileRepository;

    public List<FileEntity> getFileEntitiesByParentID(int parentId) {
        List<FileContributeEntity> contributeEntities = fileContributeRepository.findByParentId_PostId(parentId);

        List<FileEntity> fileEntities = new ArrayList<>();
        for (FileContributeEntity contributeEntity : contributeEntities) {

            // parentId 반환
//            FileEntity contribute_post_id = contributeEntity.getParentId();
//            fileEntities.add(contribute_post_id);

            // postId 반환
            int contribute_post_id = contributeEntity.getPostId();
            FileEntity fileEntity = fileRepository.findByPostId(contribute_post_id);
            fileEntities.add(fileEntity);
        }

        return fileEntities;
    }
}