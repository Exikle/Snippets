package com.exikle.java;

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

// Inherit the applet class from the class Applet
@SuppressWarnings("serial")
public class MazeFinal extends Applet implements Runnable {

	private Image dbImage;

	private Graphics dbg;

	// Now you should implement the following methods
	// init - method is called the first time you enter the HTML site with the applet
	public void init() {}

	// start - method is called every time you enter the HTML - site with the applet
	public void start() {
		// define a new thread
		Thread th = new Thread(this);
		// start this thread
		th.start();
	}

	// stop - method is called if you leave the site with the applet
	public void stop() {}

	// destroy method is called if you leave the page finally (e. g. closing browser)
	public void destroy() {}

	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while (true) {
			repaint();

			try {
				Thread.sleep(10);
			} catch (InterruptedException ex) {
			}
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
	}

	public boolean mouseDrag(Event e, int x, int y) {
		return true;
	}

	public boolean keyDown(Event e, int key) {
		if (key == Event.UP) {
		}

		return true;
	}

	public void update(Graphics g) {
		if (dbImage == null) {
			dbImage = createImage(200, 200);
			dbg = dbImage.getGraphics();
		}
		dbg.setColor(getBackground());
		dbg.fillRect(0, 0, 200, 200);

		dbg.setColor(getForeground());
		paint(dbg);

		g.drawImage(dbImage, 0, 0, this);
	}

	public void paint(Graphics g) {

	}
}