package it.unipi.antoniomallia.pa.generator;

import it.unipi.antoniomallia.pa.model.Table;

public class ColumnFixtureCodeGenerator implements CodeGenerator {

	public String generateClass(Table table) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(String.format(
				"public class %s extends ColumnFixture {\n\t",
				table.rows.get(0).cells.get(0).text));
		for (int i = 0; i < table.rows.get(1).cells.size() - 1; i++) {
			stringBuffer.append(String.format("public %s %s;\n\t",
					table.rows.get(2).cells.get(i).text,
					table.rows.get(1).cells.get(i).text));
		}
		stringBuffer
				.append(String.format("public %s %s {\n\t}\n\t",
						table.rows.get(1).cells.get(table.rows.get(1).cells
								.size() - 1).text, table.rows.get(0).cells
								.get(table.rows.get(0).cells.size() - 1).text));
		stringBuffer.append("public boolean check(Row row){\n\t\t");
		for (int i = 0; i < table.rows.get(0).cells.size() - 1; i++) {
			stringBuffer.append(String.format(
					"%s = (%s) row.getCell(%d);\n\t\t",
					table.rows.get(0).cells.get(i).text,
					table.rows.get(1).cells.get(i).text, i));
		}
		stringBuffer
				.append(String
						.format("if(%s==(float)row.getCell(row.getSize()-1))\n\t\t\treturn true;\n\t\treturn false;\n\t\t",
								table.rows.get(0).cells.get(table.rows.get(0).cells
										.size() - 1).text));
		stringBuffer.append("\n\t}\n}");
		return stringBuffer.toString();
	}

	public String generateTest(Table table) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(String.format("%s %s = new %s();\n",
				table.rows.get(0).cells.get(0).text,
				table.rows.get(0).cells.get(0).text.toLowerCase(),
				table.rows.get(0).cells.get(0).text));
		stringBuffer.append(String.format("table.execute(%s);\n",
				table.rows.get(0).cells.get(0).text.toLowerCase()));
		return stringBuffer.toString();
	}
}
