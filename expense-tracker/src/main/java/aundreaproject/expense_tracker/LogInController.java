package aundreaproject.expense_tracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class LogInController {
	
	private DbConnection connection = new DbConnection();

	private LogInModel model;
	private LogInView view;
	
	
	public LogInController(LogInModel model, LogInView view) {
		this.model = model;
		this.view = view;
		
		this.view.addLogInListener(new LogInListener());
		this.view.addCreateListener(new CreateListener());
		
	}
	
	
	class LogInListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			view.setVisibility(false);
			ExpenseView expView = new ExpenseView();
			
		}
		
	}
	
	class CreateListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = view.getUserText().getText();
			
			connection.insertUser(username);
			
		}
		
	}
	
}
