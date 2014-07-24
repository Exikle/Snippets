package com.exikle.java.graphics;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawnPanelTemplate extends JFrame {

	final DrwPnl drawPanel;

	public static void main(String[] args) throws Exception {
		new DrawnPanelTemplate();
	}

	public DrawnPanelTemplate() {
		drawPanel = new DrwPnl();
	}

	class DrwPnl extends JPanel {

		public void paintComponent(Graphics g) {}
	}
}