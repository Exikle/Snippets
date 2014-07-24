package com.exikle.java.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUICards extends JFrame {

	MyDrawPanel drawpanel1;

	ClassLoader cl = GUICards.class.getClassLoader();

	URL imageURL = cl.getResource("cards.png");

	Image image;

	int[][] cardspicked;

	int[][] deck;

	int c = 0, s = 0;

	public static void main(String[] args) {
		new GUICards();
	}

	public GUICards() {

		if (imageURL != null) {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			image = toolkit.createImage(imageURL);
		}

		drawpanel1 = new MyDrawPanel();

		cardspicked = new int[13][4];
		deck = new int[52][2];

		for (int z = 0; z < 52; z++) {
			do {
				c = (int) (Math.random() * 13);
				s = (int) (Math.random() * 4);
			} while (cardspicked[c][s] == 1);
			cardspicked[c][s] = 1;
			deck[z][0] = c * 79;
			deck[z][1] = s * 123;
		}

		this.add(drawpanel1);
		this.setSize(800, 800);
		this.setVisible(true);
	}

	class MyDrawPanel extends JPanel {

		public void paintComponent(Graphics g) {
			// Converts the ordinay graphics object into a Graphics2d object
			Graphics2D g2 = (Graphics2D) g;

			// g2.drawImage(image, 100, 50, this);

			// g2.drawImage(image, 100, 50, 600, 400, this);
			for (int z = 0; z < 5; z++)
				g2.drawImage(image, (100 + z * 100), 50,
						(180 + z * 100), 175, deck[z][0], deck[z][1],
						deck[z][0] + 79, deck[z][1] + 123, this);

			for (int z = 0; z < 5; z++)
				g2.drawImage(image, (100 + z * 100), 200,
						(180 + z * 100), 325, deck[z + 5][0],
						deck[z + 5][1], deck[z + 5][0] + 79,
						deck[z + 5][1] + 123, this);

		}
	}
}
