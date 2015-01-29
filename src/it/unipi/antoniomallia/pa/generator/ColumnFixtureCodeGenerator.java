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
				.append(String.format("public %s %s {\n\t}\n\t",
						table.rows.get(2).cells.get(table.rows.get(1).cells
								.size() - 1).text, table.rows.get(1).cells
								.get(table.rows.get(1).cells.size() - 1).text));
		stringBuffer.append("public boolean check(Row row){\n\t\t");
		for (int i = 0; i < table.rows.get(1).cells.size() - 1; i++) {
			stringBuffer
					.append(String
							.format("%s = (%s) TypeAdapter.convertTo(row.cells.get(%d).text, \"%s\");\n\t\t",
									table.rows.get(1).cells.get(i).text,
									table.rows.get(2).cells.get(i).text, i,
									table.rows.get(2).cells.get(i).text));
		}
		stringBuffer.append(String
				.format("Object result = (Object) %s;\n\t\t",
						table.rows.get(1).cells.get(table.rows.get(1).cells
								.size() - 1).text));
		stringBuffer
				.append(String
						.format("boolean check = result.equals(TypeAdapter.convertTo(row.cells.get(row.cells.size() - 1).text, \"%s\"));\n\t\t",
								table.rows.get(2).cells.get(table.rows.get(1).cells
										.size() - 1).text));

		stringBuffer
				.append("row.cells.get(row.cells.size() - 1).text= (result).toString();\n\t\treturn check;");
		stringBuffer.append("\n\t}\n}");
		return stringBuffer.toString();
	}
}
