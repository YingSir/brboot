package com.boransolution.brboot.service;

import com.boransolution.brboot.dao.IFndRoleDao;
import com.boransolution.brboot.dao.IFndUserDao;
import com.boransolution.brboot.po.FndRole;
import com.boransolution.brboot.po.FndUser;
import com.boransolution.brboot.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/***
 * 用户注册
 *
 * @author : xy
 *
 * @date : 2021/8/5
 **/
@Service
@Transactional
public class UserServiceImpl implements IUserService {
    private IFndUserDao iFndUserDao;
    private IFndRoleDao iFndRoleDao;
    private static final int HASH_ITERATIONS=1024;
    @Autowired
    public UserServiceImpl(IFndUserDao iFndUserDao) {
        this.iFndUserDao = iFndUserDao;
    }

    @Override
    public void register(FndUser user) {
        //1.生成随机盐
        String salt = SaltUtils.getSalt(9);
        //2.将随机盐保存到数据
        user.setSalt(salt);
        //3.明文密码进行md5+salt+hash散列
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, HASH_ITERATIONS);
        user.setPassword(md5Hash.toHex());
        iFndUserDao.save(user);
    }

    @Override
    public FndUser findByUsername(String username) {
        return iFndUserDao.findByUsername(username);
    }

    @Override
    public List<FndRole> findRolesByUsername(String username) {
        return iFndUserDao.findRolesByUsername(username);
    }
}
