package ledjer;

public class Payment extends Transaction {
	private String payee;
	
	public Payment(int amount, String payee) {
		super(amount);
		this.payee = payee;
	}
	
	public String getPayee() {
		return payee;
	}
	
	@Override
	public String asStatement() {
		return "Payment to " + getPayee() + ": (" + formattedAmount(getAmount()) +")" + Transaction.newLine();
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Payment))
			return false;
		return (this.getAmount() == ((Payment) object).getAmount() && this.getPayee() == ((Payment) object).getPayee());
	}
	
	@Override
	public Payment clone() {
		return new Payment(getAmount(), payee);
	}
}