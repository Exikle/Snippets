package com.exikle.java.interfaces;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

@SuppressWarnings("serial")
class CircleButton extends JButton {
	// private static final float arcwidth = 17.0f;
	// private static final float archeight = 16.0f;
	protected static final int focusstroke = 2;
	protected final Color ICE_BLUE = new Color(122, 189, 255);
	protected final Color FOCUS_COLOR = Color.GREEN;// color when focused
	protected final Color ACTION_COLOR = Color.WHITE;// color bg turns on click
	protected final Color ROLLOVER_COLOR = Color.RED;// rollover color
	protected final Color BG_COLOR = new Color(250, 250, 250);// rollover color
	protected final GradientPaint BORDER_GRADIENT = new GradientPaint(0, 0,
			Color.LIGHT_GRAY, 80, 85, ICE_BLUE, false);

	protected Shape shape;
	protected Shape border;
	protected Shape base;

	public CircleButton(String text) {
		this(text, null);
	}

	public CircleButton(String text, Icon icon) {
		setModel(new DefaultButtonModel());
		init(text, icon);
		setContentAreaFilled(false);
		setBackground(BG_COLOR);
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
			shape = new Arc2D.Double(0, 0, getWidth() - 1, getWidth() - 1, 0,
					360, Arc2D.OPEN);// the actual shape
			border = new Arc2D.Double(focusstroke, focusstroke, getWidth() - 1
					- focusstroke * 2, getHeight() - 1 - focusstroke * 2, 0,
					360, Arc2D.OPEN);// the border for where the FocusColor
										// shows and the rollover
		}
	}

	/*
	 * Paints the Border
	 */
	private void paintFocusAndRollover(Graphics2D g2, Color color) {
		g2.setPaint(BORDER_GRADIENT);
		g2.fill(shape);
		g2.setColor(getBackground());
		g2.fill(border);
	}

	@Override
	protected void paintComponent(Graphics g) {
		initShape();
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		if (getModel().isArmed()) {
			g2.setColor(ACTION_COLOR);
			g2.fill(shape);
		} else if (isRolloverEnabled() && getModel().isRollover()) {
			paintFocusAndRollover(g2, ROLLOVER_COLOR);
		} else if (hasFocus()) {
			paintFocusAndRollover(g2, FOCUS_COLOR);
		} else {
			g2.setColor(getBackground());
			g2.fill(shape);
		}
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_OFF);
		g2.setColor(getBackground());
		super.paintComponent(g2);
	}

	@Override
	protected void paintBorder(Graphics g) {
		initShape();
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(getForeground());
		g2.draw(shape);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_OFF);
	}

//	@Override
//	public boolean contains(int x, int y) {
//		initShape();
//		return shape.contains(x, y);
//	}
}