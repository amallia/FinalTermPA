package it.unipi.antoniomallia.pa.generator;

import it.unipi.antoniomallia.pa.model.Cell;
import it.unipi.antoniomallia.pa.model.Row;
import it.unipi.antoniomallia.pa.model.Table;

public class HTMLGenerator implements IHTMLGenerator {
	public String toHTML(Table table) {
		StringBuffer sb = new StringBuffer();
		sb.append("<table>\n");
		for (Row row : table.rows) {
			sb.append(row.toHTML(this));
		}
		sb.append("</table>\n");
		return sb.toString();
	}
	public String toHTML(Row row) {
		StringBuffer sb = new StringBuffer();
		sb.append("\t<tr>\n");
		for (Cell cell : row.cells) {
			sb.append(cell.toHTML(this));
		}
		sb.append("\t</tr>\n");
		return sb.toString();
	}
	public String toHTML(Cell cell) {
		StringBuffer sb = new StringBuffer();
		switch (cell.colour) {
		case GREEN:
			sb.append("\t\t<td bgcolor='green'>");
			break;
		case RED:
			sb.append("\t\t<td bgcolor='red'>");
			break;
		default:
			sb.append("\t\t<td>");
			break;
		}
		sb.append(cell.text);
		sb.append("</td>\n");
		return sb.toString();
	}
}
