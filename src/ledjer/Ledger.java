package ledjer;

public class Ledger {

	private static final int MAX_NUMBER_OF_DEPOSITS = 10;
	private Deposit[] deposits;
	private int depositCount;
	private Payment[] payments;
	private int paymentCount;
	
	public Ledger() {
		deposits = new Deposit[10];
		depositCount = 0;
		payments = new Payment[10];
		paymentCount = 0;
	}
	
	public int getBalance() {
		int balance = 0;
		for (int i=0; i < depositCount; i++)
			balance += deposits[i].getAmount();
		for (int i=0; i < paymentCount; i++)
			balance -= payments[i].getAmount();
		return balance;
	}

	public void deposit(Deposit deposit) {
		if (depositCount < MAX_NUMBER_OF_DEPOSITS)
			deposits[depositCount++] = deposit;
	}
	

	public void payment(Payment payment) {
		payments[paymentCount++] = payment;	
	}
	
	public String statement() {
		return formatDeposits() + formatPayments() + formatTotal();
	}
	
	private String formatDeposits() {
		String statement = "";
		for (int i=0; i < depositCount; i++)
			statement += formatDeposit(deposits[i]);
		return statement;
	}
	
	private String formatPayments() {
		String statement = "";
		for (int i=0; i < paymentCount; i++)
			statement += formatPayment(payments[i]);
		return statement;
	}
	
	private String formatDeposit(Deposit deposit) {
		return "Deposit " + formattedAmount(deposit.getAmount()) +"\\n";
	}
	
	private String formatPayment(Payment payment) {
		return "Payment to " + payment.getPayee() + " (" + formattedAmount(payment.getAmount()) +")\\n";
	}
	
	private String formatTotal() {
		return "Total " + formattedAmount(getBalance());
	}
	private String formattedAmount(int amount) {
		int dollar = amount / 100;
		int cents = amount % 100;
		return String.format("$%1d.%02d", dollar, cents);
	}

}