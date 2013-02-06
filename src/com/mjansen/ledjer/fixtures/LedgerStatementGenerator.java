package com.mjansen.ledjer.fixtures;


public class LedgerStatementGenerator {
	public void resetLedger() {
		Context.reset();
	}
	
	public String generateStatement() {
		return Context.ledger.statement();
	}
}
