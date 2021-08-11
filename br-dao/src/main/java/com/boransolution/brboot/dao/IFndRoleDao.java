package com.boransolution.brboot.dao;

import com.boransolution.brboot.po.FndPerm;
import com.boransolution.brboot.po.FndRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFndRoleDao extends JpaRepository<FndRole, Long> {
    List<FndPerm> findPermsById(Long id);
}
