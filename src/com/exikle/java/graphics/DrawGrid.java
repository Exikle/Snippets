package com.exikle.java.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawGrid extends JFrame {

	MyDrawPanel drawpanel1;

	public static void main(String[] args) {
		new DrawGrid();
	}

	public DrawGrid() {
		drawpanel1 = new MyDrawPanel();
		this.add(drawpanel1);

		this.setSize(800, 500);
		this.setVisible(true);
	}

	private class MyDrawPanel extends JPanel {

		public void paintComponent(Graphics g) {
			// Converts the ordinay graphics object into a Graphics2d object
			Graphics2D g2 = (Graphics2D) g;
			// This line takes away the jaggedness and smooths out the lines
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			// drawGrid Codes
			for (int x = 0; x <= 800; x += 25) {
				g2.drawLine(x, 0, x, 500);
				g2.drawString("" + x, x, 20);
			}
			for (int y = 0; y <= 500; y += 25) {
				g2.drawLine(0, y, 800, y);
				g2.drawString("" + y, 0, y + 20);
			}
		}
	}
}
