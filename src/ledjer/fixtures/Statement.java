package ledjer.fixtures;

import java.util.ArrayList;
import java.util.List;

public class Statement {

	public Statement() {
	}
	
	public List<Object> query() {
		// Hint: query the Context.ledger for the statement
		// The statement should contain one deposit per line
		// Separate each deposit (and the total) with a new line
		// A good regex for splitting on newlines is "\\r?\\n"
		List<Object> list = new ArrayList<Object>();
		return list;
	}
}