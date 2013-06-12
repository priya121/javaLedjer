package ledjer;

public class Ledger {
	
	private int balance;
	
	public Ledger() {
		balance = 0;
	}
	
	public int getBalance() {
		return balance;
	}

	public void deposit(Deposit deposit) {
	}

	public String statement() {
		return "";
	}
}