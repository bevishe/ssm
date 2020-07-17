package com.cqupt.dao;

import com.cqupt.domain.Permission;
import com.cqupt.domain.Role;
import com.cqupt.domain.UsersInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.UUID;

public interface IUserDao {

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "passWord",column = "PASSWORD"),
            @Result(property = "status",column = "STATUS"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "com.cqupt.dao.IRoleDao.findByUsersId")),
    })
    public UsersInfo findByUserName(String username) throws Exception;

    @Select("select * from users")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "passWord",column = "PASSWORD"),
            @Result(property = "status",column = "STATUS"),
//          @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "com.cqupt.dao.IRoleDao.findByUsersId")),
    })
    public List<UsersInfo> findAll() throws Exception;

    @Insert("insert into users(id,email,username,PASSWORD,phoneNum,STATUS) values(#{id},#{email},#{username},#{passWord},#{phoneNum},#{status})")
    public void save(UsersInfo usersInfo) throws Exception;

    @Select("select * from users where id = #{userId}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "passWord",column = "PASSWORD"),
            @Result(property = "status",column = "STATUS"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "com.cqupt.dao.IRoleDao.findByUsersId")),

    })
    public UsersInfo findByUserId(String userId) throws Exception;


    // 通过用户的id来查询用户的基本信息以及该用户的角色 已经 角色的权限
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "passWord",column = "PASSWORD"),
            @Result(property = "status",column = "STATUS"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "com.cqupt.dao.IRoleDao.findByUsersId"))
    })
    public UsersInfo findById(String id);

}