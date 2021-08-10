//package com.boransolution.brboot.po;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
///***
// * shiro用户角色关系表
// *
// * @author : xy
// *
// * @date : 2021/8/10
// **/
//@Cacheable(true)
//@Entity
//public class FndUserRole {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // 根据名称引用配置的主键生成器
//    private Long id;
//    @NotNull(message = "用户id不能为空")
//    private Long userId;
//    @NotNull(message = "角色id不能为空")
//    private Long roleId;
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Id
//    public Long getId() {
//        return id;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
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
//    public FndUserRole(Long id, Long userId, Long roleId) {
//        this.id = id;
//        this.userId = userId;
//        this.roleId = roleId;
//    }
//
//    public FndUserRole() {
//    }
//}
