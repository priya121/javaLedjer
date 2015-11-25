package ledjer.features;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ledjer.Deposit;
import ledjer.Ledger;
import ledjer.Payment;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {
    private Ledger ledger;
    private Deposit deposit;
    private Payment payment;
    private int amount = 0;

    @Given("^an empty ledger$")
    public void anEmptyLedger() {
        ledger = new Ledger(new Deposit(0));
    }

    @When("^a deposit of (\\d+)p is made$")
    public void aDepositIsMade(int amount) {
        ledger.deposit(new Deposit(amount));
    }

    @Then("^the balance is (\\d+)p$")
    public void theBalanceIs(int expectedBalance) {
        assertThat(ledger.getBalance()).isEqualTo(expectedBalance);
    }

    @Then("^the statement contains$")
    public void theStatementContains(String expectedStatement) {
        assertThat(ledger.statement()).isEqualTo(expectedStatement);
    }

    @When("^a payment of (\\d+)p is made to Apple$")
    public void aPaymentToApple(int amount) {
        ledger.payment(new Payment(amount, "Apple"));
    }

    @When("^a payment of (\\d+)p is made to Amazon$")
    public void aPaymentToAmazon(int amount) {
        ledger.payment(new Payment(amount, "Amazon"));
    }

    @When("^a payment of (\\d+)p is made to BBC$")
    public void aPaymentToBBC(int amount) {
        ledger.payment(new Payment(amount, "BBC"));
    }
}
