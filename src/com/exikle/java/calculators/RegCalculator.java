import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Container;
import javax.swing.*;
import java.text.DecimalFormat;

//Name: Mohammed Rahmati
//Student Number: 212912887
//Calculator made with java awt and swing libraries that allow decimal numbers and enables addition, multiplication, subtraction, and division.

public class RegCalculator implements ActionListener {
	// Java Animation Variables
	JFrame frame;
	JPanel bPanel;
	JPanel opButtons;
	JPanel textPanel;
	JTextArea calcView;
	JScrollPane scroll;

	// Important Calculator Variables
	String text;
	int operator;
	double firstNum;
	double secondNum;
	double answer;
	boolean firstHalfDone;
	String numberBuilder;
	DecimalFormat df = new DecimalFormat("#.##");

	// main method
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new RegCalculator();
			}
		});
	}

	public RegCalculator() {
		// initiating the main frame box
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250, 300);

		// op buttons
		opButtons = new JPanel();
		opButtons.setLayout(new GridLayout(1, 2));
		frame.add(opButtons, BorderLayout.NORTH);

		// Clear Last Button
		JButton clearLast = new JButton("Clear Last");
		clearLast.setActionCommand("Clear Last");
		clearLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (text.charAt(text.length() - 1) == '\n')
					text = text.substring(0, text.length() - 1);
				if ((text.charAt(text.length() - 1) == '+')
						|| (text.charAt(text.length() - 1) == '-')
						|| (text.charAt(text.length() - 1) == '*')
						|| (text.charAt(text.length() - 1) == '/')) {
					text = text.substring(0, text.length() - 1);
					firstHalfDone = false;
					numberBuilder = String.valueOf(df.format(firstNum));
					operator = 0;
				} else if (operator == 0 && numberBuilder.equals("")) {
					text += "\n";
					// do nothing after equals
				} else if (!numberBuilder.equals("")) {
					text = text.substring(0, text.length() - 1);
					numberBuilder = numberBuilder.substring(0,
							numberBuilder.length() - 1);
				} else {
					text = text.substring(0, text.length() - 1);
				}
				calcView.setText(text);
			}
		});
		opButtons.add(clearLast);

		// Clear All Button
		JButton clearAll = new JButton("Clear All");
		clearAll.setActionCommand("Clear All");
		clearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				text = "";
				operator = 0;
				firstNum = 0;
				secondNum = 0;
				answer = 0;
				firstHalfDone = false;
				numberBuilder = "";
				calcView.setText(text);
			}
		});
		opButtons.add(clearAll);

		// Text area
		textPanel = new JPanel();
		calcView = new JTextArea(7, 20);
		calcView.setEditable(false);
		scroll = new JScrollPane(calcView);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textPanel.add(scroll, BorderLayout.CENTER);
		frame.add(textPanel);

		// Setting up the Button Panel
		bPanel = new JPanel();
		bPanel.setLayout(new GridLayout(4, 4));
		frame.add(bPanel, BorderLayout.SOUTH);

		// Adding Numbers 7,8,9
		addButton(bPanel, String.valueOf(7));
		addButton(bPanel, String.valueOf(8));
		addButton(bPanel, String.valueOf(9));

		// Adding the Addition Button
		JButton additionButton = new JButton("+");
		additionButton.setActionCommand("+");
		additionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (!(numberBuilder == "")) {
					if (!firstHalfDone) {
						operator = 1;
						FirstHalf("+");
					} else if (firstHalfDone) { // && !(operator == 0)
						if (SecondHalf("+")) {
							operator = 1;
							text += "=\n";
							text += df.format(firstNum) + "+\n";
							calcView.setText(text);
						}
					}
				} else {
					// operator = 1;
					// numberBuilder = "0";
					// text += "0";
					// FirstHalf("+");
					SecondHalf("+");
				}
			}
		});
		bPanel.add(additionButton);

		// Adding Numbers 4,5,6
		addButton(bPanel, String.valueOf(4));
		addButton(bPanel, String.valueOf(5));
		addButton(bPanel, String.valueOf(6));

		// Adding the Subtraction Button
		JButton subtractionButton = new JButton("-");
		subtractionButton.setActionCommand("-");
		subtractionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (!(numberBuilder == "")) {
					if (!firstHalfDone) {
						operator = 2;
						FirstHalf("-");
					} else if (firstHalfDone) {
						if (SecondHalf("-")) {
							operator = 2;
							text += "=\n";
							text += df.format(firstNum) + "-\n";
							calcView.setText(text);
						}
					}
				} else {
					// operator = 2;
					// numberBuilder = "0";
					// text += "0";
					// FirstHalf("-");
					SecondHalf("-");
				}
			}
		});
		bPanel.add(subtractionButton);

		// Adding Buttons 1,2,3
		addButton(bPanel, String.valueOf(1));
		addButton(bPanel, String.valueOf(2));
		addButton(bPanel, String.valueOf(3));

		// Adding the Multiplication Button
		JButton multiplicationButton = new JButton("*");
		multiplicationButton.setActionCommand("*");
		multiplicationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (!(numberBuilder == "")) {
					if (!firstHalfDone) {
						operator = 3;
						FirstHalf("*");
					} else if (firstHalfDone) {
						if (SecondHalf("*")) {
							operator = 3;
							text += "=\n";
							text += df.format(firstNum) + "*\n";
							calcView.setText(text);
						}
					}
				} else {
					// operator = 3;
					// numberBuilder = "0";
					// text += "0";
					// FirstHalf("*");
					SecondHalf("*");
				}
			}
		});
		bPanel.add(multiplicationButton);

		// Adding the Decimal Point Button
		addButton(bPanel, String.valueOf(0));
		JButton decimalPointButton = new JButton(".");
		decimalPointButton.setActionCommand(".");
		bPanel.add(decimalPointButton);
		decimalPointButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (!numberBuilder.contains(".")) {
					numberBuilder += ".";
					text += ".";
					calcView.setText(text);
				} else {
					text += "\nError: You can't have multiple decimal points in a number!\n"
							+ numberBuilder;
					calcView.setText(text);
				}
			}
		});

		// Adding the Equals Button
		JButton equalsButton = new JButton("=");
		equalsButton.setActionCommand("=");
		equalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (numberBuilder.equals("") && firstHalfDone) { // if no number
																	// and
																	// operator
																	// has been
																	// entered,
																	// assume
																	// double
																	// operator
																	// (Error)
					text += "Error: You cannot have operator = displayed right now!\n";
					calcView.setText(text);
				} else if (numberBuilder.equals("")) {
					// do nothing
				} else {
					if (!(operator == 0))
						secondNum = Double.parseDouble(numberBuilder);
					else
						firstNum = Double.parseDouble(numberBuilder);
					numberBuilder = "";
					if (operator == 0) {
						answer = firstNum;
						firstHalfDone = true;
					} else if (operator == 1) {
						answer = firstNum + secondNum;
						firstHalfDone = true;
					} else if (operator == 2) {
						answer = firstNum - secondNum;
						firstHalfDone = true;
					} else if (operator == 3) {
						answer = firstNum * secondNum;
						firstHalfDone = true;
					} else {
						if (secondNum == 0) {
							text += "=\nError: Cannot divide by zero!\n";
							calcView.setText(text);
							firstHalfDone = false;
						} else {
							answer = firstNum / secondNum;
							firstHalfDone = true;
						}
					}
					if (firstHalfDone) {
						text += "=\n";
						text += df.format(answer) + "\n";
						calcView.setText(text);
						numberBuilder = "";
						operator = 0;
						firstNum = 0;
						secondNum = 0;
						answer = 0;
						firstHalfDone = false;
					}
				}
			}
		});
		bPanel.add(equalsButton);

		// Adding the Division Button
		JButton divisionButton = new JButton("/");
		divisionButton.setActionCommand("/");
		divisionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (!(numberBuilder == "")) {
					if (!firstHalfDone) {
						operator = 4;
						FirstHalf("/");
					} else if (firstHalfDone) {
						if (SecondHalf("/")) {
							operator = 4;
							text += "=\n";
							text += df.format(firstNum) + "/\n";
							calcView.setText(text);
						}
					}
				} else {
					// operator = 4;
					// numberBuilder = "0";
					// text += "0";
					// FirstHalf("/");
					SecondHalf("/");
				}
			}
		});
		bPanel.add(divisionButton);

		text = "";
		firstNum = 0;
		secondNum = 0;
		answer = 0;
		operator = 0;
		firstHalfDone = false;
		numberBuilder = "";
		calcView.setText(text);

		// launching the window and making it visible
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// creating private classes to simplify code
	private void FirstHalf(String strOp) {
		if (!(numberBuilder.equals(""))) {
			firstNum = Double.parseDouble(numberBuilder);
			numberBuilder = "";
			text += strOp + "\n";
			calcView.setText(text);
			firstHalfDone = true;
		}
	}

	// Returns true if the operation completed successfully
	private boolean SecondHalf(String strOp) {
		if (numberBuilder.equals("")) { // if no number, assume double operator
										// (Error)
			text += "Error: You cannot have operator " + strOp
					+ " displayed right now!\n";
			calcView.setText(text);
			return false;
		}
		secondNum = Double.parseDouble(numberBuilder);
		numberBuilder = "";
		if (operator == 1) {
			firstNum = firstNum + secondNum;
		} else if (operator == 2) {
			firstNum = firstNum - secondNum;
		} else if (operator == 3) {
			firstNum = firstNum * secondNum;
		} else if (operator == 4) {
			if (secondNum == 0) {
				text += "\nError: Cannot divide by zero!\n";
				calcView.setText(text);
				firstHalfDone = false;
				numberBuilder = "";
				firstNum = 0;
				secondNum = 0;
				answer = 0;
				operator = 0;
				return false;
			} else {
				firstNum = firstNum / secondNum;
				firstHalfDone = true;
			}
		}
		return true;
	}

	// method used to reduce code when adding multiple calculator buttons
	// (numbers, operators, etc)
	private void addButton(Container contain, String title) {
		JButton button = new JButton(title);
		button.setActionCommand(title);
		button.addActionListener(this);
		contain.add(button);
	}

	// Used to show what the user clicks on the buttons
	public void actionPerformed(ActionEvent event) {
		numberBuilder += event.getActionCommand();
		text += event.getActionCommand();
		calcView.setText(text);
	}
}