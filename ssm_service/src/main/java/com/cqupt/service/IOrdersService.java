package com.cqupt.service;

import com.cqupt.domain.Orders;

import java.util.List;

public interface IOrdersService {

    List<Orders> findAll(int page,int size) throws Exception;



    Orders findById(String id) throws Exception;
}
