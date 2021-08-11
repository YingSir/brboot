package com.boransolution.brboot.po;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/***
 * Shiro用户表
 *
 * @author : xy
 *
 * @date : 2021/8/5
 **/
@Cacheable(true)
@Entity
public class FndUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 根据名称引用配置的主键生成器
    private Long id;
    @NotNull(message = "用户名不能为空")
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @NotNull(message = "密码不能为空")
    private String password;
    private String salt;
    //定义角色对象
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "fnd_user_role",joinColumns = {@JoinColumn(name="user_id")},inverseJoinColumns = {@JoinColumn(name="role_id")})
    private List<FndRole> roles;
    /*--------------------------------------------
     |  A C C E S S O R S / M O D I F I E R S    |
     ============================================*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<FndRole> getRoles() {
        return roles;
    }

    public void setRoles(List<FndRole> roles) {
        this.roles = roles;
    }

}
