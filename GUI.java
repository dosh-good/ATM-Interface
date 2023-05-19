import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//import java.awt.event.*;

public class GUI {
	String custName;
	BankAccountInfo cust = new BankAccountInfo();
	JTextField name;

	public void welcome() {
		JFrame frame = new JFrame("ATM Application ");
		frame.setSize(300, 400);
		frame.setLocationRelativeTo(null);

		JPanel content = new JPanel();
		JLabel prompt = new JLabel("Please enter in your name: ");
		name = new JTextField(10);
		JButton button = new JButton("OK");
		content.add(prompt);
		content.add(name);
		content.add(button);

		frame.add(content);
		frame.setVisible(true);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI next = new GUI();
				cust.name = name.getText();
				next.prompt(cust.name);
			}
		});
	}
	
	public void prompt(String custName) {
		JFrame frame = new JFrame("ATM Application");
		frame.setSize(300, 400);
		frame.setLocationRelativeTo(null);
		
		JPanel content = new JPanel();
		JLabel greeting = new JLabel("Welcome "+custName);
		JLabel menu = new JLabel("Choose an option from below: ");
		
		JRadioButton add = new JRadioButton("Add Funds");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bal = JOptionPane.showInputDialog("How much would you like to deposit?");
				double a = Integer.parseInt(bal);
				cust.balance = a; // set cust b
				JOptionPane.showMessageDialog(add, "Amount Added!");
			}
		});
		
		JRadioButton withdraw = new JRadioButton("Withdraw Funds");
		withdraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bal = JOptionPane.showInputDialog("How much would you like to withdraw? ");
				int a = Integer.parseInt(bal);
				cust.balance = cust.balance - a;
				JOptionPane.showMessageDialog(withdraw, "Amount withdrawn! ");
			}});
		
		JRadioButton balance = new JRadioButton("Check Balance");
		balance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(balance, cust.balance);;
			}});
	
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}});
		
		ButtonGroup group = new ButtonGroup();
		group.add(add);
		group.add(withdraw);
		group.add(balance);

		content.add(greeting);
		content.add(menu);
		content.add(add);
		content.add(withdraw);
		content.add(balance);
		content.add(exit);
		
		frame.add(content);
		frame.setVisible(true);
	}
		
}
