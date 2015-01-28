package it.unipi.antoniomallia.pa.model;

import it.unipi.antoniomallia.pa.generator.IHTMLGenerator;

public class Cell implements HTMLTag {
	public enum Colour {
		NONE, GREEN, RED;
	}

	public String text;
	public Colour colour;

	public Cell(String text) {
		this(text, Colour.NONE);
	}

	public Cell(String text, Colour colour) {
		this.text = text;
		this.colour = colour;
	}

	@Override
	public String toHTML(IHTMLGenerator htmlGen) {
		return htmlGen.toHTML(this);
	}
}
