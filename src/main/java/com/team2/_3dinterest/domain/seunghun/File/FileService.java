package com.team2._3dinterest.domain.seunghun.File;

import com.team2._3dinterest.domain.seunghun.repository.ResponseFileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {
    @Autowired
    private FileEntityRepository fileRepository;

    public List<ResponseFileDto> getFilesByParentID(String parentID) {
        List<FileEntity> fileEntities = fileRepository.findByParentID(parentID);
        return fileEntities.stream()
                .map(FileMapper::toDto)
                .collect(Collectors.toList());
    }
}
