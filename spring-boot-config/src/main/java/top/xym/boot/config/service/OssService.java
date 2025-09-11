package top.xym.boot.config.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: DELL
 * @Date: 2025/9/11
 * @Version: 1.0
 */
public interface OssService {
    /**
     * 上传文件
     * @param file
     * @return
     */
    String upload(MultipartFile file);
}
