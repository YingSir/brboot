package com.boransolution.brboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //启动SpringBoot程序，而后自带子包扫描
public class SpringBootStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStartApplication.class,args);   //启动SpringBoot程序
    }
}
