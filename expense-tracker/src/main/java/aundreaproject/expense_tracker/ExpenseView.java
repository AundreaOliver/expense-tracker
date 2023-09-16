package aundreaproject.expense_tracker;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
	DefaultTableModel tableModel;
	Object[] row;
	
	public ExpenseView() {
		
		frame = new JFrame();
		frame.setTitle("Expense Tracker");
		frame.setBounds(400, 400, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 899, 699);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(350, 115, 475, 460);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(176, 196, 222));
		tableModel = new DefaultTableModel();
		Object[] column = {"Date", "Item", "Amount", "Description"};
		row = new Object[0];
		tableModel.setColumnIdentifiers(column);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
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
		
		totalLabel = new JLabel("Total: ");
		totalLabel.setBounds(680, 80, 50, 30);
		panel.add(totalLabel);
		
//		dateField = new JTextField();
//		dateField.setBounds(120, 115, 150, 30);
		
		itemField = new JTextField(10);
		itemField.setBounds(120, 150, 150, 30);
		panel.add(itemField);
		
		amountField = new JTextField(10);
		amountField.setBounds(120, 185, 150, 30);
		panel.add(amountField);
		
		descArea = new JTextArea();
		descArea.setBounds(120, 220, 150, 70);
		panel.add(descArea);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("MMMMM d, yyyy");
		dateChooser.setBounds(120, 115, 150, 30);
		panel.add(dateChooser);
		
		addBtn = new JButton("Add");
		addBtn.setBounds(70, 370, 80, 30);
		panel.add(addBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(70, 445, 80, 30);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(200, 370, 80, 30);
		panel.add(deleteBtn);
		
		clearBtn = new JButton("Clear");
		clearBtn.setBounds(200, 445, 80, 30);
		panel.add(clearBtn);

		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	public void setVisibility(boolean visible) {
		this.frame.setVisible(visible);
	}
	
	public void addBtnListener(ActionListener listenForSkillButton) {
		addBtn.addActionListener(listenForSkillButton);
		updateBtn.addActionListener(listenForSkillButton);
		deleteBtn.addActionListener(listenForSkillButton);
		clearBtn.addActionListener(listenForSkillButton);
	}
	
//	public JTextField getDate() {
//		return dateField;
//	}
//	
//	public void setDate(JTextField dateField) {
//		this.dateField = dateField;
//	}
	
	public JTextField getItem() {
		return itemField;
	}
	
	public void setItem(JTextField itemField) {
		this.itemField = itemField;
	}
	
	public JTextField getAmount() {
		return amountField;
	}
	
	public void setAmount(JTextField amountField) {
		this.amountField = amountField;
	}
	
	public JTextArea getDesc() {
		return descArea;
	}
	
	public void setDesc(JTextArea descArea) {
		this.descArea = descArea;
	}
	
	public JButton getAddButton() {
		return this.addBtn;
	}
	
	public JButton getUpdateButton() {
		return this.updateBtn;
	}
	
	public JButton getDeleteButton() {
		return this.deleteBtn;
	}
	
	public JButton getClearButton() {
		return this.clearBtn;
	}
}
