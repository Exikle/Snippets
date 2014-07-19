package com.exikle.java.interfaces.button;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultButtonModel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class FButtonOriginal extends JButton implements Runnable {
	int RADIUS = 100;
	final BasicStroke BS1 = new BasicStroke(5.5f);
	final BasicStroke BS2 = new BasicStroke(8.0f);
	final BasicStroke BS3 = new BasicStroke(1.5f);
	final BasicStroke BS4 = new BasicStroke(9.5f);
	final Color ICE_BLUE = new Color(122, 189, 255);
	GradientPaint gp1 = new GradientPaint(0, 0, Color.LIGHT_GRAY, 80, 85,
			ICE_BLUE, false);
	GradientPaint gp2 = new GradientPaint(0, 0, Color.LIGHT_GRAY, 80, 85,
			Color.GRAY, false);
	int angleForward = 0;
	int angleBackward = 90;
	String label = new String("");
	
	protected static final int focusstroke = 2;
	protected final Color fc = Color.GREEN;//color when focused
	protected final Color ac = Color.BLUE;//color bg turns on click
	protected final Color rc = Color.RED;//rollover color
	protected Shape shape;
	protected Shape border;
	protected Shape base;

	public FButtonOriginal(String text) {
		super(text);
		label = text;
		EventQueue.invokeLater(this);
		setModel(new DefaultButtonModel());
		setContentAreaFilled(false);
		setBackground(new Color(250, 250, 250));
		setOpaque(false);
		setBorderPainted(false);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(100, 100);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.fillRect(0, 0, getWidth(), getHeight());

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		int radius = Math.min(getWidth(), getHeight());
		int x = ((getWidth() - radius) / 2) + 5;
		int y = ((getHeight() - radius)) / 2 + 5;

		RadialGradientPaint rgp1 = new RadialGradientPaint(new Point(
				getWidth() / 2, getHeight() / 2), radius, new float[] { 0.1f,
				.55f }, new Color[] { new Color(0, 0, 0, .1f), ICE_BLUE });
		RadialGradientPaint rgp2 = new RadialGradientPaint(new Point(
				getWidth() / 2, getHeight() / 2), radius, new float[] { 0.1f,
				.55f }, new Color[] { new Color(0, 0, 0, .1f), Color.GRAY });

		new Color(0, 128, 0, 128);
        new Color(0, 128, 0, 0);        
		if (isRolloverEnabled() && getModel().isRollover()) {
			g2.setPaint(rgp1);
		} else {
			g2.setPaint(rgp2);
		}

		g2.fill(new Arc2D.Float(x, y, radius - 10, radius - 10, 0, 360,
				Arc2D.PIE));

		g2.setStroke(BS1);
		g2.setPaint(gp1);
		g2.draw(new Arc2D.Double(5, 5, getWidth() - 10, getWidth() - 10,
				angleForward, 90, Arc2D.OPEN));

//		// gray's BG
//		g2.setStroke(BS4);
//		g2.setPaint(gp1);
//		g2.draw(new Arc2D.Double(5, 5, getWidth() - 10, getWidth() - 10,
//				angleBackward, 90, Arc2D.OPEN));
//		g2.draw(new Arc2D.Double(6, 5, getWidth() - 10, getWidth() - 10,
//				angleBackward - 90, 20, Arc2D.OPEN));
//		g2.draw(new Arc2D.Double(5, 5, getWidth() - 10, getWidth() - 10,
//				angleBackward - 150, 30, Arc2D.OPEN));
//
//		// gray, still
//		g2.setStroke(BS2);
//		g2.setPaint(gp2);
//		g2.draw(new Arc2D.Double(6, 4, getWidth() - 10, getWidth() - 10,
//				angleBackward, 90, Arc2D.OPEN));
//		g2.draw(new Arc2D.Double(4, 6, getWidth() - 10, getWidth() - 10,
//				angleBackward - 90, 20, Arc2D.OPEN));
//		g2.draw(new Arc2D.Double(4, 6, getWidth() - 10, getWidth() - 10,
//				angleBackward - 150, 30, Arc2D.OPEN));

		// line on gray
//		g2.setStroke(BS3);
//		g2.setPaint(gp1);
//		g2.draw(new Arc2D.Double(7, 4, getWidth() - 10, getWidth() - 10,
//				angleBackward, 90, Arc2D.OPEN));

		// text
		g2.setPaint(Color.LIGHT_GRAY);
		g2.drawString(label, (getWidth() / 2) - 17, (getHeight() / 2) + 2);
	}

	@Override
	public void run() {
		int delay = 0, period = 50;
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				angleForward += 15;
				angleBackward -= 3;
				if (angleForward > 360)
					angleForward = 0;
				if (angleBackward > 360)
					angleBackward = 0;
				repaint();
			}
		}, delay, period);
	}
}