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
		assertEquals(1, transaction.getNumber());
	}
	
	@Test
	public void assignsNumbersSequentially() {
		Transaction t1 = new TestTransaction(10);
		Transaction t2 = new TestTransaction(10);
		Transaction t3 = new TestTransaction(10);
		assertEquals(2, t1.getNumber());
		assertEquals(3, t2.getNumber());
		assertEquals(4, t3.getNumber());
	}
	
}