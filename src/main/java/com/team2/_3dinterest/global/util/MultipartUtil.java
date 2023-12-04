package com.team2._3dinterest.global.util;

import org.springframework.util.StringUtils;
import java.util.UUID;

public final class MultipartUtil {
    private static final String BASE_DIR = "images";

    /**
     * 로컬에서의 사용자 홈 디렉토리 경로를 반환합니다.
     */
    public static String getLocalHomeDirectory() {
        return System.getProperty("user.home");
    }

    /**
     * 새로운 파일 고유 ID를 생성합니다.
     * @return 36자리의 UUID
     */
    public static String createUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * FileName에서 마지막 '.' 이후의 문자열을 잘라냅니다.
     * @param fileName
     * @return ex) gltf, glb
     */
    public static String getFormat(String fileName) {
        if (StringUtils.hasText(fileName)) {
            // FileName에서 마지막 '.' 이후의 문자열을 반환
            return fileName.substring(fileName.lastIndexOf('.') + 1);
        }
        return null;
    }

    /**
     * 파일의 전체 경로를 생성합니다.
     * @param fileId 생성된 파일 고유 ID
     * @param format 확장자
     */
    public static String createPath(String fileId, String format) {
        return String.format("%s.%s", fileId, format);
    }
}