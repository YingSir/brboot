package com.boransolution.brboot.controller;

import com.boransolution.brboot.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Locale;

/**
 * @author Administrator
 */
@RestController //建立控制器,所有路径以Restful形式运行
public class MessageController {
    private MessageSource messageSource;
    private MessageUtil messageUtil;
    @Autowired
    public MessageController(MessageSource messageSource, MessageUtil messageUtil){
        this.messageSource=messageSource;   //注入资源对象
        this.messageUtil=messageUtil;
    }
    @GetMapping("/message")    //只支持get请求模式
    public Object message(){
        HashMap<String, String> map = new HashMap<>();
        map.put("welcome.url",this.messageSource.getMessage("welcome.url",null, Locale.getDefault()));
        map.put("welcome.msg",this.messageSource.getMessage("welcome.msg",new Object[]{"邢博然"}, Locale.getDefault()));
        map.put("en_welcome_url",this.messageSource.getMessage("welcome.url",null, new Locale("en","US")));
        map.put("en_welcome.msg",this.messageSource.getMessage("welcome.msg",new Object[]{"邢博然"}, new Locale("en","US")));
        return map;
    }

    @RequestMapping("/")  //访问路径映射
    public String home() {
        return "www.boransolution.com";
    }

    @GetMapping("/echo/{message}")    //只支持get请求模式
    public String echo(@PathVariable("message") String msg){
        return "【ECHO】"+msg;
    }

    @GetMapping("/object")
    public Object object(HttpServletRequest request, HttpServletResponse response){
//        另一种获取内置对象HttpServletRequest和HttpServletResponse的方法
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpServletRequest response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        HashMap<String, String> map = new HashMap<>();
        map.put("客户端IP地址",request.getRemoteAddr());
        map.put("客户端响应编码",request.getCharacterEncoding());
        map.put("SessionID",request.getSession().getId());
        map.put("项目真实路径",request.getServletContext().getRealPath("/"));
        return map; //以Restful风格返回
    }
    @GetMapping("/info")
    public Object info(){
        return this.messageUtil.getInfo();
    }


}
