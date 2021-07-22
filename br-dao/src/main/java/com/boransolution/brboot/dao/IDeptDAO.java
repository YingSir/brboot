package com.boransolution.brboot.dao;

import com.boransolution.brboot.po.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeptDAO extends JpaRepository<Dept, Long> { // 包含有全部的基础Crud支持
}
