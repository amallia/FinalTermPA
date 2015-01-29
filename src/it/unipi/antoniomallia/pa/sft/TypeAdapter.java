package it.unipi.antoniomallia.pa.sft;

public class TypeAdapter {
	public static Object convertTo(String s, String type) {
		switch (type) {
		case "float":
			return new Float(s).floatValue();
		case "byte":
			return new Byte(s).byteValue();
		case "short":
			return new Short(s).shortValue();
		case "int":
			return new Integer(s).intValue();
		case "long":
			return new Long(s).longValue();
		case "double":
			return new Double(s).doubleValue();
		case "char":
			return s.charAt(0);
		case "boolean":
			return new Boolean(s).booleanValue();
		default:
			return s;
		}
	}
}
