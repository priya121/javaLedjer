package ledjer.fixtures;

import ledjer.Deposit;
import ledjer.Ledger;
import ledjer.Payment;


public class EmptyLedger {
	private Class<? extends Exception> exceptionType;

	public EmptyLedger() {
		Context.ledger = new Ledger();
	}
	
	public String generateStatement() {
		return Context.ledger.statement();
	}
	
	public void depositThisManyTimes(int depositAmount, int numberOfDeposits) {
		for (int i=0; i < numberOfDeposits; i++) {
			Context.ledger.deposit(new Deposit(depositAmount));
		}
	}
	
	public int balance() {
		return Context.ledger.getBalance();
	}
	
	public void makePaymentAndCatchException(int paymentAmount) {
		try {
			Context.ledger.pay(new Payment(paymentAmount, "Anyone"));
		}
		catch (Exception e) {
			exceptionType = e.getClass();
		}
	}
	
	public boolean depositCentsOn(int amount, String depositDate) {
		Context.ledger.deposit(new Deposit(amount));
		return true;
	}
	
	public boolean payCentsToOn(int amount, String payee, String date) {
		Context.ledger.pay(new Payment(amount, payee));
		return true;
	}
	
	public boolean save() {
		Context.ledger.save();
		return true;
	}
	
	public boolean load() {
		Context.ledger = Ledger.load();
		return true;
	}
	
	public String exceptionClass() {
		if (exceptionType == null)
			return "No exception caught";
		return exceptionType.toString();
	}
}
