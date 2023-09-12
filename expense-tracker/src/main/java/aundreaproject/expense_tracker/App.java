package aundreaproject.expense_tracker;

import java.util.ArrayList;


public class App {
	public static void main(String[] args) {
		
		DbConnection conn = new DbConnection();
//		ArrayList<LogInModel> arr = conn.getLogInUser();
//		
//		for(LogInModel user : arr) {
//			System.out.println(user.getUser());
//		}
		
		
		LogInModel model = new LogInModel();
		LogInView view = new LogInView();
		LogInController controller = new LogInController(model, view);
		
		
		
		//ExpenseView view = new ExpenseView();
		
//		conn.insert("Ac","Aug-10-2023","Laptop",200,"for Work");

//		ExpenseUtil exp = new ExpenseUtil();
//		
//		for (ExpenseModel prnt : exp.getExpensesbyMMYYYY("Jul", "2022", "Ac")) {
//			System.out.println(prnt.toString());
//		}
//
//		System.out.println(exp.getTotalAmountByMY("Jul", "2022", "Ac"));
	}
}
