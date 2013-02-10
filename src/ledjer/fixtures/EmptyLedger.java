package ledjer.fixtures;

import ledjer.Ledger;

public class EmptyLedger {

	public EmptyLedger() {
		Context.ledger = new Ledger();
	}
}