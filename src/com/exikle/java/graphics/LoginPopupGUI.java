package com.exikle.java.graphics;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginPopupGUI extends JFrame implements ActionListener {

	private JPanel pnl1;

	private JPanel userPanel;

	public static void main(String[] args) {
		new LoginPopupGUI();
	}

	public LoginPopupGUI() {
		setUpUI();

		// Labels for the textfield components
		JLabel usernameLbl = new JLabel("Username:");
		JLabel passwordLbl = new JLabel("Password:");

		JTextField username = new JTextField();
		JPasswordField passwordFld = new JPasswordField();

		// Add the components to the JPanel
		userPanel.add(usernameLbl);
		userPanel.add(username);
		userPanel.add(passwordLbl);
		userPanel.add(passwordFld);

		// As the JOptionPane accepts an object as the message
		// it allows us to use any component we like - in this case
		// a JPanel containing the dialog components we want
		popNotificaiton();
	}

	private void popNotificaiton() {
		JOptionPane.showConfirmDialog(null, userPanel,
				"Enter your Password:", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
	}

	private void setUpUI() {
		pnl1 = new JPanel();

		this.add(pnl1);
		this.setSize(300, 300);

		this.setVisible(false);
		// Using a JPanel as the message for the JOptionPane
		userPanel = new JPanel();
		userPanel.setLayout(new GridLayout(2, 2));
	}

	public void actionPerformed(ActionEvent e) {

	}

}
