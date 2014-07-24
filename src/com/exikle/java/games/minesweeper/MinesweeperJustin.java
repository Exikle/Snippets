package com.exikle.java.games.minesweeper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MinesweeperJustin extends JFrame implements
		ActionListener {

	JButton[] buttons = new JButton[100];

	JPanel panel1 = new JPanel(), panel2 = new JPanel(),
			panel3 = new JPanel();

	int[] mine = new int[10];

	int[] board = new int[100];

	JLabel label1 = new JLabel("Minesweeper"),
			label2 = new JLabel("");

	JButton reset = new JButton("Reset");

	int buttonclick = 0;

	Font f1 = new Font("Ariel", Font.BOLD, 40);

	Font f2 = new Font("Ariel", Font.BOLD, 40);

	Font f3 = new Font("Courier", Font.BOLD, 40);

	public static void main(String[] args) {
		new MinesweeperJustin();
	}

	public MinesweeperJustin() {
		reset.addActionListener(this);

		label1.setFont(f1);
		reset.setFont(f2);
		label2.setFont(f3);

		for (int x = 0; x < 100; x++) {
			buttons[x] = new JButton("");
			buttons[x].addActionListener(this);
			panel1.add(buttons[x]);
		}

		for (int j = 0; j < 10; j++) {
			mine[j] = (int) (Math.random() * 100);
			while (board[mine[j]] != 99)
				board[mine[j]] = 99;
		}

		for (int a = 0; a < 100; a++) {
			buttons[a].setEnabled(true);
			// buttons[a].setText("");
			buttons[a].setBackground(Color.WHITE);

			// Show bombs for board
			// if (board[a] == 99) {
			// buttons[a].setText("" + board[a]);
			// }
		}
		// Check for location of bombs
		for (int x = 0; x < 100; x++) {
			if (board[x] >= 99) {
				if (x != 9 && x != 19 && x != 29 && x != 39
						&& x != 49 && x != 59 && x != 69 && x != 79
						&& x != 89 && x != 99) {
					board[x + 1] = board[x + 1] + 1;
				}

				if (x != 0 && x != 10 && x != 20 && x != 30
						&& x != 40 && x != 50 && x != 60 && x != 70
						&& x != 80 && x != 90) {
					board[x - 1] = board[x - 1] + 1;
				}

				if (x != 0 && x != 1 && x != 2 && x != 3 && x != 4
						&& x != 5 && x != 6 && x != 7 && x != 8
						&& x != 9) {
					board[x - 10] = board[x - 10] + 1;
				}

				if (x != 90 && x != 91 && x != 92 && x != 93
						&& x != 94 && x != 95 && x != 96 && x != 97
						&& x != 98 && x != 99) {
					board[x + 10] = board[x + 10] + 1;
				}

				if (x != 9 && x != 19 && x != 29 && x != 39
						&& x != 49 && x != 59 && x != 69 && x != 79
						&& x != 89 && x != 99 && x != 0 && x != 1
						&& x != 2 && x != 3 && x != 4 && x != 5
						&& x != 6 && x != 7 && x != 8 && x != 9) {
					board[x - 9] = board[x - 9] + 1;
				}

				if (x != 0 && x != 1 && x != 2 && x != 3 && x != 4
						&& x != 5 && x != 6 && x != 7 && x != 8
						&& x != 9 && x != 0 && x != 10 && x != 20
						&& x != 30 && x != 40 && x != 50 && x != 60
						&& x != 70 && x != 80 && x != 90) {
					board[x - 11] = board[x - 11] + 1;
				}

				if (x != 0 && x != 10 && x != 20 && x != 30
						&& x != 40 && x != 50 && x != 60 && x != 70
						&& x != 80 && x != 90 && x != 90 && x != 91
						&& x != 92 && x != 93 && x != 94 && x != 95
						&& x != 96 && x != 97 && x != 98 && x != 99) {
					board[x + 9] = board[x + 9] + 1;
				}

				if (x != 9 && x != 19 && x != 29 && x != 39
						&& x != 49 && x != 59 && x != 69 && x != 79
						&& x != 89 && x != 99 && x != 90 && x != 91
						&& x != 92 && x != 93 && x != 94 && x != 95
						&& x != 96 && x != 97 && x != 98 && x != 99) {
					board[x + 11] = board[x + 11] + 1;
				}
			}
		}

		panel1.setLayout(new GridLayout(10, 10));
		panel2.setLayout(new GridLayout(1, 1));
		panel3.setLayout(new GridLayout(1, 1));
		panel2.add(label1);
		panel3.add(reset);
		panel3.add(label2);
		reset.setForeground(Color.BLUE);
		panel1.setBackground(Color.PINK);
		panel2.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		this.add(panel1, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.NORTH);
		this.add(panel3, BorderLayout.SOUTH);
		label2.setBackground(Color.GREEN);

		this.setSize(600, 600);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		// Button clicks for board

		for (int a = 0; a < 100; a++) {
			buttons[a].setEnabled(true);
			if (board[a] == 99)
				buttons[a].setText("" + board[a]);
		}

		for (int x = 0; x < 100; x++) {
			if (e.getSource() == buttons[x]) {// Show bombs on Board
				buttons[x].setText("" + board[x]);
				buttons[x].setBackground(Color.BLACK);
				// Losing Code
				if (board[x] >= 99) {
					buttons[x].setText("B");
					buttons[x].setBackground(Color.RED);
					for (int q = 0; q < 100; q++)
						buttons[q].setEnabled(false);
					label2.setText("You Lost!");
				}

				if (board[x] == 1) {
					buttons[x].setForeground(Color.BLUE);
				}
				if (board[x] == 2) {
					buttons[x].setForeground(Color.GREEN);
				}
				if (board[x] == 3) {
					buttons[x].setForeground(Color.YELLOW);
				}
				if (board[x] == 4) {
					buttons[x].setForeground(Color.ORANGE);
				}
				if (board[x] == 5) {
					buttons[x].setForeground(Color.RED);
				}
			}
		}

		// Reset Button
		if (e.getSource() == reset) {
			for (int u = 0; u < 100; u++) {
				board[u] = 0;
			}
			{
				for (int y = 0; y < 100; y++)
				// Reset Buttons
				{
					buttons[y].setEnabled(true);
					buttons[y].setText("");
					buttons[y].setBackground(Color.WHITE);
				}

				for (int j = 0; j < 10; j++) {
					mine[j] = (int) (Math.random() * 100);
					while (board[mine[j]] != 99)
						board[mine[j]] = 99;

				}

				for (int a = 0; a < 100; a++) {
					buttons[a].setEnabled(true);
					// buttons[a].setText("");
					buttons[a].setBackground(Color.WHITE);
					buttons[a].setForeground(Color.BLACK);

					if (board[a] == 99) {
						buttons[a].setText("" + board[a]);
					}
				}

				// Check for location of bombs
				for (int x = 0; x < 100; x++) {
					if (board[x] >= 99) {
						if (x != 9 && x != 19 && x != 29 && x != 39
								&& x != 49 && x != 59 && x != 69
								&& x != 79 && x != 89 && x != 99) {
							board[x + 1] = board[x + 1] + 1;
						}

						if (x != 0 && x != 10 && x != 20 && x != 30
								&& x != 40 && x != 50 && x != 60
								&& x != 70 && x != 80 && x != 90) {
							board[x - 1] = board[x - 1] + 1;
						}

						if (x != 0 && x != 1 && x != 2 && x != 3
								&& x != 4 && x != 5 && x != 6
								&& x != 7 && x != 8 && x != 9) {
							board[x - 10] = board[x - 10] + 1;
						}

						if (x != 90 && x != 91 && x != 92 && x != 93
								&& x != 94 && x != 95 && x != 96
								&& x != 97 && x != 98 && x != 99) {
							board[x + 10] = board[x + 10] + 1;
						}

						if (x != 9 && x != 19 && x != 29 && x != 39
								&& x != 49 && x != 59 && x != 69
								&& x != 79 && x != 89 && x != 99
								&& x != 0 && x != 1 && x != 2
								&& x != 3 && x != 4 && x != 5
								&& x != 6 && x != 7 && x != 8
								&& x != 9) {
							board[x - 9] = board[x - 9] + 1;
						}

						if (x != 0 && x != 1 && x != 2 && x != 3
								&& x != 4 && x != 5 && x != 6
								&& x != 7 && x != 8 && x != 9
								&& x != 0 && x != 10 && x != 20
								&& x != 30 && x != 40 && x != 50
								&& x != 60 && x != 70 && x != 80
								&& x != 90) {
							board[x - 11] = board[x - 11] + 1;
						}

						if (x != 0 && x != 10 && x != 20 && x != 30
								&& x != 40 && x != 50 && x != 60
								&& x != 70 && x != 80 && x != 90
								&& x != 90 && x != 91 && x != 92
								&& x != 93 && x != 94 && x != 95
								&& x != 96 && x != 97 && x != 98
								&& x != 99) {
							board[x + 9] = board[x + 9] + 1;
						}

						if (x != 9 && x != 19 && x != 29 && x != 39
								&& x != 49 && x != 59 && x != 69
								&& x != 79 && x != 89 && x != 99
								&& x != 90 && x != 91 && x != 92
								&& x != 93 && x != 94 && x != 95
								&& x != 96 && x != 97 && x != 98
								&& x != 99) {
							board[x + 11] = board[x + 11] + 1;
						}
						label2.setText("");
					}
				}
			}
		}
	}
}