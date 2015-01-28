package it.unipi.antoniomallia.pa.model;

import it.unipi.antoniomallia.pa.generator.IHTMLGenerator;

import java.util.ArrayList;
import java.util.List;

public class Row implements HTMLTag {

	public List<Cell> cells = new ArrayList<Cell>();

	@Override
	public String toHTML(IHTMLGenerator htmlGen) {
		return htmlGen.toHTML(this);
	}

}
