package com.exikle.java.datainteraction;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class DataInOutGUI extends JFrame implements ActionListener {

	// Declaration Area
	Border brdr1, brdr2;

	JPanel pnl1, pnl2;

	JTextArea text;

	JScrollPane scrl;

	JButton btn1, btn2;

	int g;

	public static void main(String[] args) {
		new DataInOutGUI();
	}

	public DataInOutGUI() {
		brdr1 = new CompoundBorder(LineBorder.createGrayLineBorder(),
				BorderFactory.createLineBorder(Color.white));
		brdr2 = new CompoundBorder(brdr1,
				BorderFactory.createLoweredBevelBorder());

		pnl1 = new JPanel();
		pnl2 = new JPanel();
		text = new JTextArea(10, 30);
		scrl = new JScrollPane(text);

		btn1 = new JButton("Read");
		btn1.addActionListener(this);
		btn2 = new JButton("Save");
		btn2.addActionListener(this);

		// pnl1.add(scrl);
		pnl2.add(btn1);
		pnl2.add(btn2);

		pnl2.setLayout(new GridLayout(1, 2));

		this.setLayout(new BorderLayout());
		this.add(pnl1, BorderLayout.NORTH);
		this.add(pnl2, BorderLayout.SOUTH);

		this.setSize(400, 220);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent h) {
		if (h.getSource() == btn1) {
			String[] fields; // array to store the "split" line read
			String fname = "", lname = ""; // individual field variables
			int jersey = 0; // individual field variable

			BufferedReader in = null; // variable representing the bufferedreader
			String line = "A B 1"; // variable to read each line from the data file
			File f = new File("DataFile1.txt"); // variable reprsenting the data file

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
						fields = line.split(" ");
						fname = fields[0];
						lname = fields[1];
						jersey = Integer.parseInt(fields[2]);
					}
				} catch (IOException e) {
					System.out
							.println("Problem reading data from file");
				}

				if (line != null) {
					System.out.println(line);
					// System.out.println(fname);
					// System.out.println(lname);
					// System.out.println(""+jersey);

					text.setText(text.getText() + "\n" + fname + " "
							+ lname + " " + jersey);
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

	// private class RightClicker extends MouseAdapter {
	// public void mousePressed( MouseEvent e ) {
	// if ( e.isMetaDown() ) {
	//
	// }
	// }
	// }

}
