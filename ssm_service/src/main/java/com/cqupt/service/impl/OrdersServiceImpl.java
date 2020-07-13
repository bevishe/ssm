package com.cqupt.service.impl;

import com.cqupt.dao.IOrdersDao;
import com.cqupt.domain.Orders;
import com.cqupt.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao iOrdersDao;


    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        // 参数是pageNum是页码值， 参数 pageSize 代表每页显示条数
        PageHelper.startPage(page,size);
        return iOrdersDao.findAll();
    }

    @Override
    public Orders findById(String id) throws Exception {
        return iOrdersDao.findById(id);
    }
}
