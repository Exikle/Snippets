package com.exikle.java.starttemplates;

/*
 * StarterGUITemplate.java
 * Dixon D'Cunha
 * Date(Day,Month,Year)
 * ICS 4U1
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

// Import Area

@SuppressWarnings("serial")
public class StarterGUITemplate extends JFrame implements
		ActionListener {

	/**
	 * StarterGUI Template, Description of Program
	 */
	// Declaration Area
	public static void main(String[] args) {
		new StarterGUITemplate();
	}

	public StarterGUITemplate() {
		this.setSize(200, 200);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {}
}
