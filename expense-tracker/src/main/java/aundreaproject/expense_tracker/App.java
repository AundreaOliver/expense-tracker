package aundreaproject.expense_tracker;

import javax.swing.JTextField;

public class App {
	public static void main(String[] args) {

		DbConnection conn = new DbConnection();
		conn.connection();
		conn.insert("Ac", "August 28, 2023", "pencil", 20.3, "for school supply");
		System.out.println("Comp");
	}
}
