package com.cqupt.service;

import com.cqupt.domain.UsersInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    public List<UsersInfo> findAll() throws Exception;

    public void save(UsersInfo usersInfo) throws Exception;


    // 通过用户的id找到对应的用户 和 所用的角色
    public UsersInfo findById(String id) throws Exception;
}
