package aundreaproject.expense_tracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {

	public static String jdbcUrl = "jdbc:sqlite:/C:\\Users\\User\\Documents\\Sqlite\\sqlite-tools-win32-x86-3420000\\expense.db";
	
	public void connection() {
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(String user, String date, String item, double amt, String desc) {
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl);
			String sqlInsert = "insert into expenses (user, date, item, amount, description) values (?, ?, ?, ?, ?)";

			PreparedStatement pst = connection.prepareStatement(sqlInsert);
			pst.setString(1, user);
			pst.setString(2, date);
			pst.setString(3, item);
			pst.setDouble(4, amt);
			pst.setString(5, desc);
			pst.execute();
	

		} catch (Exception e) {
			System.out.println("Error connecting to SQLite database");
			System.out.println(e);
		}
	}
}
