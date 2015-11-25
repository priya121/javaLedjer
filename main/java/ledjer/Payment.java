package ledjer;

public class Payment {
    private int amount;
    private String customer;

    public Payment(int amount, String customer) {
        this.amount = amount;
        this.customer = customer;
    }

    public void payment() {
        amount -= amount;
    }

    public int getPaymentTotal() {
        return amount;
    }
}
