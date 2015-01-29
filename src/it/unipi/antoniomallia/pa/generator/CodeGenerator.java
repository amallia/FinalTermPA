package it.unipi.antoniomallia.pa.generator;

import it.unipi.antoniomallia.pa.model.Table;

public abstract class CodeGenerator {
	public abstract String generateClass(Table table);
	public String generateTest(Table table) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("public static String test(Table table) {\n");
		stringBuffer.append(String.format("\t%s %s = new %s();\n",
				table.rows.get(0).cells.get(0).text,
				table.rows.get(0).cells.get(0).text.toLowerCase(),
				table.rows.get(0).cells.get(0).text));
		stringBuffer.append(String.format("\t return table.execute(%s);\n",
				table.rows.get(0).cells.get(0).text.toLowerCase()));
		stringBuffer.append("}");
		return stringBuffer.toString();
	}
}
