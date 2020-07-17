package com.cqupt.service.impl;

import com.cqupt.dao.IRoleDao;
import com.cqupt.domain.Role;
import com.cqupt.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        role.setId(UUID.randomUUID().toString().replaceAll("-",""));
        roleDao.save(role);
    }
}
