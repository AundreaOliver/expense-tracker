package aundreaproject.expense_tracker;

import java.util.ArrayList;


public class App {
	public static void main(String[] args) {
		
		LogInModel model = new LogInModel();
		LogInView view = new LogInView();
		LogInController controller = new LogInController(model, view);
		
		//ExpenseView view = new ExpenseView();
		DbConnection conn = new DbConnection();
//		conn.insert("Ac","Aug-10-2023","Laptop",200,"for Work");
//		conn.insert("Aunds","Sep-11-2023","Laptop",200,"for Work");
//		conn.insert("Aunds","Nov-13-2023","Laptop",200,"for Work");
//		conn.insert("Ac","Oct-17-2023","Laptop",200,"for Work");
//		conn.insert("Aunds","Aug-18-2022","Laptop",200,"for Work");
//		conn.insert("Ac","Jul-20-2023","Laptop",200,"for Work");
//		conn.insert("Ac","Nov-15-2023","Laptop",200,"for Work");
//		conn.insert("Draku","Dec-11-2023","Laptop",200,"for Work");
//		conn.insert("Draku","Sep-30-2023","Laptop",200,"for Work");
//		conn.insert("Ac","Jul-19-2022","Laptop",200,"for Work");
//		conn.insert("Ac","Oct-18-2023","Laptop",200,"for Work");
//		conn.insert("Draku","Sep-29-2023","Laptop",200,"for Work");
//		conn.insert("Aunds","Nov-25-2023","Laptop",200,"for Work");
//		conn.insert("Ac","Apr-03-2022","Laptop",200,"for Work");
//		ExpenseUtil exp = new ExpenseUtil();
//		
//		for (ExpenseModel prnt : exp.getExpensesbyMMYYYY("Jul", "2022", "Ac")) {
//			System.out.println(prnt.toString());
//		}
//
//		System.out.println(exp.getTotalAmountByMY("Jul", "2022", "Ac"));
	}
}
