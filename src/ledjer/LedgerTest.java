package ledjer;

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
	public void startsWithZeroBalance() {
		assertEquals(0, ledger.getBalance());
	}
	
	@Test
	public void depositAddsToBalance() {
		Deposit deposit = new Deposit(100);
		ledger.deposit(deposit); // 1 dollar
		assertEquals(100, ledger.getBalance());
	}
	
	@Test
	public void limitNumberOfDepositsToTen() {
		for (int i=0; i<11; i++)
			ledger.deposit(new Deposit(100));
		assertEquals(1000, ledger.getBalance());
	}
	
	@Test
	public void statementIncludesDepositHistory() {
		ledger.deposit(new Deposit(110));
		ledger.deposit(new Deposit(200));
		String expectedStatement = "Deposit $1.10\\nDeposit $2.00\\nTotal $3.10";
		assertEquals(expectedStatement, ledger.statement());
	}

}
