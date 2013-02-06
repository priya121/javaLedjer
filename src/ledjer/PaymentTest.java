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

}