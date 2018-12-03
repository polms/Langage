/* Generated By:JJTree: Do not edit this line. ASTparam.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=MyNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package grammaireV3;

public
class ASTparam extends SimpleNode {
  public ASTparam(int id) {
    super(id);
  }

  public ASTparam(Lang p, int id) {
    super(p, id);
  }

  public void run() throws Exception {
	  assert this.jjtGetNumChildren() == 2;
	  String type = (String)((SimpleNode)this.children[0]).value;
	  String nom = (String)((SimpleNode)this.children[1]).value;
	  Object valeur = MyNode.pop();
	  
	  Variable v = new Variable(type, nom);
	  
	  v.setVal(valeur);
	  
	  if (get_context_here().containsKey(nom))
		  throw new Exception("Redefinition of "+nom);
	  get_context_here().put(nom, v);
  }
}
/* JavaCC - OriginalChecksum=875a1ce2085b5371047a8e6d8bc3e1b5 (do not edit this line) */