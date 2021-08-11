package com.boransolution.brboot.realms;

import com.boransolution.brboot.po.FndPerm;
import com.boransolution.brboot.po.FndRole;
import com.boransolution.brboot.po.FndUser;
import com.boransolution.brboot.service.IRoleService;
import com.boransolution.brboot.service.IUserService;
import com.boransolution.brboot.util.ApplicationContextUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/***
 * @description : 自定义realm实现,将认证/授权数据的来源转为数据库的实现,加入md5+salt+hash
 *
 * @author : xy
 *
 * @date : 2021/8/4
 **/
public class CustomerRealm extends AuthorizingRealm {
    private final Logger log = LoggerFactory.getLogger(getClass());
    //在工厂中获取service对象
    private IUserService iUserService = (IUserService) ApplicationContextUtils.getBean("iUserService");
    private IRoleService iRoleService = (IRoleService) ApplicationContextUtils.getBean("iRoleService");


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //拿到主身份信息
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        log.info("调用授权验证：", primaryPrincipal);
        //根据身份信息获取当前用户的角色信息和权限
        List<FndRole> roles = iUserService.findRolesByUsername(primaryPrincipal);
        if (CollectionUtils.isNotEmpty(roles)) {
            //将数据库中查询角色信息赋值给权限对象
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            roles.stream().forEach(role -> {
                simpleAuthorizationInfo.addRole(role.getName());
                //权限信息
                List<FndPerm> perms = iRoleService.findPermsById(role.getId());
                if (CollectionUtils.isNotEmpty(perms)) {
                    perms.forEach(perm->simpleAuthorizationInfo.addStringPermission(perm.getName()));
                }

            });
            return simpleAuthorizationInfo;
        }
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //在token中获取用户名
        String principal = (String) authenticationToken.getPrincipal();
        //根据身份信息查询相关数据库
        FndUser user = iUserService.findByUsername(principal);
        if (ObjectUtils.isNotEmpty(user)) {
            return new SimpleAuthenticationInfo(user.getUsername(),
                    user.getPassword(),
                    ByteSource.Util.bytes(user.getSalt()),
                    this.getName());
        }
        return null;
    }
}
