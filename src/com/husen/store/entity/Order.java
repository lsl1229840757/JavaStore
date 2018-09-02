package com.husen.store.entity;
/**
 * 用于记录订单
 * @author 胡森
 *
 */
public class Order {
	
	//订单编号
	private int orderId;
	//订单数量
	private int orderNumber;
	//销售人员
	private String staffName;
	//销售商品编号
	private String productId;
	//订单单价
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
