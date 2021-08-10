package com.boransolution.brboot.service;

import com.boransolution.brboot.po.FndUser;

public interface IUserService {
    void register(FndUser user);
    FndUser findByUsername(String username);
}
