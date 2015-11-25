package ledjer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepositTest {
	
	@Test 
	public void hasAmount() {
		Deposit deposit = new Deposit(100);
		assertEquals(100, deposit.getAmount());
	}

	@Test
	public void paymentToAmazon() {
		Deposit deposit = new Deposit(100);
		Ledger ledger = new Ledger(deposit);
		deposit.makeDeposit();
		assertEquals(100, ledger.getBalance());
	}
}