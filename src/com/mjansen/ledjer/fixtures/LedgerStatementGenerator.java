package com.mjansen.ledjer.fixtures;

import com.mjansen.ledjer.Ledger;


public class LedgerStatementGenerator {
	public LedgerStatementGenerator(int beginningBalance) {
		Context.ledger = new Ledger();
	}
	
	public String generateStatement() {
		return Context.ledger.statement();
	}
}
