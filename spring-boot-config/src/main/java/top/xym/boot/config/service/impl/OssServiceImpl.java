package top.xym.boot.config.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.xym.boot.config.config.OssConfig;
import top.xym.boot.config.service.OssService;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @Author: DELL
 * @Date: 2025/9/11
 * @Version: 1.0
 */
@Service
@Slf4j
public class OssServiceImpl implements OssService {
    @Resource
    private OssConfig ossConfig;
    @Override
    public String upload(MultipartFile file) {
        if (file != null) {
            String originalFilename = file.getOriginalFilename();
            assert originalFilename != null;
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = UUID.randomUUID() + suffix;
            log.info("新文件名: {}", newFileName);
            // 读取配置文件中的配置值
            String endpoint = ossConfig.getEndpoint();
            String bucket = ossConfig.getBucket();
            String accessKey = ossConfig.getAccessKey();
            String secretKey = ossConfig.getSecretKey();
            String dir = ossConfig.getDir();
            // 创建OSS客户端
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKey, secretKey);
            // 设置ContentType是image/jpeg，可以在浏览器预览图片
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType("image/jpg");
            String uploadPath = dir + newFileName;
            InputStream inputStream;
            try {
                inputStream = file.getInputStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ossClient.putObject(bucket, uploadPath, inputStream, meta);
            ossClient.shutdown();
            return "https://" + bucket + "." + endpoint + "/" + uploadPath;
        }
        return "上传失败";
    }
}
