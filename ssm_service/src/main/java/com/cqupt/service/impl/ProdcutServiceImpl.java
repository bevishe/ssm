package com.cqupt.service.impl;

import com.cqupt.dao.IProductDao;
import com.cqupt.domain.Product;
import com.cqupt.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProdcutServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;


    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }
}
