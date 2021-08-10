package com.boransolution.brboot.dao;

import com.boransolution.brboot.po.FndUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDAO extends JpaRepository<FndUser,Long> {
    FndUser findByUsername (String username);
}
