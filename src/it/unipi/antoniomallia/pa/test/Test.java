package it.unipi.antoniomallia.pa.test;

import it.unipi.antoniomallia.pa.generator.ColumnFixtureCodeGenerator;
import it.unipi.antoniomallia.pa.model.Table;
import it.unipi.antoniomallia.pa.parser.Parser;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {

	public static void main(String[] args) throws Throwable {
		String html = new String(Files.readAllBytes(Paths
				.get("resources/product.html")));
		Parser parser = new Parser(html);
		Table table = parser.doTable();
		System.out.println(table.generateClass(new ColumnFixtureCodeGenerator()));
		// System.out.println(table.toHTML(new HTMLGenerator()));
	}
}
