package com.cqupt.dao;

import com.cqupt.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {

    // 完成product持久化操作

    // 查询所有的产品信息
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    // 向数据库中添加产品

    @Insert("insert into product(id,productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus) values({1},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
