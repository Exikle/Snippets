package com.exikle.java.graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class BGTextGUI extends JFrame implements ActionListener {

	// Declaration Area
	Border brdr1, brdr2;

	JButton test = new JButton(), test2 = new JButton("FSDFASDGDF");

	Icon img = new ImageIcon("chalkBG.png");

	public static void main(String[] args) {
		new BGTextGUI();
	}

	public BGTextGUI() {
		brdr1 = new CompoundBorder(LineBorder.createGrayLineBorder(),
				BorderFactory.createLineBorder(Color.white));
		brdr2 = new CompoundBorder(brdr1,
				BorderFactory.createLoweredBevelBorder());

		test.setIcon(img);
		// pnl1.add(test);
		// this.add(pnl1);
		this.setSize(350, 350);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

	}

	// private class RightClicker extends MouseAdapter {
	// public void mousePressed( MouseEvent e ) {
	// if ( e.isMetaDown() ) {
	//
	// }
	// }
	// }

}
