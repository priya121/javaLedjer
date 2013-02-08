package ledjer;

import static org.junit.Assert.*;
import org.junit.Test;

public class DepositTest {
	@Test
	public void holdsAnAmount() {
		Deposit deposit = new Deposit(1000);
		assertEquals(1000, deposit.getAmount());
	}
	
	@Test
	public void createsStatement() {
		Deposit deposit = new Deposit(2000);
		assertEquals("Deposit: $20.00" + Transaction.newLine(), deposit.asStatement());
	}
}
