package com.boransolution.brboot.controller;

import com.boransolution.brboot.enums.ResultCode;
import com.boransolution.brboot.vo.Result;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class UploadController {
    @GetMapping("/upload_pre")
    public String uploadPre() { // 通过model可以实现内容的传递
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public Object upload(String name, HttpServletRequest request) {
        List<String> result = new ArrayList<String>();
        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
            List<MultipartFile> files = mRequest.getFiles("photo");
            files.forEach(photo -> {
                try {
                    result.add(this.saveFile(photo));   // 保存上传信息
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        return Result.success(ResultCode.SUCCESS, result);
    }

    /**
     * 文件保存处理
     *
     * @param file 上传文件
     * @return 文件保存路径
     * @throws Exception 上传异常
     */
    public String saveFile(MultipartFile file) throws Exception {
        String path = "nothing";
        if (ObjectUtils.isNotEmpty(file)) {                    // 有文件上传
            String fileName = UUID.randomUUID() + "."
                    + file.getContentType().substring(
                    file.getContentType().lastIndexOf("/") + 1);    // 创建文件名称
            path = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest().getServletContext().getRealPath("/") + fileName;
            File saveFile = new File(path);
            file.transferTo(saveFile);        // 文件保存
        }
        return path;
    }
}
