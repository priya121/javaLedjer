package com.mjansen.ledjer;

public class Ledger {

	private Transaction[] transactions;
	private int transactionCount;
	
	public Ledger() {
		transactions = new Transaction[10];
		transactionCount = 0;
	}
	
	public int getBalance() {
		int balance = 0;
		for (int i=0; i < transactionCount; i++) {
			balance += transactions[i].getAmount();
		}
		return balance;
	}

	public void deposit(int amount) {
		transactions[transactionCount++] = new Transaction(amount);
	}

	public Transaction[] getTransactions() {
		return transactions;
	}
}
