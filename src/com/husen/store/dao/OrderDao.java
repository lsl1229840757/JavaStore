package com.husen.store.dao;

import java.util.List;

import com.husen.store.entity.Order;

public interface OrderDao {
	
	//�������
	public int insert(Order order);
	//��ѯ����
	public List<Order> findAll();
	//�������ֲ�ѯ����������������Ϣ�ļ�
	public List<Order> findByProductId(String productId);
}
