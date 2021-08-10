package com.boransolution.brboot.controller;

import com.boransolution.brboot.po.FndUser;
import com.boransolution.brboot.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/***
 * 用来处理身份验证
 *
 * @author : xy
 *
 * @date : 2021/8/5
 **/
@Controller
@RequestMapping("user")
public class UserController {
    private IUserService iUserService;
    @PostMapping("login")
    public String login(String username,String password){
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username,password));
            return "redirect:/index";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误");
        } catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码不正确");
        }
        return "redirect:/login";
    }

    /**
     * 用户注册
     * @param user
     * @param result
     * @return
     */
    @PostMapping("register")
    public String register(@Valid @RequestBody FndUser user, BindingResult result){
        if (result.hasErrors()) { // 现在表示执行的验证出现错误
            result.getAllErrors().forEach(error->System.out.println("【错误信息】code = " + error.getCode() + "，message = " + error.getDefaultMessage()));
            return result.getAllErrors().toString() ;
        } else {
            try {
                iUserService.register(user);
                return "redirect:/login";
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:/register";
            }
        }
    }
}
