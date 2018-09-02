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
	// �����Ļ�Ŀ��
	private double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	// �����Ļ�ĸ߶�
	private double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	public MyFrame(String title, int width, int height) {
		super(title);
		// ���ô��ڴ�С
		setSize(width, height);
		// ���㴰�ھ��е�����
		int x = (int) (screenWidth - width) / 2;
		int y = (int) (screenHeight - height) / 2;
		// ���ô��ڵ�λ��
		setLocation(x, y);
		
	}
}
