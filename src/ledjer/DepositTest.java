package ledjer;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class DepositTest {
	@Test
	public void holdsAnAmount() {
		Deposit deposit = new Deposit(1000);
		assertEquals(1000, deposit.getAmount());
	}
	
	@Test
	public void createsStatement() {
		Transaction.resetNextNumber();
		Calendar cal = new GregorianCalendar();
		Date today = cal.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Deposit deposit = new Deposit(2000);
		assertEquals(format.format(today) + " #1 Deposit: $20.00" + Transaction.newLine(), deposit.asStatement());
	}
	
	@Test
	public void implementsCloneable() {
		Deposit deposit = new Deposit(3000);
		Deposit clone = deposit.clone();
		assertEquals(deposit.getClass(), clone.getClass());
		assertEquals(deposit.getAmount(), clone.getAmount());
	}
	
	@Test
	public void depositsWithEqualAmountsAreEqual() {
		Deposit deposit = new Deposit(3000);
		Deposit depositTwo = new Deposit(3000);
		
		assertEquals(deposit, depositTwo);
	}
	
	@Test
	public void depositsWithDifferentAmountsAreNotEqual() {
		Deposit deposit = new Deposit(3000);
		Deposit depositTwo = new Deposit(4000);
		
		assertFalse(deposit.equals(depositTwo));
	}
	
	@Test
	public void depositsAreNotEqualToPaymentsOfEqualAmount() {
		Deposit deposit = new Deposit(3000);
		Payment payment = new Payment(3000, "foo");
		assertFalse(deposit.equals(payment));
	}
	
	@Test
	public void clonesAreEqualToTheOriginal() {
		Deposit deposit = new Deposit(3000);
		Deposit clone = deposit.clone();
		
		assertEquals(deposit, clone);
	}
	
}
