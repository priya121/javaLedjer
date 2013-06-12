package ledjer.fixtures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Statement {

	public Statement() {
	}
	
	public List<Object> query() {
		String statement = Context.ledger.statement();
		String[] rows = statement.split("\\r?\\n");
		List<Object> list = new ArrayList<Object>();

		for (String row : rows)	{
			List<Object> lineitem = new ArrayList<Object>();
			lineitem.add(Arrays.asList(new String[] {"lineitem", row}));
			list.add(lineitem);
		}
		return list;
	}
}