package com.boransolution.brboot.service;

import com.boransolution.brboot.po.FndPerm;

import java.util.List;

public interface IRoleService {
    List<FndPerm> findPermsById(Long id);
}
