package ledjer;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransactionTest {
	private class TestTransaction extends Transaction {
		public TestTransaction(int amount) {
			super(amount);
		}
		@Override
		public String asStatement() {
			return null;
		}
	}
	
	@Test
	public void constructsTransaction() {
		Transaction transaction = new TestTransaction(1000);
		assertEquals(1000, transaction.getAmount());
	}
}