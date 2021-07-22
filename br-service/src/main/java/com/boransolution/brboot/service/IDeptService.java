package com.boransolution.brboot.service;

import com.boransolution.brboot.po.Dept;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IDeptService {
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Dept> list() ;
}
