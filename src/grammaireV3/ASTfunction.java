/* Generated By:JJTree: Do not edit this line. ASTfunction.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=MyNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package grammaireV3;

public
class ASTfunction extends SimpleNode {
  public ASTfunction(int id) {
    super(id);
  }

  public ASTfunction(Lang p, int id) {
    super(p, id);
  }

  public void run() throws Exception {
	  int num = this.jjtGetNumChildren();
	  
	  Type ret = Type.fromString((String)((SimpleNode)this.children[0]).value);
	  MyNode.open_context();
	  for (int i=1; i < num-1; i++)
		  ((MyNode)this.children[i]).run();

	  ((SimpleNode)this.children[num-1]).run();//get return value in the stack
	  //TODO: check type
	  MyNode.close_context();
  }
}
/* JavaCC - OriginalChecksum=76785dfc71478df0d60f772539249130 (do not edit this line) */
