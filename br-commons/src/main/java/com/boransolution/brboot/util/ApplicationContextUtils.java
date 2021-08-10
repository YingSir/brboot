package com.boransolution.brboot.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/***
 * Spring相关工具类 获得ApplicationContext中的所有bean
 *
 * @author : xy
 *
 * @date : 2021/8/10
 **/
@Component
public class ApplicationContextUtils implements ApplicationContextAware {
    private static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context=applicationContext;
    }
    //根据bean名字获取工厂制定bean对象
    public static Object getBean(String id){
        return context.getBean(id);
    }
}
