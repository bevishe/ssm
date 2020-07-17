package com.cqupt.service.impl;

import com.cqupt.dao.IPermissionDao;
import com.cqupt.domain.Permission;
import com.cqupt.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permission.setId(UUID.randomUUID().toString().replaceAll("-",""));
        permissionDao.save(permission);
    }
}
