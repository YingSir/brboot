package com.boransolution.brboot.po;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Cacheable(true)
@Entity
public class Dept implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 根据名称引用配置的主键生成器
    private Long deptNo; // 字段的映射（属性名称=字段名称）
    private String deptName;

    // setter、getter略
    public Dept() {
    }

    public Long getDeptno() {
        return this.deptNo;
    }

    public void setDeptno(Long deptNo) {
        this.deptNo = deptNo;
    }


    public String getDname() {
        return this.deptName;
    }

    public void setDname(String deptName) {
        this.deptName = deptName;
    }


}
