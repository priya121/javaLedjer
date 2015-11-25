package ledjer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LedgerTest {
    private Ledger ledger;
    private Deposit deposit = new Deposit(100);


    @Before
    public void setup() {
        ledger = new Ledger(deposit);
    }

    @Test
    public void deleteMe() {
        assertEquals(true, true);
    }

    @Test
    public void makesDeposit() {
        ledger.deposit(new Deposit(100));
        assertEquals(100, ledger.getBalance());
    }

    @Test
    public void convertsToPounds() {
        assertEquals("£1.00", ledger.poundConverter(100));
    }

    @Test
    public void printsStatement() {
        assertEquals(ledger.statement(), "Deposit: £1.00\nDeposit: £2.00\nTotal: £3.00");
    }

}