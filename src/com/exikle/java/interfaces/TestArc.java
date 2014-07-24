package com.exikle.java.interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.geom.Arc2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestArc {

	public static void main(String[] args) {
		new TestArc();
	}

	public TestArc() {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				JFrame frame = new JFrame("Test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new BorderLayout());
				frame.add(new TestPane());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}

		});
	}

	@SuppressWarnings("serial")
	public class TestPane extends JPanel {

		public TestPane() {
			setBackground(new Color(250, 250, 250));
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(200, 200);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();

			int radius = Math.min(getWidth(), getHeight());
			int x = (getWidth() - radius) / 2;
			int y = (getHeight() - radius) / 2;

			final Color ICE_BLUE = new Color(16, 135, 232);
			RadialGradientPaint rgp = new RadialGradientPaint(
					new Point(getWidth() / 2, getHeight() / 2),
					radius, new float[] { 0.2f, 1f }, new Color[] {
							Color.WHITE, ICE_BLUE });
			g2d.setPaint(rgp);
			g2d.fill(new Arc2D.Float(x, y, radius, radius, 0, 360,
					Arc2D.PIE));
			g2d.dispose();
		}

	}

}