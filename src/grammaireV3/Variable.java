package grammaireV3;

public class Variable {
	private Type type;
	private Object val;
	private String nom;
	private boolean constant = false;
	
	public Variable(String type, String nom) {
		this.type = Type.fromString(type);
		this.nom = nom;
	}
	
	public Object getVal() {
		return val;
	}
	
	
	public void setVal(String o) throws ParseException {
		if (constant)
			throw new ParseException("Attempted to modify a constant");
		try {
		switch (type) {
		  case INT:
			  this.val = Integer.parseInt(o);
			  break;
		  case FLOAT:
			  this.val = Float.parseFloat(o);
			  break;
		  case STRING:
			  this.val = o;
			  break;
		  case BOOL:
			  this.val = Boolean.parseBoolean(o); 
		  }
		} catch(NumberFormatException e) {
			throw new ParseException("incorrect type for variable "+nom+" expecting "+type+" got "+o);
		}
	}
	
	public void setVal(Object o) throws ParseException {
		if (constant)
			throw new ParseException("Attempted to modify a constant");
		switch (type) {
		  case INT:
			  if (!(o instanceof Integer)) throw new ParseException("Incorrect type for "+nom+" expected int");
			  break;
		  case FLOAT:
			  if (!(o instanceof Float)) throw new ParseException("Incorrect type for "+nom+" expected float");
			  break;
		  case STRING:
			  if (!(o instanceof String)) throw new ParseException("Incorrect type for "+nom+" expected string");
			  break;
		  case BOOL:
			  if (!(o instanceof Boolean)) throw new ParseException("Incorrect type for "+nom+" expected bool");
		  }
		this.val = o;
	}
	
	public String getName() {
		return nom;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setConstant() {
		constant = true;
	}
	
	public String toString() {
		return type+" "+val;
	}
}
