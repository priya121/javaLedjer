package ledjer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;

import org.junit.Before;
import org.junit.Test;

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
		ledger.deposit(new Deposit(100));
		assertEquals(100, ledger.getBalance());
	}
	
	@Test
	public void paymentSubtractsFromBalance() {
		Transaction deposit = new Deposit(100);
		Payment payment = new Payment(50, "foo");
		ledger.deposit(deposit);
		ledger.pay(payment);
		assertEquals(50, ledger.getBalance());
	}
	
	@Test
	public void statementIncludesDepositHistory() {
		String newLine = System.getProperty("line.separator");
		ledger.deposit(new Deposit(110));
		ledger.deposit(new Deposit(200));
		String expectedStatement = "Deposit: $1.10" + newLine + "Deposit: $2.00" + newLine + "Total: $3.10";
		assertEquals(expectedStatement, ledger.statement());
	}
	
	@Test
	public void statementIncludesPaymentsAndDepositsHistory() {
		ledger.deposit(new Deposit(1000));
		ledger.pay(new Payment(500, "foo"));
		ledger.pay(new Payment(100, "bar"));

		String expectedStatement = "Deposit: $10.00" + Transaction.newLine() + 
								   "Payment to foo: ($5.00)" + Transaction.newLine() +
								   "Payment to bar: ($1.00)" + Transaction.newLine() +
								   "Total: $4.00";
		assertEquals(expectedStatement, ledger.statement());
	}
	
	@Test(expected = NegativeBalanceException.class)
	public void doesNotAllowNegativeBalance() {
		ledger.pay(new Payment(1, "payee"));
	}
	
    @Test
    public void emptyLedgersAreEqual() {
        assertEquals(ledger, new Ledger());
    }
    
    @Test
    public void equalityBasedOnInstanceOfTarget() {
        assertFalse(ledger.equals(new Object()));
    }
    
  @Test
  public void ledgersNotEqualIfNumberOfTransactionsDifferent() {
      Ledger ledgerTwo = new Ledger();
      ledger.deposit(new Deposit(100));
      assertFalse(ledger.equals(ledgerTwo));
  }
 
  @Test
  public void ledgersNotEqualIfTransactionsAreNotEqual() {
	  Deposit deposit = new Deposit(200);
      Payment paymentOne = new Payment(100, "foo");
      Payment paymentTwo = new Payment(100, "bar");
	  Ledger ledgerTwo = new Ledger();
      ledger.deposit(deposit);
      ledgerTwo.deposit(deposit);
      ledger.pay(paymentOne);
      ledgerTwo.pay(paymentTwo);
      
      assertFalse(ledger.equals(ledgerTwo));
  }
  
  @Test
  public void ledgersAreEqualIfTransactionHistoryIsEqual() {
	  Deposit deposit = new Deposit(400);
      Payment paymentOne = new Payment(100, "foo");
      Payment paymentTwo = new Payment(100, "bar");
	  Ledger ledgerTwo = new Ledger();
      ledger.deposit(deposit);
      ledgerTwo.deposit(deposit);
      ledger.pay(paymentOne);
      ledger.pay(paymentTwo);
      ledgerTwo.pay(paymentOne);
      ledgerTwo.pay(paymentTwo);
      
      assertEquals(ledger, ledgerTwo);
  }
  
  @Test
  public void transactionsAndBalanceClonedWhenCloningLedgers() throws CloneNotSupportedException {
	  Deposit deposit = new Deposit(400);
      Payment paymentOne = new Payment(100, "foo");
      Payment paymentTwo = new Payment(100, "bar");
      ledger.deposit(deposit);
      ledger.pay(paymentOne);
      ledger.pay(paymentTwo);
      
      assertEquals(ledger.getBalance(), ledger.clone().getBalance());
      assertEquals(ledger, ledger.clone());
      assertNotSame(ledger, ledger.clone());
  }
}