package it.unipi.antoniomallia.pa.parser;

import it.unipi.antoniomallia.pa.model.Cell;
import it.unipi.antoniomallia.pa.model.Row;
import it.unipi.antoniomallia.pa.model.Table;
import it.unipi.antoniomallia.pa.parser.Token.TokenType;

public class Parser {
	private Tokenizer tokenizer;
	private Token token;
	private int columnNumber = 0;
	public Parser(String s) throws Throwable {
		tokenizer = new Tokenizer(s);
		token = tokenizer.nextToken();
	}
	public Table doTable() throws Throwable {
		Table table = new Table();
		expect(TokenType.OPEN_TABLE);
		table.rows.add(doHeader());
		while (token.isType(TokenType.OPEN_ROW)) {
			table.rows.add(doRow());
		}
		expect(TokenType.CLOSE_TABLE);
		expect(TokenType.EOF);
		return table;
	}
	private Row doRow() throws Throwable {
		Row row = new Row();
		expect(TokenType.OPEN_ROW);
		int c = 0;
		while (token.isType(TokenType.OPEN_COLUMN)) {
			row.cells.add(doCell());
			c++;
		}
		if (columnNumber > 0) {
			if (columnNumber != c) {
				throw new SyntaxException("Il numero di celle non corrisponde");
			}
		} else {
			columnNumber = c;
		}
		expect(TokenType.CLOSE_ROW);
		return row;
	}
	private Cell doCell() throws Throwable {
		Cell cell;
		expect(TokenType.OPEN_COLUMN);
		if (token.value != null) {
			cell = new Cell(token.value);
			expect(TokenType.CELL);
		} else {
			cell = new Cell("");
		}
		expect(TokenType.CLOSE_COLUMN);
		return cell;
	}
	public Row doHeader() throws Throwable {
		Row row = new Row();
		expect(TokenType.OPEN_ROW);
		expect(TokenType.OPEN_COLUMN);
		Cell cell = new Cell(token.value);
		row.cells.add(cell);
		expect(TokenType.CELL);
		expect(TokenType.CLOSE_COLUMN);
		expect(TokenType.CLOSE_ROW);
		return row;
	}
	private void expect(TokenType tokenType) throws Throwable {
		if (!token.isType(tokenType)) {
			throw new SyntaxException("Expected: " + tokenType + " Obtained: "
					+ token);
		}
		token = tokenizer.nextToken();
	}
}
