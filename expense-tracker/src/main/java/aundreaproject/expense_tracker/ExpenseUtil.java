package aundreaproject.expense_tracker;

import java.util.ArrayList;

public class ExpenseUtil {

	private DbConnection connection = new DbConnection();
	
	public ExpenseUtil() {
		
	}
	
	public ArrayList<ExpenseModel> getExpensesbyMMYYYY(String month, String year, String user){
		ArrayList<ExpenseModel> arrayList = new ArrayList<ExpenseModel>();
		ArrayList<ExpenseModel> userList = connection.getExpenseModels(user);
		
		for (ExpenseModel expenseModel : userList) {
			String date = expenseModel.getDate();
			if (date.contains(month) && date.contains(year)) {
				arrayList.add(expenseModel);
			}
		}
		return arrayList;
	}
	
	public double getTotalAmountByMY(String month, String year, String user) {
		double amt = 0;
		for (ExpenseModel expenseModel : getExpensesbyMMYYYY(month, year, user)) {
			amt += expenseModel.getAmount();
		}
		return amt;
	}
}
