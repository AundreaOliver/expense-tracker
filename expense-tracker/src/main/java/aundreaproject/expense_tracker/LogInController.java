package aundreaproject.expense_tracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidAlgorithmParameterException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class LogInController {

	public String username;
	private DbConnection connection = new DbConnection();
	private LogInModel model;
	private LogInView view;

	public LogInController(LogInModel model, LogInView view) {
		this.model = model;
		this.view = view;

		this.view.addLogInListener(new LogInListener());
		this.view.addCreateListener(new CreateListener());

	}

	class LogInListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			username = view.getUserText().getText();
			ArrayList<LogInModel> userList = connection.getLogInUser();
			boolean exists = false;

			if (username.isBlank()) {
				JOptionPane.showMessageDialog(null, "Invalid. User input is blank.");
				return;
			}

			if (userList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please create a User.");
				return;
			}

			for (LogInModel user : userList) {
				if (!username.equals(user.getUser())) {
					exists = true;

				} else {
					exists = false;
				}
			}

			if (!exists) {
				JOptionPane.showMessageDialog(null, "Logged in Successfully!");
				view.setVisibility(false);
				ExpenseModel expModel = new ExpenseModel();
				ExpenseView expView = new ExpenseView();
				ExpenseController expController = new ExpenseController(expModel, expView, username);
				expView.getUser().setText("User: " + username);

			} else {
				JOptionPane.showMessageDialog(null, "User does not exist. Please Create!");
			}

		}

	}

	class CreateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ValidateUtil validateUser = new ValidateUtil();
			username = view.getUserText().getText();
			ArrayList<LogInModel> userList = connection.getLogInUser();
			boolean exists = false;

			if (username.isBlank()) {
				JOptionPane.showMessageDialog(null, "Invalid. User input is blank.");
				return;
			}

			for (LogInModel user : userList) {
				if (username.equals(user.getUser())) {
					exists = true;
					break;
				}
			}

			if (!exists) {
				boolean containsSpecialChars = validateUser.isStringContainsSpecialChars(username);
				if (!containsSpecialChars) {
					connection.insertUser(username);
					JOptionPane.showMessageDialog(null, "User created! Please log in.");
				} else {
					JOptionPane.showMessageDialog(null, "Invalid. Username contains special characters.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "User already exists.");
			}

		}

	}

}
