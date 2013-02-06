package ledjer;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransactionTest {
	@Test
	public void constructsTransaction() {
		Transaction transaction = new Transaction(1000); // 10 dollar
		assertEquals(1000, transaction.getAmount());
	}
}
