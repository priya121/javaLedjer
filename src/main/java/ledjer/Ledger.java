package ledjer;

public class Ledger {

    private int balance;
    private Deposit deposit;
    private Payment payment;
    private int amount;

    public Ledger(Deposit deposit) {
        this.deposit = new Deposit(100);
        this.payment = new Payment(0, "Amazon");
    }

    public int getBalance() {
        deposit(deposit);
        payment(payment);
        return balance;
    }

    public void deposit(Deposit deposit) {
        balance = balance + this.deposit.getAmount();
    }

    public void payment(Payment payment) {
        payment.payment();
        balance = balance - this.payment.getPaymentTotal();
    }

    public String poundConverter(int balance) {
        int conversion = balance / 100;
        return "£" + conversion + ".00";
    }

    public String statement() {
        int initialDeposit = deposit.getAmount();
        deposit.makeDeposit();
        int secondDeposit = deposit.getAmount();
        return "Deposit: " + poundConverter(initialDeposit) + "\nDeposit: " + poundConverter(secondDeposit) + "\nTotal: " + poundConverter(initialDeposit + secondDeposit);
    }

}