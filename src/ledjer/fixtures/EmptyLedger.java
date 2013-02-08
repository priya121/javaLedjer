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
	
	public String exceptionClass() {
		if (exceptionType == null)
			return "No exception caught";
		return exceptionType.toString();
	}
}
