package com.boransolution.brboot.controller;

import com.boransolution.brboot.vo.Member;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;

@RestController
public class MemberController {
    @GetMapping("/member_add_pre")
    public String addPre() { // 增加前的准备操作路径
        return "member_add";
    }
    @PostMapping("/member_add")
    public Object add(@Valid @RequestBody Member vo, BindingResult result) { // 增加前的准备操作路径
        if (result.hasErrors()) { // 现在表示执行的验证出现错误
            result.getAllErrors().forEach(error->System.out.println("【错误信息】code = " + error.getCode() + "，message = " + error.getDefaultMessage()));
            return result.getAllErrors() ;
        } else {
            return vo;
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {		// 在本程序里面需要针对于日期格式进行处理
        // 首先建立一个可以将字符串转换为日期的工具程序类
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
        // 明确的描述此时需要注册一个日期格式的转化处理程序类
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
    }
}
