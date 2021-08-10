package com.boransolution.brboot.service.impl;

import com.boransolution.brboot.dao.IDeptDAO;
import com.boransolution.brboot.po.Dept;
import com.boransolution.brboot.service.IDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements IDeptService {
    @Resource
    private IDeptDAO deptDAO ;
    @Override
    public List<Dept> list() {
        return this.deptDAO.findAll() ;
    }

}
