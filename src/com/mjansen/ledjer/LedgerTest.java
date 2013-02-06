package com.mjansen.ledjer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

//EXERCISE - Ledger
//Part 1
//getBalance(), deposit(), statement(), max 10 trans
//Part 2
//pay()

public class LedgerTest {

	private Ledger ledger;
	
	@Before
	public void setup() {
		ledger = new Ledger();
	}
	
	@Test
	public void itStartsWithAZeroBalance() {
		assertEquals(0, ledger.getBalance());
	}

	
	
	@Test
	public void depositAddsToBalance() {
		ledger.deposit(100); // 1 dollar
		assertEquals(100, ledger.getBalance());
	}

	@Test
	public void depositCreatesTransaction() {
		ledger.deposit(50);
		Transaction[] transactions = ledger.getTransactions();
		assertEquals(50, transactions[0].getAmount());
	}
}
