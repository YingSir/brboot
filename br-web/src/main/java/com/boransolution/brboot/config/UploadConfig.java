package com.boransolution.brboot.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import javax.servlet.MultipartConfigElement;

@Configuration
public class UploadConfig {
    @Bean
    public MultipartConfigElement getMultipartConfig() {
        MultipartConfigFactory config = new MultipartConfigFactory() ;
        config.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES)); 			// 设置上传文件的单个大小限制
        config.setMaxRequestSize(DataSize.of(100, DataUnit.MEGABYTES)); 		// 设置总的上传的大小限制
        config.setLocation("/"); 				// 设置临时保存目录
        return config.createMultipartConfig() ;	// 创建一个上传配置
    }
}