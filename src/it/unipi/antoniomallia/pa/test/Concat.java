package it.unipi.antoniomallia.pa.test;

import it.unipi.antoniomallia.pa.model.Row;
import it.unipi.antoniomallia.pa.sft.ColumnFixture;
import it.unipi.antoniomallia.pa.sft.TypeAdapter;

public class Concat extends ColumnFixture {
	public String x;
	public String y;

	public String result() {
		return x.concat(y);
	}

	public boolean check(Row row) {
		x = (String) TypeAdapter.convertTo(row.cells.get(0).text, "String");
		y = (String) TypeAdapter.convertTo(row.cells.get(1).text, "String");
		Object result = (Object) result();
		row.cells.get(row.cells.size() - 1).text = (result).toString();
		return ((result).equals(TypeAdapter.convertTo(
				row.cells.get(row.cells.size() - 1).text, "String")));

	}
}
