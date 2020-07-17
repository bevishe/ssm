package com.cqupt.dao;

import com.cqupt.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {

    // 根据用户的id找到用户的角色 以及角色对应的权限
    @Select("select * from role where id in(select roleId from users_role where userId = #{usersId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many = @Many(select = "com.cqupt.dao.IPermissionDao.findByRoleId"))
    })
    public List<Role> findByUsersId(String usersId) throws Exception;

    //获取所有的角色信息
    @Select("select * from role")
    public List<Role> findAll() throws Exception;

    // 添加角色信息
    @Insert("insert into role() values(#{id},#{roleName},#{roleDesc})")
    public void save(Role role) throws Exception;
}