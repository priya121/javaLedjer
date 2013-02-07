package ledjer;

public abstract class Transaction {

	private int amount;
	
	public Transaction(int amount) {
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}

}
