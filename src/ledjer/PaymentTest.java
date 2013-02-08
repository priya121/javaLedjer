package ledjer;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaymentTest {

	@Test
	public void holdsAnAmount() {
		Payment payment = new Payment(100, "foo");
		assertEquals(100, payment.getAmount());
	}
	
	@Test
	public void holdsAPayee() {
		Payment payment = new Payment(100, "foo");
		assertEquals("foo", payment.getPayee());
	}
	
	@Test
	public void createsStatement() {
		Payment payment = new Payment(200, "amazon.com");
		assertEquals("Payment to amazon.com: ($2.00)" + Transaction.newLine(), payment.asStatement());
	}
}