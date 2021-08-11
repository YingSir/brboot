package com.boransolution.brboot.service;

import com.boransolution.brboot.po.FndRole;
import com.boransolution.brboot.po.FndUser;

import java.util.List;

public interface IUserService {
    void register(FndUser user);

    FndUser findByUsername(String username);

    List<FndRole> findRolesByUsername(String username);
}
