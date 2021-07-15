package com.boransolution.brboot.controller;

import com.boransolution.brboot.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    @GetMapping("/exception")
    public Result exception(){
        int result=10/0;
        return Result.success(result);
    }
}
