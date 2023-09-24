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
	
	public void clearTable() {
		if (view.tableModel.getRowCount() > 0) {
		    for (int i = view.tableModel.getRowCount() - 1; i > -1; i--) {
		        view.tableModel.removeRow(i);
		    }
		}
	}
	
	public void loadData(String username) {
		// For loop
		// each iteration add to row to table
		for (ExpenseModel model : connection.getExpenseModels(username)) {
			view.row[0] = model.getExpId();
			view.row[1] = model.getDate();
			view.row[2] = model.getItem();
			view.row[3] = model.getAmount();
			view.row[4] = model.getDescription();
			view.tableModel.addRow(view.row);
		}
	}
	

	class AddBtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String selectDate = ((JTextField)view.getDate().getDateEditor().getUiComponent()).getText();
			if (selectDate.isBlank() || view.getItem().getText().isBlank() || 
					view.getAmount().getText().isBlank() || view.getDesc().getText().isBlank()) {
				JOptionPane.showMessageDialog(null, "Please fill in complete information.");
				
			} else {
				double amt = Double.parseDouble(view.getAmount().getText());
				connection.insert(username, selectDate, view.getItem().getText(), amt, view.getDesc().getText());
				clearTable();
				loadData(username);
				JOptionPane.showMessageDialog(null, "Added successfully!");
			
			}
			
		}
		
	}
	
	class UpdateBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int i = view.getTable().getSelectedRow();
			if (i >= 0) {
				String selectDate = ((JTextField)view.getDate().getDateEditor().getUiComponent()).getText();
				double amt = Double.parseDouble(view.getAmount().getText());
				connection.updateData(view.getIdField().getText(), username, selectDate,view.getItem().getText(), amt, view.getDesc().getText());
				clearTable();
				loadData(username);
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
				connection.deleteData(view.getIdField().getText());
				clearTable();
				loadData(username);
				JOptionPane.showMessageDialog(null, "Deleted successfully");
			} else {
				JOptionPane.showMessageDialog(null, "Select a row first to delete");
			}
			
		}
		
	}
	
	class ClearBtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			view.getIdField().setText("");
			((JTextField)view.getDate().getDateEditor().getUiComponent()).setText("");
			view.getItem().setText("");
			view.getAmount().setText("");
			view.getDesc().setText("");
			view.getTable().clearSelection();
		}
		
	}
}
