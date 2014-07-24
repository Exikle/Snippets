package com.exikle.java.games.hangman;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

// Starter Template
@SuppressWarnings("serial")
public class HangmanJake extends JFrame implements ActionListener {

	// Declaration area

	JPanel panel1, panel2, panel4, panel5, panel6, panel7;

	JLabel label1;

	String store = "";

	JButton[] keyboard;

	String[] alpha = { "a", "b", "c", "d", "e", "f", "g", "h", "i",
			"j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
			"u", "v", "w", "x", "y", "z" };

	JLabel[] under;

	String[] puz = new String[20];

	int rdm = 0;

	int wordlength = 0;

	String word = "", compare;

	mydrawpanel drawpanel1 = new mydrawpanel();

	int counter = 0;

	int flag = 1;

	JLabel category;

	JButton reset;

	Font f2 = new Font("Copperplate Gothic Bold", Font.BOLD, 20);

	Font f3 = new Font("Copperplate Gothic Bold", Font.BOLD, 30);

	public static void main(String[] args) {
		new HangmanJake();
	}

	public HangmanJake() {
		// dataIn();
		// rdm=(int)(Math.random()*20);
		// System.out.println(puz[rdm]);
		// word=(puz[rdm]);
		//
		// wordlength=word.length();

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();

		reset = new JButton("NEW GAME");
		// Font f1 = new Font("Copperplate Gothic Bold", Font.BOLD, 60);

		// label1=new JLabel ("TEST");
		drawpanel1.setLayout(null);
		reset.addActionListener(this);
		keyboard = new JButton[26];
		drawpanel1.setLayout(null);

		for (int x = 0; x < 26; x++) {
			keyboard[x] = new JButton("" + alpha[x]);
			keyboard[x].addActionListener(this);
			panel6.add(keyboard[x]);
			keyboard[x].setBackground(Color.YELLOW);
		}

		// under = new JLabel[wordlength];
		category = new JLabel("Sports");
		// for (int x=0;x<wordlength;x++)
		// {
		// under[x]=new JLabel("");
		// under[x].setText("_");
		// under[x].setFont(f1);
		// drawpanel1.add(under[x]);
		// under[x].setBounds(75+50*x,425,100+50*x,50);
		// }
		this.add(drawpanel1);
		this.setVisible(true);
		this.setSize(500, 500);
		this.add(category);
		// this.add(under);
		// this.add(label1);
		this.add(panel1);
		this.add(panel2);
		this.add(panel4);
		category.add(panel4);
		this.add(panel5);
		this.add(panel6);
		this.add(panel7);
		panel2.add(panel6);
		panel2.add(panel7);
		drawpanel1.add(reset);
		// panel7.add(label1);
		this.setLayout(new BorderLayout());
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.SOUTH);
		this.add(panel4, BorderLayout.EAST);
		this.add(drawpanel1, BorderLayout.CENTER);
		this.add(panel5, BorderLayout.WEST);

		panel2.setLayout(new GridLayout(3, 3));

		panel6.setLayout(new GridLayout(2, 13));
		panel7.setLayout(new GridLayout(1, 1));

