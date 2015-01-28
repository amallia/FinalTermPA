package it.unipi.antoniomallia.pa.sft;

import it.unipi.antoniomallia.pa.generator.HTMLGenerator;
import it.unipi.antoniomallia.pa.model.Cell.Colour;
import it.unipi.antoniomallia.pa.model.Row;
import it.unipi.antoniomallia.pa.model.Table;

public abstract class ColumnFixture implements Fixture {
	private final static int DATA_START_ROW = 3;

	public abstract boolean check(Row row);

	@Override
	public String execute(Table table) {
		for (int i = DATA_START_ROW; i < table.rows.size(); i++) {
			if (check(table.rows.get(i))) {
				table.rows.get(i).cells.get(table.rows.get(i).cells.size()-1).colour = Colour.GREEN;
			} else {
				table.rows.get(i).cells.get(table.rows.get(i).cells.size()-1).colour = Colour.RED;
			}
		}
		// Execute tests and adjust the table
		// Convert the table to htmlTable
		return table.toHTML(new HTMLGenerator());
	}
}
