package com.husen.store.frame;

import javax.swing.table.AbstractTableModel;

public class ProductTableModel extends AbstractTableModel {

	// 表格数据
	private Object[][] data;

	// 表格列名数组
	private String[] columnNames = { "玩具代码", "玩具名称", "单价", "库存" };

	public ProductTableModel(Object[][] data) {
		this.data = data;
	}
	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	
		return data[rowIndex][columnIndex];
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	
}
