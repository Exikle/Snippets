package com.exikle.java.starttemplates;

// StarterGUI Template
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class StarterGUIWithButtons extends JFrame implements
		ActionListener {

	public static void main(String[] args) {
		new StarterGUIWithButtons();
	}

	public StarterGUIWithButtons() {

		this.setSize(200, 200);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

	}
}
