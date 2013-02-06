package ledjer.fixtures;

import ledjer.Ledger;


public class LedgerStatementGenerator {
	public LedgerStatementGenerator() {
		Context.ledger = new Ledger();
	}
	
	public String generateStatement() {
		return Context.ledger.statement();
	}
}
