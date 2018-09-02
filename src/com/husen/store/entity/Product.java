package com.husen.store.entity;
/*
 * ��Ʒ��Ϣ��
 */
public class Product {

	//��Ʒ���id
	private String productId;
	//��Ʒ����
	private double unitPrice;
	//��Ʒ����
	private String productName;
	//��Ʒ���
	private int surplusNumber;
	//��Ʒ����
	private int amount = 100;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getSurplusNumber() {
		return surplusNumber;
	}
	public void setSurplusNumber(int surplusNumber) {
		this.surplusNumber = surplusNumber;
	}
	public Product(String productId, double unitPrice, String productName, int surplusNumber) {
		super();
		this.productId = productId;
		this.unitPrice = unitPrice;
		this.productName = productName;
		this.surplusNumber = surplusNumber;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return productId+"---"+unitPrice+"---"+productName+"---"+surplusNumber+"---"+amount;
	}
}
