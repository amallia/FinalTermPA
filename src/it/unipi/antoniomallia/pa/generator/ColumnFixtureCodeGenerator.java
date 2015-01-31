package it.unipi.antoniomallia.pa.generator;

import it.unipi.antoniomallia.pa.model.Table;

public class ColumnFixtureCodeGenerator extends CodeGenerator {
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
				.append(String.format("public %s result;\n\t",
						table.rows.get(2).cells.get(table.rows.get(1).cells
								.size() - 1).text));
		stringBuffer
				.append(String.format("public %s %s {\n\t}\n\t",
						table.rows.get(2).cells.get(table.rows.get(1).cells
								.size() - 1).text, table.rows.get(1).cells
								.get(table.rows.get(1).cells.size() - 1).text));
		stringBuffer.append("public boolean check(Row row){\n\t\t");
		for (int i = 0; i < table.rows.get(1).cells.size() - 1; i++) {
			stringBuffer.append(String.format(
					"%s = (%s) row.cells.get(%d).convert(%s);\n\t\t",
					table.rows.get(1).cells.get(i).text,
					table.rows.get(2).cells.get(i).text, i,
					table.rows.get(1).cells.get(i).text));
		}
		stringBuffer
				.append(String.format("%s result = %s;\n\t\t",
						table.rows.get(2).cells.get(table.rows.get(1).cells
								.size() - 1).text, table.rows.get(1).cells
								.get(table.rows.get(1).cells.size() - 1).text));
		stringBuffer
				.append("boolean check = row.cells.get(row.cells.size() - 1).convert(result).equals(result);\n\t\t");

		stringBuffer
				.append("row.cells.get(row.cells.size() - 1).text= String.valueOf(result);\n\t\treturn check;");
		stringBuffer.append("\n\t}\n}");
		return stringBuffer.toString();
	}
}
