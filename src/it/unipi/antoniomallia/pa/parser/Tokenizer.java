package it.unipi.antoniomallia.pa.parser;

import it.unipi.antoniomallia.pa.parser.Token.TokenType;

import java.util.StringTokenizer;

public class Tokenizer {

	public Token token;
	public StringTokenizer st;

	public Tokenizer(String input) {
		st = new StringTokenizer(input, "<>\t\n\r");
	}

	public Token nextToken() {
		String next = new String();
		if (st.hasMoreTokens()) {
			next = st.nextToken();
			switch (next) {
			case "table":
				token = new Token(TokenType.OPEN_TABLE);
				break;
			case "/table":
				token = new Token(TokenType.CLOSE_TABLE);
				break;
			case "tr":
				token = new Token(TokenType.OPEN_ROW);
				break;
			case "/tr":
				token = new Token(TokenType.CLOSE_ROW);
				break;
			case "td":
				token = new Token(TokenType.OPEN_COLUMN);
				break;
			case "/td":
				token = new Token(TokenType.CLOSE_COLUMN);
				break;
			default:
				token = new Token(TokenType.CELL, next);
				break;
			}
		} else {
			token = new Token(TokenType.EOF);
		}
		return token;
	}
}
