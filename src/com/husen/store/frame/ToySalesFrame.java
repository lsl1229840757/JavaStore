package com.husen.store.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import com.husen.store.dao.OrderDao;
import com.husen.store.dao.ProductDao;
import com.husen.store.daoImpl.OrderDaoImpl;
import com.husen.store.daoImpl.ProductDaoImpl;
import com.husen.store.entity.Order;
import com.husen.store.entity.Product;

public class ToySalesFrame extends MyFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textStaffName;
	private JTextField textToyCode;
	private JTextField textQuantity;
	private JTable table;
	private OrderDao orderDao = new OrderDaoImpl();
	private ProductDao pDao = new ProductDaoImpl();
	private Object data[][];
	private List<Order> list = new ArrayList<Order>();
	private JScrollPane scrollPane;

	public ToySalesFrame() {
		super("商品主列表", 650, 600);
		getContentPane().setLayout(null);

		JButton btnShowToys = new JButton("Show Toys");
		btnShowToys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockFrame sFrame = new StockFrame();
				sFrame.setVisible(true);
			}
		});
		btnShowToys.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		btnShowToys.setForeground(Color.BLACK);
		btnShowToys.setBounds(35, 5, 113, 27);
		getContentPane().add(btnShowToys);

		JButton btnPieChart = new JButton("Show PieChart");
		btnPieChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PieChartFrame cFrame = new PieChartFrame();
				cFrame.setVisible(true);
			}
		});
		btnPieChart.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		btnPieChart.setBounds(162, 5, 152, 27);
		getContentPane().add(btnPieChart);

		JButton button3 = new JButton("Save and Exit");
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String path = ToySalesFrame.getPath();
					if (path != null) {
						BufferedWriter writer = new BufferedWriter(new FileWriter(path + "/a.txt"));
						writer.write("       玩具销售统计");
						System.out.println("写入");
						writer.newLine();
						writer.write("    -------------------");
						writer.newLine();
						List<Product> list2 = pDao.findAll();
						System.out.println(list2);
						for (int i = 0; i < list2.size(); i++) {
							int count = 0;
							Product product = list2.get(i);
							writer.write(product.getProductId() + "    " + product.getProductName() + "      单价"
									+ product.getUnitPrice());
							writer.newLine();
							List<Order> list3 = new ArrayList<Order>();
							list3 = orderDao.findByProductId(product.getProductId());
							System.out.println(list3);
							for (int j = 0; j < list3.size(); j++) {
								Order order = list3.get(j);
								writer.write(order.getOrderId() + "   " + order.getStaffName() + "---------"
										+ order.getOrderNumber() + "*" + order.getUnitPrice() + "="
										+ order.getOrderNumber() * order.getUnitPrice() + "元");
								writer.newLine();
								count = count + order.getOrderNumber();
							}
							writer.write("--------------------------------------");
							writer.newLine();
							writer.write("总销量：" + count + "         " + count * product.getUnitPrice());
							writer.newLine();
							writer.write("--------------------------------------");
							writer.newLine();
							writer.flush();
						}
						System.exit(0);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {

				}

			}
		});

		button3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		button3.setBounds(488, 5, 134, 27);
		getContentPane().add(button3);

		JButton btnOrder = new JButton("Process Sale");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String staffName = textStaffName.getText();
				String toyCode = textToyCode.getText();
				int quantity;
				try {
					quantity = Integer.parseInt(textQuantity.getText());
				} catch (Exception e1) {
					quantity = -1;
				}
				Product p = pDao.findById(toyCode);
				if (staffName == null || p == null || quantity <= -1) {
					JLabel label = new JLabel("您输入的数据有误，请重新输入");
					JOptionPane.showMessageDialog(null, label, "输入错误", JOptionPane.ERROR_MESSAGE);
				} else if (quantity > p.getSurplusNumber()) {
					JLabel label = new JLabel("购买量大于剩余量！");
					JOptionPane.showMessageDialog(null, label, "输入错误", JOptionPane.ERROR_MESSAGE);
				} else {
					p.setSurplusNumber(p.getSurplusNumber() - quantity);
					Order order = new Order();
					order.setOrderNumber(quantity);
					order.setProductId(toyCode);
					order.setStaffName(staffName);
					order.setUnitPrice(p.getUnitPrice());
					// 插入数据库
					orderDao.insert(order);
					pDao.update(p);
					scrollPane.add(getTable());
					scrollPane.setViewportView(getTable());
				}
			}
		});
		btnOrder.setBounds(69, 430, 129, 27);
		getContentPane().add(btnOrder);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textStaffName.setText("");
				textToyCode.setText("");
				textQuantity.setText("");
			}
		});
		btnClear.setBounds(69, 501, 128, 27);
		getContentPane().add(btnClear);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(55, 57, 503, 343);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 57, 530, 343);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(textArea);
		scrollPane.add(getTable());
		scrollPane.setViewportView(getTable());
		JLabel label7 = new JLabel("Staff Name");
		label7.setBounds(356, 434, 86, 18);
		getContentPane().add(label7);

		JLabel label8 = new JLabel("Toy Code");
		label8.setBounds(356, 479, 86, 18);
		getContentPane().add(label8);

		JLabel label9 = new JLabel("Quantity");
		label9.setBounds(356, 519, 86, 18);
		getContentPane().add(label9);

		textStaffName = new JTextField();
		textStaffName.setBounds(472, 431, 86, 24);
		getContentPane().add(textStaffName);
		textStaffName.setColumns(10);

		textToyCode = new JTextField();
		textToyCode.setBounds(472, 476, 86, 24);
		getContentPane().add(textToyCode);
		textToyCode.setColumns(10);

		textQuantity = new JTextField();
		textQuantity.setBounds(472, 516, 86, 24);
		getContentPane().add(textQuantity);
		textQuantity.setColumns(10);

		JButton btnBarChart = new JButton("Show BarChart");
		btnBarChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BarChartFrame bFrame = new BarChartFrame();
				bFrame.setVisible(true);
			}
		});
		btnBarChart.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		btnBarChart.setBounds(329, 5, 145, 27);
		getContentPane().add(btnBarChart);
		// 注册窗口事件
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// 退出系统
				System.exit(0);
			}
		});
		this.setResizable(false);
	}

	public JTable getTable() {
		list = orderDao.findAll();
		data = new Object[list.size()][6];
		for (int i = 0; i < list.size(); i++) {
			data[i][0] = i + 1;
			data[i][1] = list.get(i).getProductId();
			data[i][2] = list.get(i).getStaffName();
			data[i][3] = list.get(i).getOrderNumber();
			data[i][4] = list.get(i).getUnitPrice();
			data[i][5] = (double) data[i][4] * (int) data[i][3];
		}

		SalesTableModel model = new SalesTableModel(data);
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

	private static String getPath() {
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File com = fsv.getHomeDirectory();
		JFileChooser jf = new JFileChooser(com);
		jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		File file = null;
		String path = null;
		int flag = jf.showOpenDialog(null);
		if (jf.APPROVE_OPTION == flag) {
			file = jf.getSelectedFile();
			path = file.getAbsolutePath();
		}
		return path;
	}
}
