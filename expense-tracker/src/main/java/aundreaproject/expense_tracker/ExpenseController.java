package aundreaproject.expense_tracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ExpenseController {

	private String username;
	private DbConnection connection = new DbConnection(); 
	private ExpenseModel model;
	private ExpenseView view;
	
	public ExpenseController(ExpenseModel model, ExpenseView view, String username) {
		this.model = model;
		this.view = view;
		this.username = username;
		this.view.addBtnListener(new AddBtnListener());
		this.view.updateBtnListener(new UpdateBtnListener());
		this.view.delBtnListener(new DeleteBtnListener());
		this.view.clearBtnListener(new ClearBtnListener());
		loadData(this.username);
	}
	
	public void loadData(String username) {
		// For loop
		// each iteration add to row to table
		
		for (ExpenseModel model : connection.getExpenseModels(username)) {
			view.row[0] = model.getDate();
			view.row[1] = model.getItem();
			view.row[2] = model.getAmount();
			view.row[3] = model.getDescription();
			view.tableModel.addRow(view.row);
		}
	}

	class AddBtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (view.getDate().equals("") || view.getItem().equals("") || view.getAmount().equals("") || view.getDesc().equals("")) {
				JOptionPane.showMessageDialog(null, "Please fill in complete information.");
				
			} else {
				String selectDate = ((JTextField)view.getDate().getDateEditor().getUiComponent()).getText();
				double amt = Double.parseDouble(view.getAmount().getText());
				view.row[0] = selectDate;
				view.row[1] = view.getItem().getText();
				view.row[2] = view.getAmount().getText();
				view.row[3] = view.getDesc().getText();
				view.tableModel.addRow(view.row);
				JOptionPane.showMessageDialog(null, "Added successfully!");
			
				connection.insert(username, selectDate, view.getItem().getText(), amt, view.getDesc().getText());
			}
			
		}
		
	}
	
	class UpdateBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String selectDate = ((JTextField)view.getDate().getDateEditor().getUiComponent()).getText();
			int i = view.getTable().getSelectedRow();
			if (i >= 0) {
				view.tableModel.setValueAt(selectDate, i, 0);
				view.tableModel.setValueAt(view.getItem(), i, 1);
				view.tableModel.setValueAt(view.getAmount(), i, 2);
				view.tableModel.setValueAt(view.getDesc(), i, 3);
				JOptionPane.showMessageDialog(null, "Updated successfully");
			} else {
				JOptionPane.showMessageDialog(null, "Select a row first to update");
			}
			
		}
		
	}
	
	class DeleteBtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int i = view.getTable().getSelectedRow();
			if (i >= 0) {
				view.tableModel.removeRow(i);
				JOptionPane.showMessageDialog(null, "Deleted successfully");
			} else {
				JOptionPane.showMessageDialog(null, "Select a row first to delete");
			}
			
		}
		
	}
	
	class ClearBtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			((JTextField)view.getDate().getDateEditor().getUiComponent()).setText("");
			view.getItem().setText("");
			view.getAmount().setText("");
			view.getDesc().setText("");	
		}
		
	}
}
