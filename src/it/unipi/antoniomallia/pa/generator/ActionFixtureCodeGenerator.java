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
			switch (row.cells.get(0).text) {
			case "start":
				stack.push(String.format("%s %s = new %s()",
						row.cells.get(1).text, row.cells.get(2).text,
						row.cells.get(1).text));
				break;
			case "call":
				if (row.cells.get(1).text.equals("")) {
					stack.push(String.format("%s(%s, %s)",
							row.cells.get(2).text, row.cells.get(3).text,
							row.cells.get(4).text));
				} else {
					stack.push(String.format("%s.%s()", row.cells.get(1).text,
							row.cells.get(2).text));
				}
				break;
			case "result":
				if (row.cells.get(1).text.equals("")) {
					stack.push(String.format("%s(%s)", row.cells.get(2).text,
							stack.pop()));
				} else {
					stack.push(String.format("%s.%s(%s)",
							row.cells.get(1).text, row.cells.get(2).text,
							stack.pop()));
				}
				break;
			case "check":
				checkFunction = String
						.format("private boolean check(Object obj){\n\t\treturn obj.equals(%s);\n\t}",
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
