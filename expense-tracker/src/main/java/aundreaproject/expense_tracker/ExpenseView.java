package aundreaproject.expense_tracker;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
//	private JTextField dateField;
	private JTextField itemField;
	private JTextField amountField;
	private JTextArea descArea;
	private JTextField idField;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton addBtn;
	private JButton deleteBtn;
	private JButton updateBtn;
	private JButton clearBtn;
	private JLabel usernameLabel;
	private JLabel userLabel;
	private JLabel idLabel;
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
		table.setDragEnabled(false);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				idField.setText(tableModel.getValueAt(i, 0).toString());
				((JTextField)dateChooser.getDateEditor().getUiComponent()).setText(tableModel.getValueAt(i, 1).toString());
				itemField.setText(tableModel.getValueAt(i, 2).toString());
				amountField.setText(tableModel.getValueAt(i, 3).toString());
				descArea.setText(tableModel.getValueAt(i, 4).toString());	
				
			}
		});
		table.setBackground(new Color(176, 196, 222));
		tableModel = new DefaultTableModel();
		Object[] column = {"Expense ID", "Date", "Item", "Amount", "Description"};
		row = new Object[5];
		tableModel.setColumnIdentifiers(column);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
		userLabel = new JLabel("User: ");
		userLabel.setBounds(30, 50, 150, 70);
		userLabel.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(userLabel);
		
		usernameLabel = new JLabel();
		usernameLabel.setBounds(120, 50, 150, 70);
		usernameLabel.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(usernameLabel);
		
		idLabel = new JLabel("Expense ID: ");
		idLabel.setBounds(30, 115, 90, 30);
		panel.add(idLabel);
		
		dateLabel = new JLabel("Date: ");
		dateLabel.setBounds(30, 150, 50, 30);
		panel.add(dateLabel);
		
		itemLabel = new JLabel("Item: ");
		itemLabel.setBounds(30, 185, 50, 30);
		panel.add(itemLabel);
		
		amtLabel = new JLabel("Amount: ");
		amtLabel.setBounds(30, 220, 70, 30);
		panel.add(amtLabel);
		
		descLabel = new JLabel("Description: ");
		descLabel.setBounds(30, 255, 90, 30);
		panel.add(descLabel);
		
		totalLabel = new JLabel("Total: ");
		totalLabel.setBounds(680, 80, 50, 30);
		panel.add(totalLabel);
		
//		dateField = new JTextField();
//		dateField.setBounds(120, 115, 150, 30);
		
		idField = new JTextField();
		idField.setBounds(120, 115, 150, 30);
		idField.setBackground(Color.white);
		idField.setEditable(false);
		panel.add(idField);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("MMMMM d, yyyy");
		dateChooser.setBounds(120, 150, 150, 30);
		panel.add(dateChooser);
		
		itemField = new JTextField(10);
		itemField.setBounds(120, 185, 150, 30);
		panel.add(itemField);
		
		amountField = new JTextField(10);
		amountField.setBounds(120, 220, 150, 30);
		panel.add(amountField);
		
		descArea = new JTextArea();
		descArea.setBounds(120, 255, 150, 70);
		panel.add(descArea);
		
		addBtn = new JButton("Add");
		addBtn.setBounds(70, 390, 80, 30);
		panel.add(addBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(70, 465, 80, 30);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(200, 390, 80, 30);
		panel.add(deleteBtn);
		
		clearBtn = new JButton("Clear");
		clearBtn.setBounds(200, 465, 80, 30);
		panel.add(clearBtn);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	public void setVisibility(boolean visible) {
		this.frame.setVisible(visible);
	}
	
	public void addBtnListener(ActionListener listenForButton) {
		addBtn.addActionListener(listenForButton);
	}
		
	public void updateBtnListener(ActionListener listenForButton) {
		updateBtn.addActionListener(listenForButton);
	}
	
	public void delBtnListener(ActionListener listenForButton) {
		deleteBtn.addActionListener(listenForButton);
	}
	
	public void clearBtnListener(ActionListener listenForButton) {
		clearBtn.addActionListener(listenForButton);
	}
	
	public void addMouseListener(MouseAdapter listenForMouse) {
		table.addMouseListener(listenForMouse);
	}
	
//	public JTextField getDate() {
//		return dateField;
//	}
//	
//	public void setDate(JTextField dateField) {
//		this.dateField = dateField;
//	}
	
	public JTable getTable() {
		return this.table;
	}
	
	public void setTable(JTable table) {
		this.table = table;
	}
	
	public JLabel getUsername() {
		return this.usernameLabel;
	}
	
	public void setUsername(JLabel usernameLabel) {
		this.usernameLabel = usernameLabel;
	}
	
	public JLabel getUser() {
		return this.userLabel;
	}
	
	public void setUser(JLabel userLabel) {
		this.userLabel = userLabel;
	}
	
	public JTextField getIdField() {
		return this.idField;
	}
	
	public void setIdField(JTextField idField) {
		this.idField = idField;
	}
	
	public JDateChooser getDate() {
		return dateChooser;
	}
	
	public void setDate(JDateChooser dateChooser) {
		this.dateChooser = dateChooser;
	}
	
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
