package com.boransolution.brboot.dao;

import com.boransolution.brboot.po.FndPerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFndPers extends JpaRepository<FndPerm, Long> {
}
