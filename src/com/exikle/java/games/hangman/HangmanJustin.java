package com.exikle.java.games.hangman;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

// Starter Template
@SuppressWarnings("serial")
public class HangmanJustin extends JFrame implements ActionListener {

	// Declaration area

	JPanel panel1, panel2, panel3, panel4, panel5;

	JButton animalbutton, countriesbutton, fruitbutton, citybutton,
			newgame;

	JLabel title, label1, label2;

	String letters = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	int rnd = 0, length;

	JButton[] letterbutton;

	MyDrawPanel drawpanel1 = new MyDrawPanel();

	Border brdr1, brdr2;

	String[] puzzle, hangmanword = new String[14];

	String[] puzzle2, country = new String[14];

	JLabel[] underscore = new JLabel[15];

	int hangmancount = 6, wincounter = 0;

	// int flag=0;
	char[] puzzled, hidden;        // puzzled is the actual word that will appear to the user and hidden is the word but user cannot see

	int checker, categorycount = 0;

	File f;

	String cate;

	Color customcolor = Color.getHSBColor(155, 255, 255);

	public static void main(String[] args) {
		new HangmanJustin();
	}

	public HangmanJustin() {
		brdr1 = new CompoundBorder(LineBorder.createGrayLineBorder(),
				BorderFactory.createLineBorder(Color.white));
		brdr2 = new CompoundBorder(brdr1,
				BorderFactory.createLoweredBevelBorder());

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		label1 = new JLabel("");
		label2 = new JLabel("");
		label2.setBorder(brdr1);
		label1.setBorder(brdr1);
		newgame = new JButton("New game");
		newgame.addActionListener(this);

		animalbutton = new JButton("Animals");
		animalbutton.addActionListener(this);
		animalbutton.setEnabled(false);

		fruitbutton = new JButton("Fruits");
		fruitbutton.addActionListener(this);
		fruitbutton.setEnabled(false);

		countriesbutton = new JButton("Countries");
		countriesbutton.addActionListener(this);
		countriesbutton.setEnabled(false);

		citybutton = new JButton("Cities");
		citybutton.addActionListener(this);
		citybutton.setEnabled(false);

		title = new JLabel("Hangman");
		Font f1 = new Font("Ariel", Font.BOLD, 40);
		Font f2 = new Font("SERIF", Font.BOLD, 40);
		title.setFont(f1);
		label2.setFont(f2);
		letterbutton = new JButton[26];

		this.add(drawpanel1);
		panel4.add(label2);
		panel1.setBackground(customcolor);
		panel2.setBackground(customcolor);
		panel4.setBackground(customcolor);
		drawpanel1.setBackground(Color.BLUE);
		this.setLayout(new BorderLayout());
		this.add(panel1, BorderLayout.NORTH);
		panel1.add(title);
		this.add(panel2, BorderLayout.SOUTH);
		panel3.add(drawpanel1);
		this.add(drawpanel1, BorderLayout.CENTER);
		this.add(panel4, BorderLayout.EAST);
		panel4.setLayout(new GridLayout(4, 1));
		panel4.add(label1);
		panel4.add(newgame);
		panel4.add(animalbutton);
		panel4.add(countriesbutton);
		panel4.add(fruitbutton);
		panel4.add(citybutton);
		panel4.add(panel5);

		panel2.setLayout(new GridLayout(2, 13));

		// Make 26 buttons with alphabet on them
		for (int x = 0; x < 26; x++) {
			letterbutton[x] = new JButton("");
			letterbutton[x].setText("" + letters.charAt(x + 1));
			letterbutton[x].addActionListener(this);
			letterbutton[x].setEnabled(false);
			panel2.add(letterbutton[x]);
		}

		this.setSize(990, 600);
		this.setVisible(true);

	}

	class MyDrawPanel extends JPanel {

		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;

			g2.setColor(new Color(78, 255, 246));
			g2.fillRect(0, 0, 1200, 500);

			// Grid
			// for(int x=0;x<=800;x+=25)
			// {
			// g2.drawLine(x,0,x,500);
			// g2.drawString(""+x,x,20);
			// }
			//
			// for(int y=0;y<=500;y+=25)
			// {
			// g2.drawLine(0,y,800,y);
			// g2.drawString(""+y,0,y+20);
			// }
			// Hangman Stand
			g2.setColor(new Color(255, 0, 255));
			g2.fillRect(25, 25, 50, 400);

			g2.setColor(new Color(255, 0, 255));
			g2.fillRect(25, 425, 200, 25);

			g2.setColor(new Color(255, 0, 255));
			g2.fillRect(50, 50, 150, 25);

