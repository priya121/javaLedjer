package ledjer;

public class Deposit extends Transaction implements Cloneable {
	public Deposit(int amount) {
		super(amount);
	}
	
	@Override
	public String asStatement() {
		return "Deposit: " + formattedAmount(getAmount()) + newLine();
	}
	
	@Override
	public Deposit clone() {
		return new Deposit(getAmount());
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Deposit))
			return false;
		return (this.getAmount() == ((Deposit) object).getAmount());
	}
}