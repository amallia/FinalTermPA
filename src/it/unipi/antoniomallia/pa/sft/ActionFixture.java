package it.unipi.antoniomallia.pa.sft;

import it.unipi.antoniomallia.pa.generator.HTMLGenerator;
import it.unipi.antoniomallia.pa.model.Cell.Colour;
import it.unipi.antoniomallia.pa.model.Table;

public abstract class ActionFixture implements Fixture {

	public abstract boolean process();

	@Override
	public String execute(Table table) {
		if(process()){
			table.rows.get(table.rows.size()-1).cells.get(1).colour=Colour.GREEN;
		}else{
			table.rows.get(table.rows.size()-1).cells.get(1).colour=Colour.RED;
		}
		return table.toHTML(new HTMLGenerator());
	}
}
