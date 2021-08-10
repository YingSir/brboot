package com.boransolution.brboot.dao;

import com.boransolution.brboot.po.FndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDAO extends JpaRepository<FndUser,Long> {
    FndUser findByUsername (String username);
}
