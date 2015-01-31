package it.unipi.antoniomallia.pa.test;

import it.unipi.antoniomallia.pa.model.Row;
import it.unipi.antoniomallia.pa.sft.ColumnFixture;

public class Product extends ColumnFixture {
	public float x;
	public float y;
	public float result;

	public float result() {
		return x * y;
	}

	public boolean check(Row row) {
		x = (float) row.cells.get(0).convert(x);
		y = (float) row.cells.get(1).convert(y);
		float result = result();
		boolean check = row.cells.get(row.cells.size() - 1).convert(result)
				.equals(result);
		row.cells.get(row.cells.size() - 1).text = String.valueOf(result);
		return check;
	}
}
