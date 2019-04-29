package com.ruanko.rent.util;

import com.ruanko.rent.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * FileUtil Class
 *
 * @author zhangjianyun
 * @date 2018-9-29
 */
public class FileUtil {
    public static String uploadFile(MultipartFile file) {
        /**
         * 上传文件
         */
        try{
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀名,比如图片的jpeg,png
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 生成一个随机字符串作为转换后的文件名
            fileName = UUID.randomUUID() + suffixName;
            //文件上传后的路径
            String filePath = "C:\\picture\\";

            File dest = new File(filePath + fileName);

            try {
                file.transferTo(dest);
                //上传成功，返回文件名
                return "/picture/"+fileName;
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(Exception e){
        }
        return null;
    }


}
