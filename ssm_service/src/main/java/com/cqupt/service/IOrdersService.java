package com.cqupt.service;

import com.cqupt.domain.Orders;

import java.util.List;

public interface IOrdersService {

    List<Orders> findAll() throws Exception;
}
