package ledjer;

public class Deposit {
    private int amount;

    public Deposit(int amount) {
        this.amount = amount;
    }

    public void makeDeposit() {
        amount = amount + amount;
    }

    public int getAmount() {
        return amount;
    }
}