package aundreaproject.expense_tracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbConnection {

	public String jdbcUrl = "jdbc:sqlite:/C:\\Users\\User\\Documents\\Sqlite\\sqlite-tools-win32-x86-3420000\\expense.db";
	public Connection connection;
	
	public DbConnection() {
		try {
			connection = DriverManager.getConnection(jdbcUrl);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(String user, String date, String item, double amt, String desc) {
		try {
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
	
	/**
	 * @param user
	 * 			Expense tracker user.
	 * @return
	 * 			ArrayList with expenses of specified user.
	 */			
	public ArrayList<ExpenseModel> getExpenseModels(String user){
		ArrayList<ExpenseModel> list = new ArrayList<ExpenseModel>();
		
		try {
			PreparedStatement pst = connection.prepareStatement("select * from expenses where user = ?");
			pst.setString(1, user);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String usr = rs.getString("user");
				String date = rs.getString("date");
				String item = rs.getString("item");
				double amount = rs.getDouble("amount");
				String description = rs.getString("description");
				
				list.add(new ExpenseModel(usr, date, item, description, amount));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insertUser(String user) {
		try {
			String sqlInsert = "insert into users (user) values (?)";

			PreparedStatement pst = connection.prepareStatement(sqlInsert);
			pst.setString(1, user);
			pst.execute();
			 
		} catch (Exception e) {
			System.out.println("Error connecting to SQLite database");
			System.out.println(e);
		}
	}
	
	public ArrayList<LogInModel> getLogInUser(){
		ArrayList<LogInModel> list = new ArrayList<LogInModel>();
		
		try {
			PreparedStatement pst = connection.prepareStatement("select * from users");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String usr = rs.getString("user");
				
				list.add(new LogInModel(usr));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
