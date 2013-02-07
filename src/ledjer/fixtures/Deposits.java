package ledjer.fixtures;

import ledjer.Deposit;
import ledjer.Transaction;

public class Deposits {
	private Transaction deposit;
	
	public void setAmount(int amount) {
		deposit = new Deposit(amount);
	}
	
	public int balance() {
		return Context.ledger.getBalance();
	}
	
	public void execute() {
		Context.ledger.deposit(deposit);
	}
}
