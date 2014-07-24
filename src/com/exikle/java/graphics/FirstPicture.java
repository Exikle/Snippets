package com.exikle.java.graphics;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FirstPicture extends JFrame implements ActionListener {

	int z = 50;

	MyDrawPanel drawpanel1;

	BasicStroke bs = new BasicStroke(4.0f);

	public static void main(String[] args) {
		new FirstPicture();
	}

	public FirstPicture() {
		drawpanel1 = new MyDrawPanel();

		this.add(drawpanel1);
		this.setSize(600, 600);
		this.setVisible(true);

		for (int m = 200; m < 401; m++) {
			z = m;
			try {
				Thread.sleep(20);
			} catch (InterruptedException ie) {
			}
			repaint();
		}
	}

	public void actionPerformed(ActionEvent e) {}

	class MyDrawPanel extends JPanel {

		public void paintComponent(Graphics g) {
			// Converts the ordinay graphics object into a Graphics2d object
			Graphics2D g2 = (Graphics2D) g;
			// This line takes away the jaggedness and smooths out the lines
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);

			// Sets the width of the line
			g2.setStroke(new BasicStroke(8));
			g2.drawLine(z, z, z + 10, z + 10);
		}
	}
}
