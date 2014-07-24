package com.exikle.java;

import javax.swing.*;

import java.awt.event.*;

public class AddRemoveItemFromCombo {

	JComboBox<String> combo;

	JTextField txtBox;

	JButton button1 = new JButton("Add");

	JButton button2 = new JButton("Remove");

	JFrame frame = new JFrame("Add-Remove Item of a Combo Box");

	public static void main(String[] args) {
		new AddRemoveItemFromCombo();
	}

	public AddRemoveItemFromCombo() {
		String items[] = { "Java", "JSP", "PHP", "C", "C++" };
		combo = new JComboBox<String>(items);
		txtBox = new JTextField(20);
		button1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!txtBox.getText().equals("")) {
					int a = 0;
					for (int i = 0; i < combo.getItemCount(); i++) {
						if (combo.getItemAt(i).equals(
								txtBox.getText())) {
							a = 1;
							break;
						}
					}
					if (a == 1)
						JOptionPane.showMessageDialog(null,
								"Combo has already this item.");
					else
						combo.addItem(txtBox.getText());
				} else {
					JOptionPane.showMessageDialog(null,
							"Please enter text in Text Box");
				}
			}
		});
		button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (combo.getItemCount() > 0)
					combo.removeItemAt(0);
				else
					JOptionPane.showMessageDialog(null,
							"Item not available");
			}
		});
		setUpUI();

	}

	private void setUpUI() {
		JPanel panel = new JPanel();
		panel.add(txtBox);
		panel.add(combo);
		panel.add(button1);
		panel.add(button2);
		frame.add(panel);
		frame.setSize(400, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}