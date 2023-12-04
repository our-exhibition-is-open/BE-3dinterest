package com.team2._3dinterest.domain.seunghun.File;

import com.team2._3dinterest.domain.seunghun.repository.ResponseFileDto;
import com.team2._3dinterest.domain.seunghun.repository.UserFileRepository;
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
        // FileEntity에서 parentID에 해당하는 모든 postID 가져오기
        List<String> postIDs = fileRepository.findPostIDsByParentID(parentID);

        // 각 postID에 해당하는 UserEntity 조회하여 ResponseFileDto로 매핑
        return postIDs.stream()
                .flatMap(postID -> userFileRepository.findByPostId(postID).stream())
                .map(ResponseFileDto::from)
                .collect(Collectors.toList());
    }
}
