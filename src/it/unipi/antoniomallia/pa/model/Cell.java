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

	public String toHTML(IHTMLGenerator htmlGen) {
		return htmlGen.toHTML(this);
	}

	public  Integer convert(int i) {
		return new Integer(text);
	}

	public Long convert(long l) {
		return new Long(text);
		}

	public Double convert(double d) {
		return new Double(text);
	}

	public Float convert(float f) {
		return new Float(text);
	}

	public Boolean convert(boolean b) {
		return new Boolean(text);
	}

	public Byte convert(byte b) {
		return new Byte(text);
	}

	public Short convert(short s) {
		return new Short(text);
	}
	public String convert(String s){
		return text;
	}
}
