package com.husen.store.dao;

import java.util.List;

import com.husen.store.entity.Product;

public interface ProductDao {
	
	public List<Product> findAll();
	//查询操作
	public Product findById(String productId);
	//刷新操作
	public int update(Product product);
}
