package com.husen.store.frame;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 获得屏幕的宽度
	private double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	// 获得屏幕的高度
	private double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	public MyFrame(String title, int width, int height) {
		super(title);
		// 设置窗口大小
		setSize(width, height);
		// 计算窗口居中的坐标
		int x = (int) (screenWidth - width) / 2;
		int y = (int) (screenHeight - height) / 2;
		// 设置窗口的位置
		setLocation(x, y);
		
	}
}
