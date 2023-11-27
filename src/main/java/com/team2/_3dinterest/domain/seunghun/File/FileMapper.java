package com.team2._3dinterest.domain.seunghun.File;

import com.team2._3dinterest.domain.seunghun.repository.ResponseFileDto;

public class FileMapper {
    public static ResponseFileDto toDto(FileEntity fileEntity) {
        return ResponseFileDto.builder()
                .id(fileEntity.getParentID())
                .name(fileEntity.getName())
                .format(fileEntity.getFormat())
                .path(fileEntity.getPath())
                .bytes(fileEntity.getBytes())
                .createdAt(fileEntity.getCreatedAt())
                .build();
    }

    public static FileEntity toEntity(ResponseFileDto fileDto) {
        return FileEntity.builder()
                .parentID(fileDto.getId())
                .name(fileDto.getName())
                .format(fileDto.getFormat())
                .path(fileDto.getPath())
                .bytes(fileDto.getBytes())
                .createdAt(fileDto.getCreatedAt())
                .build();
    }
}
