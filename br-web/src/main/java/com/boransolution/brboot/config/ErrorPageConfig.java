package com.boransolution.brboot.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {
    //定义错误页
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error-404.html");
        ErrorPage error500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error-500.html");
        registry.addErrorPages(error404, error500);
    }
}
