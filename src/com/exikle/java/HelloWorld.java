package com.exikle.java;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorld extends JFrame {
	public HelloWorld() {
		this.setSize(100, 100);
		this.setVisible(true);
		this.add(new JLabel("Hello World"));
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new HelloWorld();
	}

}
