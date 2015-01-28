package it.unipi.antoniomallia.pa.generator;

import it.unipi.antoniomallia.pa.model.Table;

public interface CodeGenerator {

	public String generateClass(Table table);
	
	public String generateTest(Table table);
	
}
