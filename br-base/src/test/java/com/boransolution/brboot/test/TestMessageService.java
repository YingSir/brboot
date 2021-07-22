package com.boransolution.brboot.test;

import com.boransolution.brboot.SpringBootStartApplication;
import com.boransolution.brboot.service.IMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = SpringBootStartApplication.class)	// 定义要测试的SpringBoot类
@RunWith(SpringJUnit4ClassRunner.class)			// 使用Junit进行测试
@WebAppConfiguration                                // 进行Web应用配置
public class TestMessageService {
    @Autowired
    private IMessageService messageService ;
    @Test
    public void testEcho() {
        System.out.println(this.messageService.echo("www.boransolution.com"));
    }
}

