package ledjer;

public class Deposit extends Transaction {
	private static final long serialVersionUID = 1L;

	public Deposit(int amount) {
		super(amount);
	}
	
	@Override
	public String asStatement() {
		return this.number + ". Deposit: " + formattedAmount(getAmount()) + newLine();
	}
	
	@Override
	public Deposit clone() {
		return (Deposit) super.clone();
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Deposit))
			return false;
		return (this.getAmount() == ((Deposit) object).getAmount());
	}
}