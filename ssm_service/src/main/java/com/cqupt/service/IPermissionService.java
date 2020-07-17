package com.cqupt.service;

import com.cqupt.domain.Permission;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPermissionService {
    public List<Permission> findAll() throws Exception;

    public void save(Permission permission) throws Exception;
}
