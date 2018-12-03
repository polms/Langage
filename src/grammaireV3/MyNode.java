package grammaireV3;

import java.util.ArrayDeque;
import java.util.HashMap;

public class MyNode {
	  public static HashMap<String, Variable> symbols = new HashMap<>();
	  public static HashMap<String, SimpleNode> routinesTable = new HashMap<>();
	  
	  private static ArrayDeque<HashMap<String, Variable>> callStack = new ArrayDeque<>();
	  
	  private static ArrayDeque<Object> stack = new ArrayDeque<>();
	  
	  public static void push(Object o) {
		  stack.addFirst(o);;
	  }
	  
	  public static Object pop() throws ParseException {
		  if (stack.isEmpty())
			  throw new ParseException("Empty stack");
		  return stack.removeFirst();
	  }
	  
	  /**
	   * Create a new routine context and store it on the stack
	   */
	  public static void open_context() {
		  callStack.addFirst(new HashMap<String, Variable>());
	  }
	  
	  /**
	   * get the current routine context on the top of the call stack
	   * @return the context
	   */
	  public static HashMap<String, Variable> get_context() {
		  return callStack.getFirst();
	  }
	  
	  /**
	   * Remove the current context from the call stack
	   */
	  public static void close_context() {
		  callStack.removeFirst();
	  }
	  
	  /**
	   * Get the current context, global if not in a routine. 
	   * Local from the call stack it it is.
	   * @return the context
	   */
	  public HashMap<String, Variable> get_context_here() {
		  Boolean routine = false;
		  SimpleNode n = (SimpleNode)this;
		  while (n.id != LangTreeConstants.JJTSTART) {
			  if (n.id == LangTreeConstants.JJTPROCEDURE || n.id == LangTreeConstants.JJTFUNCTION)
				  routine = true;
			  n = (SimpleNode)n.parent;
		  }
		  
		  HashMap<String, Variable> sym;
		  if (routine) {
			  sym = MyNode.get_context();
		  } else {
			  sym = MyNode.symbols;
		  }
		  return sym;
	  }
	  
	  /**
	   * Compute the number of arguments needed for routine call
	  */ 
	  public static int nb_args(SimpleNode n) {
		  if (n.id == LangTreeConstants.JJTPROCEDURE)
			  return n.children[0].jjtGetNumChildren();
		  if (n.id == LangTreeConstants.JJTFUNCTION)
			  return n.children[1].jjtGetNumChildren();
		  return 0;
	  }
	  
	  public void run() throws Exception
	  {
	     throw new Exception("Unsuported operation "+this.getClass().getName()); 
	  }
}
