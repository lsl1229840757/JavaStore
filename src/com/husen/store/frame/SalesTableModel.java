package com.husen.store.frame;

import javax.swing.table.AbstractTableModel;

public class SalesTableModel extends AbstractTableModel{

	private Object data[][];

	// �����������
	private String[] columnNames = { "���", "���", "����Ա", "����","����","�ܼ�" };
	@Override
	public int getRowCount() {
		return data.length;
	}

	public SalesTableModel(Object[][] data){
		this.data = data;
	}
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
}
