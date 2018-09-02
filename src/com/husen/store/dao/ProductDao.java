package com.husen.store.dao;

import java.util.List;

import com.husen.store.entity.Product;

public interface ProductDao {
	
	public List<Product> findAll();
	//��ѯ����
	public Product findById(String productId);
	//ˢ�²���
	public int update(Product product);
}
