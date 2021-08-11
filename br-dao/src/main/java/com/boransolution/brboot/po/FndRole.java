package com.boransolution.brboot.po;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/***
 * shiro角色
 *
 * @author : xy
 *
 * @date : 2021/8/10
 **/
@Cacheable(true)
@Entity
public class FndRole {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "角色名不能为空")
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    //定义权限对象
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "fnd_role_pers", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "perm_id")})
    private List<FndPerm> perms;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FndPerm> getPerms() {
        return perms;
    }

    public void setPerms(List<FndPerm> perms) {
        this.perms = perms;
    }
}
