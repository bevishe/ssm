package com.cqupt.dao;

import com.cqupt.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    // 查询所有的permission
    @Select("select * from permission")
    public List<Permission> findAll();

    @Select("select * from permission where id in (select permissionId from role_permission where id = #{roleId})")
    public List<Permission> findByRoleId(String roleId);

    @Insert("insert into permission() values(#{id},#{permissionName},#{url})")
    public void save(Permission permission);
}
