/* Generated By:JJTree: Do not edit this line. ASTconstant.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=MyNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package grammaireV3;

import java.util.HashMap;

public
class ASTconstant extends SimpleNode {
  public ASTconstant(int id) {
    super(id);
  }

  public ASTconstant(Lang p, int id) {
    super(p, id);
  }

  @Override
  public void run() throws Exception {
	  assert this.jjtGetNumChildren() == 3;
	  String type = (String)((SimpleNode)this.children[0]).value;
	  String nom = (String)((SimpleNode)this.children[1]).value;
	  Object valeur = ((SimpleNode)this.children[2]).value;
	  Variable v = new Variable(type, nom);
	  v.setVal((String)valeur);
	  v.setConstant();
	  
	  HashMap<String, Variable> frame;
	  if (((SimpleNode)((SimpleNode)((SimpleNode)parent).parent).parent) == null) { // programme principal
		  frame = MyNode.symbols;
	  } else { // routine
		  frame = MyNode.get_context();
	  }
	  if (frame.containsKey(nom))
		  throw new Exception("Redefinition of "+nom);
	  frame.put(nom, v);
  }
}
/* JavaCC - OriginalChecksum=d0002e374efb462f8d8f9639563299df (do not edit this line) */