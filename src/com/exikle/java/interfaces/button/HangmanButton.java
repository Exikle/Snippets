package com.exikle.java.interfaces.button;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;

@SuppressWarnings("serial")
class HangmanButton extends JButton {

	private static final Icon noIcon = null;

	private static final String noString = null;

	private Font dFont = null;

	public HangmanButton() {
		this(noString, noIcon);
	}

	public HangmanButton(final String string) {
		this(string, noIcon);
	}

	public HangmanButton(final Icon icon) {
		this(noString, icon);
	}

	private HangmanButton(final String s, final Icon i) {
		setModel(new DefaultButtonModel());
		init(s, i);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);

		try {
			File f = new File("res/VTK.ttf");
			FileInputStream in = new FileInputStream(f);
			dFont = Font.createFont(Font.TRUETYPE_FONT, in);
			System.out.println("Created Derived Font");
		} catch (Exception e) {
			System.out.println("Problem Creating Font");
		}
	}

	public void setFont(final int num) {
		this.setFont(dFont.deriveFont((float) num));
	}
}
