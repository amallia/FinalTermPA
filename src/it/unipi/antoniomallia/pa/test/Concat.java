package it.unipi.antoniomallia.pa.test;

import it.unipi.antoniomallia.pa.model.Row;
import it.unipi.antoniomallia.pa.sft.ColumnFixture;

public class Concat extends ColumnFixture {
	public String x;
	public String y;
	public String result;
	public String result() {
		return x.concat(y);
	}
	public boolean check(Row row){
		x = (String) row.cells.get(0).convert(x);
		y = (String) row.cells.get(1).convert(y);
		String result = result();
		boolean check = row.cells.get(row.cells.size() - 1).convert(result).equals(result);
		row.cells.get(row.cells.size() - 1).text= String.valueOf(result);
		return check;
	}
}
