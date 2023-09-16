package aundreaproject.expense_tracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpenseController {

	private ExpenseModel model;
	private ExpenseView view;
	
	public ExpenseController(ExpenseModel model, ExpenseView view) {
		this.model = model;
		this.view = view;
		
		this.view.addBtnListener(new BtnListener());
	}
	
	class BtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == view.getAddButton()) {
				view.tableModel.addRow(view.row);
				
			}
			
		}
		
	}
}
