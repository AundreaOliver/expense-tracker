package aundreaproject.expense_tracker;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ExpenseView {

	private JFrame frame;
	private JTextField userField;
	private JTextField dateField;
	private JTextField itemField;
	private JTextField amountField;
	private JTextField descField;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton logInButton;
	private JButton addBtn;
	private JButton deleteBtn;
	private JButton updateBtn;
	private JButton clearBtn;
	
	public ExpenseView() {
		
		frame = new JFrame();
		frame.setBounds(400, 400, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 599, 599);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel userLabel = new JLabel("USER: ");
		userLabel.setBounds(30, 100, 50, 30);
		panel.add(userLabel);
		frame.setVisible(true);
	}
	
}
