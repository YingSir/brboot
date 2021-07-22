package com.boransolution.brboot.service.impl;

import com.boransolution.brboot.dao.IDeptDAO;
import com.boransolution.brboot.po.Dept;
import com.boransolution.brboot.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements IDeptService {
    @Autowired
    private IDeptDAO deptDAO ;
    @Override
    public List<Dept> list() {
        return this.deptDAO.findAll() ;
    }

}
