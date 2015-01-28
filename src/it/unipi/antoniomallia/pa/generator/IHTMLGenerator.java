package it.unipi.antoniomallia.pa.generator;

import it.unipi.antoniomallia.pa.model.Cell;
import it.unipi.antoniomallia.pa.model.Row;
import it.unipi.antoniomallia.pa.model.Table;

public interface IHTMLGenerator {

	public String toHTML(Table table);

	public String toHTML(Row row);

	public String toHTML(Cell cell);
}
