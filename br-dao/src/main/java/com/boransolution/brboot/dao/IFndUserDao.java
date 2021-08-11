package com.boransolution.brboot.dao;

import com.boransolution.brboot.po.FndRole;
import com.boransolution.brboot.po.FndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFndUserDao extends JpaRepository<FndUser,Long> {
    FndUser findByUsername (String username);

    List<FndRole> findRolesByUsername(String username);
}
