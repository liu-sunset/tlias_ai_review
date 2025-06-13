package peng.zhi.liu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import peng.zhi.liu.pojo.Result;
import peng.zhi.liu.utils.AliyunOSSOperator;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    //文件上传
    @PostMapping
    public Result uploadController(MultipartFile file) throws Exception {
        log.info("文件上传：{}", file.getOriginalFilename());
        String url = aliyunOSSOperator.upload(file.getBytes(), Objects.requireNonNull(file.getOriginalFilename()));
        log.info("阿里云OSS文件链接:{}",url);
        return Result.success(url);
    }
}
