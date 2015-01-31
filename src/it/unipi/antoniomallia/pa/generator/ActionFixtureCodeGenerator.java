package it.unipi.antoniomallia.pa.generator;

import it.unipi.antoniomallia.pa.model.Row;
import it.unipi.antoniomallia.pa.model.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ActionFixtureCodeGenerator extends CodeGenerator {
	public String generateClass(Table table) {
		StringBuffer sb = new StringBuffer();
		String checkFunction = new String();
		Stack<String> stack = new Stack<String>();
		sb.append(String.format("public class %s extends ActionFixture {\n\t",
				table.rows.get(0).cells.get(0).text));
		sb.append("public boolean process() {\n");
		for (Row row : table.rows) {
			StringBuffer arguments = new StringBuffer();
			for (int i = 3; i < row.cells.size(); i++) {
				if (!row.cells.get(i).text.equals("")) {
					arguments
							.append(String.format("%s", row.cells.get(i).text));
					if (i != row.cells.size() - 1) {
						arguments.append(", ");
					}
				}
			}
			switch (row.cells.get(0).text) {
			case "start":
				stack.push(String.format("%s %s = new %s()",
						row.cells.get(1).text, row.cells.get(2).text,
						row.cells.get(1).text));
				break;
			case "call":
				if (row.cells.get(1).text.equals("")) {
					stack.push(String.format("%s(%s)", row.cells.get(2).text,
							arguments.toString()));
				} else {
					stack.push(String.format("%s.%s(%s)",
							row.cells.get(1).text, row.cells.get(2).text,
							arguments.toString()));
				}
				break;
			case "result":
				if (!arguments.toString().equals("")) {
					arguments.insert(0, String.format("%s, ", stack.pop()));
				} else {
					arguments.append(stack.pop());
				}
				if (row.cells.get(1).text.equals("")) {
					stack.push(String.format("%s(%s)", row.cells.get(2).text,
							arguments.toString()));
				} else {
					stack.push(String.format("%s.%s(%s)",
							row.cells.get(1).text, row.cells.get(2).text,
							arguments.toString()));
				}
				break;
			case "check":
				checkFunction = String
						.format("private <T> boolean check(T t){\n\t\treturn t.equals(%s);\n\t}",
								row.cells.get(1).text);
				stack.push(String.format("return check(%s)", stack.pop()));
				break;
			default:
				break;
			}
		}
		List<String> reversed = new ArrayList<String>(stack);
		for (String statement : reversed) {
			sb.append("\t\t" + statement + ";\n");
		}
		sb.append("\t}\n\t");
		sb.append(checkFunction);
		sb.append("\n}");
		return sb.toString();
	}
}
