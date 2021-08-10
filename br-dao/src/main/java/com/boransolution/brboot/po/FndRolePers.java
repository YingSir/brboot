//package com.boransolution.brboot.po;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
///***
// * shiro角色权限关系表
// *
// * @author : xy
// *
// * @date : 2021/8/10
// **/
//@Cacheable(true)
//@Entity
//public class FndRolePers {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // 根据名称引用配置的主键生成器
//    private Long id;
//
//    @NotNull(message = "角色id不能为空")
//    private Long roleId;
//    @NotNull(message = "权限id不能为空")
//    private Long perId;
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Id
//    public Long getId() {
//        return id;
//    }
//
//    public Long getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(Long roleId) {
//        this.roleId = roleId;
//    }
//
//    public Long getPerId() {
//        return perId;
//    }
//
//    public void setPerId(Long perId) {
//        this.perId = perId;
//    }
//
//    public FndRolePers(Long id, Long roleId, Long perId) {
//        this.id = id;
//        this.roleId = roleId;
//        this.perId = perId;
//    }
//
//    public FndRolePers() {
//    }
//
//}
