package com.husen.store.frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.husen.store.dao.OrderDao;
import com.husen.store.dao.ProductDao;
import com.husen.store.daoImpl.OrderDaoImpl;
import com.husen.store.daoImpl.ProductDaoImpl;
import com.husen.store.entity.Product;

/**
 * ������״ͼ
 * 
 * @author dellyx
 *
 */
public class BarChartFrame extends MyFrame {
	ProductDao pDao = new ProductDaoImpl();
	OrderDao orderDao = new OrderDaoImpl();
	List<Product> list2 = new ArrayList<Product>();
	private static final long serialVersionUID = 1L;

	public BarChartFrame() {
		super("������״ͼ", 800, 550);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		list2 = pDao.findAll();
		for (int i = 0; i < list2.size(); i++) {
			Product product = list2.get(i);
			dataSet.addValue(product.getAmount() - product.getSurplusNumber(), "number", product.getProductName());
		}
		JFreeChart chart = ChartFactory.createBarChart3D("������״ͼ", "����", "������", dataSet, PlotOrientation.VERTICAL, false,
				false, false);
		ChartPanel panel2 = new ChartPanel(chart);
		CategoryPlot plot = chart.getCategoryPlot();// ��ȡͼ���������
		CategoryAxis domainAxis = plot.getDomainAxis();
		// ˮƽ�ײ��б�
		domainAxis.setLabelFont(new Font("����", Font.BOLD, 14));
		// ˮƽ�ײ�����
		domainAxis.setTickLabelFont(new Font("����", Font.BOLD, 12));
		// ��ֱ����
		ValueAxis rangeAxis = plot.getRangeAxis();// ��ȡ��״
		rangeAxis.setLabelFont(new Font("����", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
		panel.add(panel2);
	}

}
