package com.boransolution.brboot.po;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/***
 * shiro权限
 *
 * @author : xy
 *
 * @date : 2021/8/10
 **/
@Cacheable(true)
@Entity
public class FndPerm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 根据名称引用配置的主键生成器
    private Long id;
    @NotNull(message = "权限名不能为空")
    private String name;
    @NotNull(message = "资源名不能为空")
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
