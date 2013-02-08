package ledjer.fixtures;

import ledjer.Ledger;
import ledjer.Payment;


public class LedgerStatementGenerator {
	private Class<? extends Exception> exceptionType;

	public LedgerStatementGenerator() {
		Context.ledger = new Ledger();
	}
	
	public String generateStatement() {
		return Context.ledger.statement();
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
