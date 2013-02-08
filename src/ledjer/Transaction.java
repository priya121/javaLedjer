package ledjer;

public abstract class Transaction {

	private int amount;
	
	public Transaction(int amount) {
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public abstract String asStatement();
	
	public static String formattedAmount(int amount) {
		int dollar = amount / 100;
		int cents = amount % 100;
		return String.format("$%1d.%02d", dollar, cents);
	}
	
	public static String newLine() {
		return System.getProperty("line.separator");
	}
}