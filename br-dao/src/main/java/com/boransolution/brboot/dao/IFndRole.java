package com.boransolution.brboot.dao;

import com.boransolution.brboot.po.FndRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFndRole extends JpaRepository<FndRole,Long> {
}
