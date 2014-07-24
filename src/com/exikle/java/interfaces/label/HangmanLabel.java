package com.exikle.java.interfaces.label;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JLabel;

@SuppressWarnings("serial")
class HangmanLabel extends JLabel {

	private static final String noString = null;

	private Font dFont = null;

	/**
	 * Constructor.
	 */
	public HangmanLabel() {
		this(noString);
	}

	/**
	 * Overridden Constructor.
	 */
	private HangmanLabel(final String s) {
		super(s);
		this.setOpaque(false);

		File f = new File("VTK.ttf");
		FileInputStream in = null;
		try {
			in = new FileInputStream(f);
			dFont = Font.createFont(Font.TRUETYPE_FONT, in);
			System.out.println("Created font");
		} catch (Exception e) {
			System.out.println("Problem Creating Font");
		}
	}

	public void setFont(final int sizeOfFont) {
		this.setFont(dFont.deriveFont((float) sizeOfFont));
	}
}
