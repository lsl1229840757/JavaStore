package com.husen.store.frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.husen.store.dao.ProductDao;
import com.husen.store.daoImpl.ProductDaoImpl;
import com.husen.store.entity.Product;

/**
 * 库存窗口
 * 
 * @author dellyx
 *
 */

public class StockFrame extends MyFrame {

	private List<Product> list = new ArrayList<Product>();
	// 表格数据
	private Object[][] data;

	private ProductDao pDao = new ProductDaoImpl();
	// 表格
	private JTable table = null;

	public StockFrame() {
		super("库存", 600, 400);
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.add(getTable());
		scrollPane.setViewportView(getTable());
	}

	public JTable getTable() {
		list = pDao.findAll();
		data = new Object[list.size()][4];
		for (int i = 0; i < list.size(); i++) {
			String productId = list.get(i).getProductId();
			Product p = pDao.findById(productId);
			data[i][0] = productId;
			data[i][1] = p.getProductName();
			data[i][2] = p.getUnitPrice();
			data[i][3] = p.getSurplusNumber();
		}
		ProductTableModel model = new ProductTableModel(data);
		if (table == null) {
			table = new JTable(model);
			// 设置表格字体
			table.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
			// 设置表格标题字体
			table.getTableHeader().setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
			// 设置行高
			table.setRowHeight(51);
		} else {
			table.setModel(model);
		}

		return table;

	}

}
