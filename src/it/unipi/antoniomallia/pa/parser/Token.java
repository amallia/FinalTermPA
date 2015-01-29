package it.unipi.antoniomallia.pa.parser;

public class Token {
	public enum TokenType {
		OPEN_TABLE, CLOSE_TABLE, OPEN_ROW, CLOSE_ROW, OPEN_COLUMN, CLOSE_COLUMN, CELL, EOF;
	}
	public TokenType tokenType;
	public String value;
	public Token(TokenType tokenType, String value) {
		this.tokenType = tokenType;
		this.value = value;
	}
	public Token(TokenType tokenType) {
		this.tokenType = tokenType;
		this.value = null;
	}
	public boolean isType(TokenType tokenType) {
		return this.tokenType.equals(tokenType);
	}

}
