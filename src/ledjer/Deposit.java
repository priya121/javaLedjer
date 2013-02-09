package ledjer;

import java.text.SimpleDateFormat;

public class Deposit extends Transaction {
	public Deposit(int amount) {
		super(amount);
	}
	
	@Override
	public String asStatement() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		return format.format(getDate()) + " #" + getNumber() + " Deposit: " + formattedAmount(getAmount()) + newLine();
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