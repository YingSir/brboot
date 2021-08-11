package com.boransolution.brboot.service;

import com.boransolution.brboot.dao.IFndRoleDao;
import com.boransolution.brboot.po.FndPerm;
import com.boransolution.brboot.util.ApplicationContextUtils;

import java.util.List;

/***
 * shiro角色业务类
 *
 * @author : xy
 *
 * @date : 2021/8/11
 **/
public class RoleServiceImpl implements IRoleService {
    private IFndRoleDao iFndRoleDao = (IFndRoleDao) ApplicationContextUtils.getBean("iFndRoleDao");

    @Override
    public List<FndPerm> findPermsById(Long id) {
        return iFndRoleDao.findPermsById(id);
    }
}
