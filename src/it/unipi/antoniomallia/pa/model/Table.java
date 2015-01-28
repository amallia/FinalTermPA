package it.unipi.antoniomallia.pa.model;

import it.unipi.antoniomallia.pa.generator.CodeGenerator;
import it.unipi.antoniomallia.pa.generator.IHTMLGenerator;
import it.unipi.antoniomallia.pa.sft.Fixture;

import java.util.ArrayList;
import java.util.List;

public class Table implements HTMLTag {

	public List<Row> rows = new ArrayList<Row>();

	public String execute(Fixture f) {
		return f.execute(this);
	}

	public String generateClass(CodeGenerator cg) {
		return cg.generateClass(this);
	}

	@Override
	public String toHTML(IHTMLGenerator htmlGen) {
		return htmlGen.toHTML(this);
	}

}
