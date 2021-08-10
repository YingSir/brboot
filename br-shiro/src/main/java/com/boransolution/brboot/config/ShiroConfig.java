package com.boransolution.brboot.config;

import com.boransolution.brboot.realms.CustomerRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/***
 * 用来整合shiro框架相关的配置类
 *
 * @author : xy
 *
 * @date : 2021/8/5
 **/
@Configuration
public class ShiroConfig {
    //1.创建shiroFilter：负责拦截所有请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给filter设置安全器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //配置系统受限资源
        //配置系统公共资源
        HashMap<String, String> map = new HashMap<>();
        map.put("/**","authc");//authc,请求这个资源需要认证和授权
        map.put("/user/register","anon");//anon,设置为公共资源，不需要认证和授权
        map.put("/user/login","anon");//anon,设置为公共资源，不需要认证和授权
        //配置默认认证界面
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
    //2.创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //给安全管理器设置realm
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }
    //3.创建自定义realm
    @Bean
    public Realm getRealm(){
        return new CustomerRealm();
    }
}
