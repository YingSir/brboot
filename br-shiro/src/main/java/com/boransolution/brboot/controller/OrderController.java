package com.boransolution.brboot.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * 通过shiro控制授权
 *
 * @author : xy
 *
 * @date : 2021/8/10
 **/
@Controller
@RequestMapping
//@RequiresRoles("admin")
//@RequiresRoles(value = {"admin", "user"}) //同时具有admin和user角色
@RequiresRoles(value = {"admin", "user"}, logical = Logical.OR) //属于admin或者user之一;修改logical为OR 即可
public class OrderController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping
    public void save() {
        log.info("保存订单");
        //代码方式
        //获取主体对象
//        Subject subject = SecurityUtils.getSubject();
//        if (subject.hasRole("admin")) {
//            log.info("保存订单");
//        } else {
//            log.info("无权访问");
//        }

    }
}
