package com.exikle.java.calculators;

import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ExCalculator extends Applet implements ActionListener {
	JPanel bPanel;
	JPanel opButtons;
	JPanel textPanel;
	JTextArea calcView;
	JScrollPane scroll;

	String text;
	int operator;
	double firstNum;
	double secondNum;
	double answer;
	boolean firstHalfDone;
	String numBuild;
	DecimalFormat df = new DecimalFormat("#.##");

	public void init() {

	}

	public void stop() {

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

	}
}
