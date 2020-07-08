package com.cqupt.service.impl;

import com.cqupt.domain.Orders;
import com.cqupt.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersService ordersService;


    @Override
    public List<Orders> findAll() throws Exception {

        return ordersService.findAll();
    }
}
