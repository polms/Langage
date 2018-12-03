package grammaireV3;

public enum Type {
	INT, FLOAT, STRING, BOOL;
	
	public static Type fromString(String s) {
		switch (s) {
		case "int":
			return INT;
		case "float":
			return FLOAT;
		case "string":
			return STRING;
		case "boolean":
			return BOOL;
		}
		return null;
	}
}
