package ledjer.fixtures;

import ledjer.Payment;

public class Payments {
	private int amount;
	private String payee;
	
	public Payments() {
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void setPayee(String payee) {
		this.payee = payee;
	}
	
	public int balance() {
		return Context.ledger.getBalance();
	}
	
	public void execute() {
		Context.ledger.payment(new Payment(amount, payee));
	}
}
