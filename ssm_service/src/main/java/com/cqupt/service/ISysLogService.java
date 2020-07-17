package com.cqupt.service;

import com.cqupt.domain.SysLog;

import java.util.List;

public interface ISysLogService {

    public void save(SysLog sysLog);


    public List<SysLog> findAll();
}
