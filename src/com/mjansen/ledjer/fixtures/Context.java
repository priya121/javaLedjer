package com.mjansen.ledjer.fixtures;

import com.mjansen.ledjer.Ledger;

public class Context {
	public static Ledger ledger = new Ledger();
	public static void reset() {
		Context.ledger = new Ledger();
	}
}