			g2.setStroke(new BasicStroke(10));
			g2.setColor(new Color(255, 0, 255));
			g2.drawLine(175, 75, 175, 100);

			if (hangmancount >= 1) {
				g2.setColor(new Color(250, 50, 50));
				g2.fillOval(150, 100, 50, 50);
			}

			if (hangmancount >= 2) {
				g2.setColor(new Color(250, 50, 50));
				g2.fillRoundRect(160, 140, 25, 125, 25, 25);
			}
			if (hangmancount >= 3) {
				g2.setStroke(new BasicStroke(20));
				g2.setColor(new Color(250, 50, 50));
				g2.drawLine(250, 150, 175, 175);
			}
			if (hangmancount >= 4) {
				g2.setStroke(new BasicStroke(20));
				g2.setColor(new Color(250, 50, 50));
				g2.drawLine(100, 150, 175, 175);
			}
			if (hangmancount >= 5) {
				g2.setStroke(new BasicStroke(20));
				g2.setColor(new Color(250, 50, 50));
				g2.drawLine(160, 260, 100, 325);
			}
			if (hangmancount >= 6) {
				g2.setStroke(new BasicStroke(20));
				g2.setColor(new Color(250, 50, 50));
				g2.drawLine(175, 260, 225, 325);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {

		// Buttons
		for (int x = 0; x < 26; x++) {
			if (e.getSource() == letterbutton[x]) {
				String letClicked = letterbutton[x].getText();

				System.out.println("" + letterbutton[x].getText());

				// Letter Button Click for Alphabet when Puzzle is active
				for (int y = 0; y < length; y++) {

					if (!letClicked.equalsIgnoreCase("" + puzzled[y])) {
						System.out.println("Wrong button!");
						repaint();
					}

					else if (letClicked.equalsIgnoreCase(""
							+ puzzled[y])) {
						hidden[y] = letClicked.charAt(0);
						System.out.println("Right button!");
						wincounter++;
						checker = 1;
						if (wincounter == length)  // Checks if the right button pressed matches the length of the chosen word
						{
							label2.setText("You Win!");
							for (int z = 0; z < 26; z++) {
								letterbutton[z].setEnabled(false);
							}
						}
						underscore[y].setText(letClicked); // Sets underscores to the button pressed if right
					}

				}
				letterbutton[x].setEnabled(false);

			}

		}

		if (checker == 0) {
			hangmancount = hangmancount + 1;
		}
		checker = 0;

		// if (letClicked.equalsIgnoreCase(puzzled[x].getText())){
		// flag=1;
		// }
		// if (flag==0){
		// wrong++;
		// repaint();
		// }
		//

		// New game Button

		if (e.getSource() == newgame) {
			// String word = hangmanword[rnd];
			label1.setText("Hello, lets play hangman! Choose a category!");
			animalbutton.setEnabled(true);
			countriesbutton.setEnabled(true);
			fruitbutton.setEnabled(true);
			citybutton.setEnabled(true);
			label2.setText("");
			System.out.println("the newgame button was pressed");
			hangmancount = 0;
			repaint();
			for (int x = 0; x < 15; x++) {

			}

		}

		// ANIMAL BUTTON
		if (e.getSource() == animalbutton) {
			cate = "animal";
			dataIn();
			rnd = (int) (Math.random() * 14); // Shows random picked word from data file

			for (int z = 0; z < 26; z++) {
				letterbutton[z].setEnabled(true);
			}

			System.out.println(hangmanword[rnd]); // Shows random picked animal word from data file
			String word = hangmanword[rnd];
			int length2 = hangmanword[rnd].length();
			length2 = hangmanword[rnd].length();
			puzzled = new char[length2];// stores current puzzled
			hidden = new char[length2];// underscored hidden word
			length = length2; // length2 is the length of any animal words

			panel5.setLayout(new GridLayout(1, length));

			countriesbutton.setEnabled(false);
			fruitbutton.setEnabled(false);
			animalbutton.setEnabled(false);
			citybutton.setEnabled(false);
			underscore = new JLabel[length2];
			// Length for Puzzle and Hidden word
			for (int x = 0; x < length2; x++) {
				puzzled[x] = word.charAt(x);
				hidden[x] = '_';
				underscore[x] = new JLabel(hidden[x] + " ");
				panel5.add(underscore[x]);
			}

		}
		// Countries Button
		if (e.getSource() == countriesbutton) {
			cate = "country";
			dataIn();
			rnd = (int) (Math.random() * 14); // Shows random picked word from data file

			for (int x = 0; x < 26; x++) {
				letterbutton[x].setEnabled(true);
			}

			System.out.println(hangmanword[rnd]); // Shows random picked animal word from data file
			String word = hangmanword[rnd];
			int length2 = hangmanword[rnd].length();
			length2 = hangmanword[rnd].length();
			puzzled = new char[length2];// stores current puzzled
			hidden = new char[length2];// underscored hidden word
			length = length2; // length2 is the length of any animal words

			panel5.setLayout(new GridLayout(1, length));

			countriesbutton.setEnabled(false);
			fruitbutton.setEnabled(false);
			animalbutton.setEnabled(false);
			citybutton.setEnabled(false);
			underscore = new JLabel[length2];
			// Length for Puzzle and Hidden word
			for (int x = 0; x < length2; x++) {
				puzzled[x] = word.charAt(x);
				hidden[x] = '_';
				underscore[x] = new JLabel(hidden[x] + " ");
				panel5.add(underscore[x]);
			}
		}

		// City Button

		if (e.getSource() == citybutton) {
			cate = "Cities";
			dataIn();
			rnd = (int) (Math.random() * 14); // Randomizes the words in the data file of city

			for (int x = 0; x < 26; x++) {
				letterbutton[x].setEnabled(true);
			}

			System.out.println(hangmanword[rnd]); // Shows random picked word from data file
			String word = hangmanword[rnd];
			int length2 = hangmanword[rnd].length();
			length2 = hangmanword[rnd].length();
			puzzled = new char[length2];// stores current puzzled
			hidden = new char[length2];// underscored hidden word
			length = length2; // length2 is the length of any animal words

			panel5.setLayout(new GridLayout(1, length));

			countriesbutton.setEnabled(false);
			fruitbutton.setEnabled(false);
			animalbutton.setEnabled(false);
			citybutton.setEnabled(false);
			underscore = new JLabel[length2];
			// Length for Puzzle and Hidden word
			for (int x = 0; x < length2; x++) {
				puzzled[x] = word.charAt(x);
				hidden[x] = '_';
				underscore[x] = new JLabel(hidden[x] + " ");
				panel5.add(underscore[x]);
			}
		}

		if (e.getSource() == fruitbutton) {
			cate = "Fruit";
			dataIn();
			rnd = (int) (Math.random() * 14); // Shows random picked word from data file

			for (int z = 0; z < 26; z++) {
				letterbutton[z].setEnabled(true);
			}

			System.out.println(hangmanword[rnd]); // Shows random picked word from data file
			String word = hangmanword[rnd];
			int length2 = hangmanword[rnd].length();
			length2 = hangmanword[rnd].length();
			puzzled = new char[length2];// stores current puzzled
			hidden = new char[length2];// underscored hidden word
			length = length2; // length2 is the length of any animal words

			panel5.setLayout(new GridLayout(1, length));

			countriesbutton.setEnabled(false);
			fruitbutton.setEnabled(false);
			animalbutton.setEnabled(false);
			citybutton.setEnabled(false);
			underscore = new JLabel[length2];
			// Length for Puzzle and Hidden word
			for (int x = 0; x < length2; x++) {
				puzzled[x] = word.charAt(x);
				hidden[x] = '_';
				underscore[x] = new JLabel(hidden[x] + " ");
				panel5.add(underscore[x]);

			}

		}

		if (hangmancount == 6) {
			for (int x = 0; x < 26; x++) {
				letterbutton[x].setEnabled(false);
			}

			label1.setText("YOU LOST!");
		}

	}

	public void dataIn() {
		int count = 0;

		BufferedReader in = null; // variable representing the bufferedreader
		String line = "A B 1"; // variable to read each line from the data file
		f = new File(cate + ".txt"); // variable representing the data file

		// Open the data file
		try {
			in = new BufferedReader(new FileReader(f));
			System.out.println("File Opening");
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening File");
		}

		// Read each line and split to appropriate field variables
		while (line != null) {
			try {
				line = in.readLine();
				if (line != null) {
					hangmanword[count] = line;
					System.out.println(hangmanword[count]);
					count++;
				}

			} catch (IOException e) {
				System.out.println("Problem reading data from file");
			}
			if (line != null) {
				// System.out.println(animals);
			}
		}
		// Close the data file
		try {
			in.close();
			System.out.println("Closing File");
		}

		catch (IOException e) {
			System.out.println("Problem Closing " + e);
		}
	}

}
// if (guessletter.equals(letters[x].getText()){
// flag=1;
// }
// if (flag==0){
// wrong++;
// repaint();
// }