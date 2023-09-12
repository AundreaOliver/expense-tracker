package aundreaproject.expense_tracker;

import java.awt.Color;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;


public class ExpenseView {

	private JFrame frame;
	private JTextField dateField;
	private JTextField itemField;
	private JTextField amountField;
	private JTextArea descArea;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton addBtn;
	private JButton deleteBtn;
	private JButton updateBtn;
	private JButton clearBtn;
	private JLabel userLabel;
	private JLabel dateLabel;
	private JLabel itemLabel;
	private JLabel amtLabel;
	private JLabel descLabel;
	private JLabel totalLabel;
	private JDateChooser dateChooser;
	
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
		
		userLabel = new JLabel("User: ");
		userLabel.setBounds(30, 80, 50, 30);
		panel.add(userLabel);
		
		dateLabel = new JLabel("Date: ");
		dateLabel.setBounds(30, 115, 50, 30);
		panel.add(dateLabel);
		
		itemLabel = new JLabel("Item: ");
		itemLabel.setBounds(30, 150, 50, 30);
		panel.add(itemLabel);
		
		amtLabel = new JLabel("Amount: ");
		amtLabel.setBounds(30, 185, 70, 30);
		panel.add(amtLabel);
		
		descLabel = new JLabel("Description: ");
		descLabel.setBounds(30, 220, 90, 30);
		panel.add(descLabel);
		
		dateField = new JTextField();
		dateField.setBounds(75, 115, 150, 30);
		
		itemField = new JTextField();
		itemField.setBounds(75, 150, 150, 30);
		panel.add(itemField);
		
		amountField = new JTextField();
		amountField.setBounds(95, 185, 150, 30);
		panel.add(amountField);
		
		descArea = new JTextArea();
		descArea.setBounds(120, 220, 150, 60);
		panel.add(descArea);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("MMMMM d, yyyy");
		dateChooser.setBounds(75, 115, 150, 30);
		panel.add(dateChooser);
		


		
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	public void setVisibility(boolean visible) {
		this.frame.setVisible(visible);
	}
	
}
