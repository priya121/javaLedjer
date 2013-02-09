package ledjer.fixtures;

import ledjer.Payment;

public class Payments {
	private int amount;
	private String payee;
	private Payment payment;
	
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
	
	public int number() {
		return payment.getNumber();
	}
	
	public void execute() {
		payment = new Payment(amount, payee);
		Context.ledger.pay(payment);
	}
}