		this.setSize(1225, 715);
		this.setVisible(true);

	}

	class mydrawpanel extends JPanel {

		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;

			// int[] x = { 400, 200, 600 };
			// int[] y = { 500, 275, 275 };

			g2.setColor(new Color(118, 67, 8));
			g2.fillRect(250, 100, 15, 325);// hangover pole

			g2.setFont(f3);
			g2.drawString(" Category - SPORTS ", 800, 50);
			reset.setBounds(800, 250, 150, 50);

			g2.setColor(new Color(118, 67, 8));
			g2.fillRect(265, 100, 200, 15);// pole
			g2.setColor(new Color(118, 67, 8));
			g2.fillRect(25, 425, 650, 75);// Base
			g2.setFont(f2);
			if (counter >= 1) {
				g2.setColor(new Color(212, 192, 135));
				g2.fillOval(400, 100, 100, 100);// head
				if (counter == 1)
					g2.drawString("5 Tries Left", 800, 100);
				g2.setFont(f2);
			}
			if (counter >= 2) {
				g2.fillRect(445, 200, 10, 125);// body
				g2.setColor(new Color(212, 192, 135));
				if (counter == 2)
					g2.drawString("4 Tries Left", 800, 120);
				g2.setFont(f2);
			}
			if (counter >= 3) {
				g2.fillRect(425, 325, 50, 10);// torsoe
				g2.setColor(new Color(212, 192, 135));
				if (counter == 3)
					g2.drawString("3 Tries Left", 800, 140);
				g2.setFont(f2);
			}
			if (counter >= 4) {
				g2.fillRect(425, 325, 10, 75);// left leg
				g2.setColor(new Color(212, 192, 135));
				if (counter == 4)
					g2.drawString("2 Tries Left", 800, 160);
				g2.setFont(f2);
			}
			if (counter >= 5) {
				g2.fillRect(465, 325, 10, 75);// right leg
				g2.setColor(new Color(212, 192, 135));
				if (counter == 5)
					g2.drawString("1 Try Left", 800, 180);
				g2.setFont(f2);
			}
			if (counter >= 6) {
				g2.fillRect(400, 250, 100, 10);// arms
				if (counter == 6)
					g2.drawString("You Lost, The Correct word was - "
							+ word, 800, 200);
				g2.setFont(f2);
				for (int a = 0; a < 26; a++) {

					keyboard[a].setEnabled(false);
					keyboard[a].setBackground(Color.RED);
				}
			}
		}

	}

	public void actionPerformed(ActionEvent e) {
		for (int a = 0; a < 26; a++) {
			if (e.getSource() == keyboard[a]) {
				keyboard[a].setEnabled(false);
				keyboard[a].setBackground(Color.RED);
				compare = alpha[a];
				flag = 1;
				for (int b = 0; b < wordlength; b++) {
					under[b] = new JLabel("_");
					if (compare.equals("" + word.charAt(b))) {
						under[b].setText("" + word.charAt(b));
						repaint();
						drawpanel1.add(under[b]);
						under[b].setBounds(50 + 70 * b, 425, 400, 75);
						Font f1 = new Font("Copperplate Gothic Bold",
								Font.BOLD, 55);
						under[b].setFont(f1);
						flag = 2;
					}
				}
				if (flag == 1) {
					counter += 1;
					repaint();
				}
				flag = 1;
			}
		}

		if (e.getSource() == reset) {
			counter = 0;
			dataIn();
			rdm = (int) (Math.random() * 20);
			System.out.println(puz[rdm]);
			word = (puz[rdm]);
			wordlength = word.length();
			under = new JLabel[wordlength];
			for (int a = 0; a < 26; a++) {
				keyboard[a].setEnabled(true);
			}

			for (int x = 0; x < 26; x++) {
				keyboard[x] = new JButton("" + alpha[x]);
				keyboard[x].addActionListener(this);
				panel6.add(keyboard[x]);
				keyboard[x].setEnabled(true);
				keyboard[x].setBackground(Color.YELLOW);
			}

			category = new JLabel("Sports");
			for (int x = 0; x < wordlength; x++) {
				under[x] = new JLabel("");
				under[x].setText("_");

				drawpanel1.add(under[x]);
				under[x].setBounds(75 + 50 * x, 425, 100 + 50 * x, 50);
			}
		}
	}

	public void dataIn() {
		// String[] fields; // array to store the "split" line read
		// String fname="",lname=""; // individual field variables
		// int jersey=0; // individual field variable

		BufferedReader in = null; // variable representing the bufferedreader
		String line = "A B 1"; // variable to read each line from the data file
		File k = new File("jake.txt"); // variable reprsenting the data file
		int count = 0;
		// Open the data file
		try {
			in = new BufferedReader(new FileReader(k));
			System.out.println("File Opening");
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening File");
		}

		// Read each line and split to appropriate field variables
		while (line != null) {
			try {
				line = in.readLine();
				if (line != null) {
					puz[count] = line;
					System.out.println(puz[count]);
					// fields=line.split("");
					// fname=fields[0];
					// lname=fields[1];
					// jersey=Integer.parseInt(fields[2]);
					count++;
				}
			} catch (IOException e) {
				System.out.println("Problem reading data from file");
			}

			if (line != null) {
				// System.out.println(line);
				// System.out.println(fname);
				// System.out.println(lname);
				// System.out.println(""+jersey);
			}
		}
		// Close the data file
		try {
			in.close();
			System.out.println("Closing File");
		} catch (IOException e) {
			System.out.println("Problem Closing " + e);
		}
	}
}