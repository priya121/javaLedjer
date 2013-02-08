package ledjer;

public class Ledger {

	private int balance;
	private Transaction[] transactions;
	private int transactionCount;
	private static final int MAX_NUMBER_OF_TRANSACTIONS = 10;
	
	public Ledger() {
		balance = 0;
		transactionCount = 0;
		transactions = new Transaction[10];
	}
	
	public int getBalance() {
		return balance;
	}

	public void deposit(Transaction deposit) {
		if (canAddTransaction()) {
			balance += deposit.getAmount();
			addTransaction(deposit);
		}
	}

	public void pay(Transaction payment) {
		if (canAddTransaction()) {
			checkForAvailableFunds(payment);
			balance -= payment.getAmount();
			addTransaction(payment);
		}
	}

	public String statement() {
		String statement = "";
		for (int i=0; i < transactionCount; i++) {
			Transaction transaction = transactions[i];
			statement += transaction.asStatement();
		}
		statement += formatTotal();
		return statement;
	}
	
	private boolean canAddTransaction() {
		return transactionCount < MAX_NUMBER_OF_TRANSACTIONS;
	}
	
	private void checkForAvailableFunds(Transaction payment) {
		if (balance - payment.getAmount() < 0) {
			throw new NegativeBalanceException();
		}
	}
	
	private Transaction addTransaction(Transaction transaction) {
		return transactions[transactionCount++] = transaction;
	}
	
	private String formatTotal() {
		return "Total: " + Transaction.formattedAmount(getBalance());
	}
}