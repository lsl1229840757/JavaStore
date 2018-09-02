package com.husen.store.frame;

import javax.swing.table.AbstractTableModel;

public class ProductTableModel extends AbstractTableModel {

	// �������
	private Object[][] data;

	// �����������
	private String[] columnNames = { "��ߴ���", "�������", "����", "���" };

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
