package it.unipi.antoniomallia.pa.test;

import it.unipi.antoniomallia.pa.model.Row;
import it.unipi.antoniomallia.pa.sft.ColumnFixture;
import it.unipi.antoniomallia.pa.sft.TypeAdapter;

public class Product extends ColumnFixture {
	public float x;
	public float y;
	public float result() {
		return x;
	}
	public boolean check(Row row){
		x = (float) TypeAdapter.convertTo(row.cells.get(0).text, "float");
		y = (float) TypeAdapter.convertTo(row.cells.get(1).text, "float");
		Object result = (Object) result();
		boolean check = result.equals(TypeAdapter.convertTo(row.cells.get(row.cells.size() - 1).text, "float"));
		row.cells.get(row.cells.size() - 1).text= (result).toString();
		return check;
	}
}