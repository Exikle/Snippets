package com.exikle.java.interfaces.frame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.exikle.java.interfaces.button.FButton;

@SuppressWarnings("serial")
public class FFrame extends JFrame {

	public FFrame() {
		final int WIDTH = 500;
		final int HEIGHT = 500;
		Dimension dimension = Toolkit.getDefaultToolkit()
				.getScreenSize();
		int x = (int) ((dimension.getWidth() - WIDTH) / 2);
		int y = (int) ((dimension.getHeight() - HEIGHT) / 2);

		setLocation(x, y);
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setLayout(null);
		setVisible(true);
		setResizable(true);
		// getContentPane().setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton fBtn = new FButton("Button");

		fBtn.setSize(100, 100);
		add(fBtn);

	}

	public static void main(String[] args) {
		new FFrame();
	}
}
