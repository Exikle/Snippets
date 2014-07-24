/**
 * @author Dixon D'Cunha
 */
package com.exikle.java.gamblecalculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author Dixon D'Cunha
 */
@SuppressWarnings("serial")
public class RunCalculator extends JFrame implements ActionListener {

	JTextField inDecOne;

	JTextField inDecTwo;

	JTextField inMonOne;

	JTextField inMonTwo;

	JTextField maxMoney;

	JLabel lblOne;

	JLabel lblTwo;

	JButton calcBtn;

	public RunCalculator() {
		intialize();
		this.setSize(500, 500);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		addInteractables();
	}

	/**
	 * Add all the interactables
	 */
	private void addInteractables() {

		JPanel pnl1 = new JPanel();
		pnl1.setLayout(new GridLayout(3, 2));

		pnl1.add(inDecOne);
		pnl1.add(inDecTwo);

		pnl1.add(inMonOne);
		pnl1.add(inMonTwo);

		pnl1.add(lblOne);
		pnl1.add(lblTwo);

		this.add(maxMoney, BorderLayout.NORTH);

		this.add(pnl1, BorderLayout.CENTER);

		this.add(calcBtn, BorderLayout.SOUTH);
	}

	/**
	 * Initialize the objects
	 */
	private void intialize() {
		maxMoney = new JTextField("100");
		maxMoney.setHorizontalAlignment(SwingConstants.CENTER);

		inDecOne = new JTextField("1.5");
		inDecTwo = new JTextField("2.0");

		inMonOne = new JTextField("45");
		inMonTwo = new JTextField("50");

		lblOne = new JLabel("Made This Much");
		lblTwo = new JLabel("Made This Much");

		calcBtn = new JButton("Calculate");
		calcBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == calcBtn)
			calculateMoneyMade();
	}

	private void calculateMoneyMade() {
		Double factorOne = Double.parseDouble(inDecOne.getText());
		Double factorTwo = Double.parseDouble(inDecTwo.getText());

		Double betOne = Double.parseDouble(inMonOne.getText());
		Double betTwo = Double.parseDouble(inMonTwo.getText());

		Double moneyOne = factorOne * betOne;
		Double moneyTwo = factorTwo * betTwo;

		System.out.println(checkLoss(moneyOne, moneyTwo));

		lblOne.setText("$" + moneyOne);
		lblTwo.setText("$" + moneyTwo);

	}

	boolean checkLoss(double teamOne, double teamTwo) {
		return (teamOne - teamTwo == 0) ? false : true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new RunCalculator();
	}
}
