package com.husen.store.dao;

import java.util.List;

import com.husen.store.entity.Order;

public interface OrderDao {
	
	//插入操作
	public int insert(Order order);
	//查询操作
	public List<Order> findAll();
	//根据名字查询，用于制作销售信息文件
	public List<Order> findByProductId(String productId);
}
