package com.cqupt.service.impl;

import com.cqupt.dao.IUserDao;
import com.cqupt.domain.Role;
import com.cqupt.domain.UsersInfo;
import com.cqupt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public void save(UsersInfo usersInfo) throws Exception {
        usersInfo.setId(UUID.randomUUID().toString().replaceAll("-",""));
        // 对用户密码进行加密
        String newPassWord = new BCryptPasswordEncoder().encode(usersInfo.getPassWord());
        usersInfo.setPassWord(newPassWord);
        userDao.save(usersInfo);
    }

    @Override
    public List<UsersInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    public UsersInfo findById(String userId) throws Exception {
        return userDao.findByUserId(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 获取用户的权限
        UsersInfo usersInfo = null;
        try {
            usersInfo = userDao.findByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 需要写权限
        //User user = new User(usersInfo.getUsername(),new BCryptPasswordEncoder().encode(usersInfo.getPassWord()), getAuthority(usersInfo.getRoles()));
        User user = new User(usersInfo.getUsername(),new BCryptPasswordEncoder().encode(usersInfo.getPassWord()),
                usersInfo.getStatus() == 1 ? true : false,true,true,true,getAuthority(usersInfo.getRoles()));
        return user;
    }

    // 作用是返回一个List集合，集合中装入的是角色,获取用户的角色
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }
}