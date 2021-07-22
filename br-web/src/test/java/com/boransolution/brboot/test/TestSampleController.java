package com.boransolution.brboot.test;

import com.boransolution.brboot.controller.MessageController;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = MessageController.class)   //定义要测试的SpringBoot类
@RunWith(SpringJUnit4ClassRunner.class)				// 使用Junit进行测试
@WebAppConfiguration
public class TestSampleController {
    @Autowired
    private MessageController sampleController;		// 注入控制器对象

    @Test
    public void testHome() {						// 使用junit测试
        TestCase.assertEquals(this.sampleController.home(), "www.boransolution.com");
    }
}
