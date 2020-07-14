package com.cqupt.service;

import com.cqupt.domain.UsersInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    public List<UsersInfo> findAll() throws Exception;

    public void save(UsersInfo usersInfo) throws Exception;

    public UsersInfo findById(String userId) throws Exception;
}
