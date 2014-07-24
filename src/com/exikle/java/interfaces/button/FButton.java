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
import javax.swing.Icon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class FButton extends JButton implements Runnable {

	protected Shape insideShape;

	protected Shape insideBorder;

	protected Shape base;

	int angleForward = 0;

	int angleBackward = 90;

	final BasicStroke BS1 = new BasicStroke(12.5f);

	final BasicStroke BS2 = new BasicStroke(8.0f);

	final BasicStroke BS3 = new BasicStroke(1.5f);

	final BasicStroke BS4 = new BasicStroke(9.5f);

	protected final Color ICE_BLUE = new Color(122, 189, 255);

	protected final Color FOCUS_COLOR = Color.GREEN;// color when focused

	protected final Color ACTION_COLOR = Color.WHITE;// color bg turns on click

	protected final Color ROLLOVER_COLOR = Color.RED;// rollover color

	protected final Color BG_COLOR = new Color(250, 250, 250);// rollover color

	// protected final Color ICE_BLUE = new Color(122, 189, 255);
	protected final GradientPaint BORDER_GRADIENT = new GradientPaint(
			0, 0, Color.LIGHT_GRAY, 80, 85, ICE_BLUE, false);

	GradientPaint gp1 = new GradientPaint(0, 0, Color.LIGHT_GRAY, 80,
			85, ICE_BLUE, false);

	int radius = Math.min(getWidth(), getHeight()) + 1;

	RadialGradientPaint rgp1 = new RadialGradientPaint(new Point(
			getWidth() / 2, getWidth() / 2), getWidth() + 1,
			new float[] { 0.1f, .55f }, new Color[] { Color.GRAY,
					ICE_BLUE });

	protected static final int focusstroke = 2;

	public FButton(String text) {
		this(text, null);
	}

	public FButton(String text, Icon icon) {
		setModel(new DefaultButtonModel());
		init(text, icon);
		EventQueue.invokeLater(this);
		setContentAreaFilled(false);
		setBackground(Color.WHITE);
		setOpaque(false);
		initShape();
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension d = super.getPreferredSize();
		d.width = d.height = Math.max(d.width, d.height);
		return d;
	}

	protected void initShape() {
		if (!getBounds().equals(base)) {
			base = getBounds();
			insideShape = new Arc2D.Double(0, 0, getWidth() - 1,
					getWidth() - 1, 0, 360, Arc2D.OPEN);// the actual shape
			insideBorder = new Arc2D.Double(focusstroke, focusstroke,
					getWidth() - 1 - focusstroke * 2, getHeight() - 1
							- focusstroke * 2, 0, 360, Arc2D.OPEN);
		}
	}

	/*
	 * Paints the Border on focus & rollover
	 */
	private void paintFocusAndRollover(Graphics2D g2, Color color) {
		g2.setPaint(color);
		g2.fill(insideShape);
		g2.setColor(getBackground());
		g2.setPaint(rgp1);
		g2.fill(insideBorder);
		g2.setStroke(new BasicStroke(1.5f));
	}

	/*
	 * Paints the actual shape
	 */
	@Override
	protected void paintComponent(Graphics g) {
		initShape();
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		// g2.fillRect(0, 0, getWidth(), getWidth());

		if (getModel().isArmed()) {
			g2.setColor(ACTION_COLOR);
			g2.fill(insideShape);
		} else if (isRolloverEnabled() && getModel().isRollover()) {
			paintFocusAndRollover(g2, ROLLOVER_COLOR);
		} else if (hasFocus()) {
			paintFocusAndRollover(g2, FOCUS_COLOR);
		} else {
			g2.setColor(getBackground());
			g2.fill(insideBorder);
		}
		g2.setColor(getBackground());

		super.paintComponent(g2);
	}

	/*
	 * Paints the border
	 */
	@Override
	protected void paintBorder(Graphics g) {
		initShape();
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setStroke(BS2);
		g2.setColor(ICE_BLUE);
		g2.draw(new Arc2D.Double(5, 3, getWidth() - 10,
				getWidth() - 10, angleForward, 90, Arc2D.OPEN));
		g2.setStroke(BS3);
		g2.setColor(Color.GRAY);
		g2.draw(new Arc2D.Double(5, 3, getWidth() - 10,
				getWidth() - 10, angleForward, 90, Arc2D.OPEN));

		g2.setStroke(BS1);
		g2.setColor(Color.GRAY);
		g2.draw(new Arc2D.Double(5, 5, getWidth() - 10,
				getWidth() - 10, angleBackward, 90, Arc2D.OPEN));
		g2.setStroke(BS3);
		g2.setColor(ICE_BLUE);
		g2.draw(new Arc2D.Double(5, 5, getWidth() - 10,
				getWidth() - 10, angleBackward, 90, Arc2D.OPEN));

		g2.setStroke(new BasicStroke(1.5f));
	}

	@Override
	public void run() {
		int delay = 0, period = 50;
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				angleForward += 10;
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