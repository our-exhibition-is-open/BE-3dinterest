package com.team2._3dinterest.domain.seunghun.repository;
import lombok.Getter;

import java.time.LocalDateTime;

public class FileDetailDTO {
    private String id;
    private String name;
    private String format;
    private String path;
    private long bytes;
    private LocalDateTime createdAt;

    public static FileDetailDTO from(ResponseFileDto fileDetail) {
        FileDetailDTO fileDetailDTO = new FileDetailDTO();
        fileDetailDTO.id = fileDetail.getId();
        fileDetailDTO.name = fileDetail.getName();
        fileDetailDTO.format = fileDetail.getFormat();
        fileDetailDTO.path = fileDetail.getPath();
        fileDetailDTO.bytes = fileDetail.getBytes();
        fileDetailDTO.createdAt = fileDetail.getCreatedAt();
        return fileDetailDTO;
    }
}
