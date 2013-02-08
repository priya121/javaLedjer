package ledjer;

import java.util.LinkedList;
import java.util.List;

public class Ledger {

	private int balance;
	private List<Transaction> transactions;
	
	public Ledger() {
		balance = 0;
		transactions = new LinkedList<Transaction>();
	}
	
	public int getBalance() {
		return balance;
	}

	public void deposit(Transaction deposit) {
		balance += deposit.getAmount();
		addTransaction(deposit);
	}

	public void pay(Transaction payment) {
		checkForAvailableFunds(payment);
		balance -= payment.getAmount();
		addTransaction(payment);
	}

	public String statement() {
		String statement = "";
		for (Transaction transaction : transactions) {
			statement += transaction.asStatement();
		}
		statement += formatTotal();
		return statement;
	}
	
	private void checkForAvailableFunds(Transaction payment) {
		if (balance - payment.getAmount() < 0) {
			throw new NegativeBalanceException();
		}
	}
	
	private void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	
	private String formatTotal() {
		return "Total: " + Transaction.formattedAmount(getBalance());
	}
}