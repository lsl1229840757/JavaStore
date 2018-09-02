package com.husen.store.frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

import com.husen.store.dao.OrderDao;
import com.husen.store.dao.ProductDao;
import com.husen.store.daoImpl.OrderDaoImpl;
import com.husen.store.daoImpl.ProductDaoImpl;
import com.husen.store.entity.Order;
import com.husen.store.entity.Product;
import javax.swing.JLabel;

/**
 * ������״ͼ
 * 
 * @author dellyx
 *
 */
public class PieChartFrame extends MyFrame {

	ProductDao pDao = new ProductDaoImpl();
	OrderDao orderDao = new OrderDaoImpl();
	List<Product> list2 = new ArrayList<Product>();
	private static final long serialVersionUID = 1L;

	public PieChartFrame() {
		super("������״ͼ", 800, 500);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		DefaultPieDataset dataset = new DefaultPieDataset();
		list2 = pDao.findAll();
		for (int i = 0; i < list2.size(); i++) {
			Product product = list2.get(i);
			dataset.setValue(product.getProductName(), product.getAmount()-product.getSurplusNumber());
		}
		JFreeChart chart = ChartFactory.createPieChart3D("����ͼ", dataset, true, true, false);
		ChartPanel panel2 = new ChartPanel(chart);
		chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
		PiePlot piePlot= (PiePlot) chart.getPlot();//��ȡͼ���������
		piePlot.setLabelFont(new Font("����",Font.BOLD,10));
		chart.getLegend().setItemFont(new Font("����",Font.BOLD,10));
		panel.add(panel2);
	}

}
