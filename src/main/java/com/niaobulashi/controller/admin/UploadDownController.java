package com.niaobulashi.controller.admin;

import com.niaobulashi.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: spring-boot-crud
 * @description: 文件上传下载
 * @author: hulang
 * @create: 2019-05-31 14:27
 */
@RestController
public class UploadDownController {

    private final static Logger logger = LoggerFactory.getLogger(UploadDownController.class);

    @RequestMapping("/upload")
    public Result upload(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) {
        //获取文件在服务器的存储位置
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File filePath = new File(path);
        logger.info("文件保存的路径为：" + filePath);
        // 判断是否存在，不存在则创建改目录
        if (!filePath.exists() && filePath.isDirectory()) {
            logger.info("目录不存在，创建目录：" + filePath);
            filePath.mkdir();
        }

        // 获取原文件的文件名称
        String originFileName = picture.getOriginalFilename();
        logger.info("原始文件名称为：" + originFileName);

        // 获取文件类型
        String type = originFileName.substring(originFileName.lastIndexOf(".") + 1);
        logger.info("文件类型为：" + type);

        // 获取文件名称
        String name = originFileName.substring(0, originFileName.lastIndexOf("."));

        //设置文件新名称，当前时间+文件名称
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(d);
        String fileName = date + name + "." + type;
        logger.info("新文件名称为：" + fileName);

        // 在指定路径下创建文件
        File targetFile = new File(path, fileName);
        try {
            picture.transferTo(targetFile);
            logger.info("上传成功");
            // 将文件在服务器的存储路径返回
            return new Result(true, "/upload/" + fileName);
        } catch (Exception e) {
            logger.info("上传失败");
            e.printStackTrace();
            return new Result(false, "上传");
        }
    }
}

