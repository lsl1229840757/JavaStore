package com.husen.store.entity;
/**
 * ���ڼ�¼����
 * @author ��ɭ
 *
 */
public class Order {
	
	//�������
	private int orderId;
	//��������
	private int orderNumber;
	//������Ա
	private String staffName;
	//������Ʒ���
	private String productId;
	//��������
	private double unitPrice;
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Order(int orderId, int orderNumber, String staffName, String productId,double unitPrice) {
		super();
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.staffName = staffName;
		this.productId = productId;
		this.unitPrice = unitPrice;
	}
	public Order() {
		super();
	}
	
}
