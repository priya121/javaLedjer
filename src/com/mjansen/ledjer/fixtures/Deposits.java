package com.mjansen.ledjer.fixtures;

import com.mjansen.ledjer.Deposit;

public class Deposits {
	private Deposit deposit;
	
	public Deposits() {
	}
	
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
