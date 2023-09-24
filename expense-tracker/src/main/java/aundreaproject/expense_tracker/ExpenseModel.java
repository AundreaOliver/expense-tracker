package aundreaproject.expense_tracker;


public class ExpenseModel {

	private String expId;
	private String user;
	private String date;
	private String item;
	private String description;
	private double amount;
	
	public ExpenseModel() {
		
		
	}
	
	public ExpenseModel(String expId, String user, String date, String item, String description, double amount) {
		this.expId = expId;
		this.user = user;
		this.date = date;
		this.item = item;
		this.description = description;
		this.amount = amount;
	}
	
	public String getExpId() {
		return this.expId;
	}
	
	public void setExpId(String expId) {
		this.expId = expId;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String toString() {
		String str = this.user + " | " + this.date + " | " + this.item + " | " + Double.toString(this.amount) + " | " + this.description;
		return str;
	}
	
	
	
}
