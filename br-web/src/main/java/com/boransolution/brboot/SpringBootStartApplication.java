package com.boransolution.brboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication  //启动SpringBoot程序，而后自带子包扫描
@EnableJpaRepositories(basePackages = "com.boransolution.brboot.dao")
public class SpringBootStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStartApplication.class,args);   //启动SpringBoot程序
    }
}
