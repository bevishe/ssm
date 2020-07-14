package com.cqupt.service;

import com.cqupt.domain.Role;

import java.util.List;

public interface IRoleService {

    // 获取所有的角色信息
    public List<Role> findAll() throws Exception;

    // 添加新的角色
    public void save(Role role) throws Exception;
}
