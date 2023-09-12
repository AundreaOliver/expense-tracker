package aundreaproject.expense_tracker;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LogInView {

	private JLabel userLabel;
	private JTextField userText;
	private JButton logInBtn;
	private JButton createBtn;
	private JFrame frame;

	public LogInView() {

		JPanel panel = new JPanel();
		frame = new JFrame();
		frame.setTitle("Log In");
		frame.setSize(400, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		panel.setLayout(null);
		panel.setBackground(Color.gray);

		userLabel = new JLabel("USER: ");
		userLabel.setBounds(52, 33, 80, 25);
		panel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(109, 30, 160, 30);
		panel.add(userText);

		logInBtn = new JButton("LOGIN");
		logInBtn.setFocusable(false);
		logInBtn.setBounds(137, 75, 100, 30);
		panel.add(logInBtn);

		createBtn = new JButton("CREATE");
		createBtn.setFocusable(false);
		createBtn.setBounds(137, 120, 100, 30);
		panel.add(createBtn);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void setVisibility(boolean visible) {
		this.frame.setVisible(visible);
	}

	public JLabel getUserLabel() {
		return userLabel;
	}

	public void setUserLabel(JLabel userLabel) {
		this.userLabel = userLabel;
	}

	public JTextField getUserText() {
		return userText;
	}

	public void setUserText(JTextField userText) {
		this.userText = userText;
	}

	public JButton getLogInBtn() {
		return logInBtn;
	}

	public void setLogInBtn(JButton logInBtn) {
		this.logInBtn = logInBtn;
	}

	public JButton getCreateBtn() {
		return createBtn;
	}

	public void setCreateBtn(JButton createBtn) {
		this.createBtn = createBtn;
	}

	public void addLogInListener(ActionListener listenForLogInBtn) {
		logInBtn.addActionListener(listenForLogInBtn);
	}

	public void addCreateListener(ActionListener listenForCreateBtn) {
		createBtn.addActionListener(listenForCreateBtn);
	}
}
