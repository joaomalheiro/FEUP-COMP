/* Generated By:JJTree: Do not edit this line. ASTtype.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTtype extends SimpleNode {
    public ASTtype(int id) {
        super(id);
    }

    public ASTtype(JmmParser p, int id) {
        super(p, id);
    }

    public String getType() {
        if (children.length == 1 && ((SimpleNode)children[0]).index != -1)
            return JmmParserConstants.tokenImage[((SimpleNode)children[0]).index].replaceAll("\"", "");
        
        if (children.length == 1)
            return ((SimpleNode)children[0]).name;
        
        return "int[]";
    }
}
/* JavaCC - OriginalChecksum=a2dced6f1e25a2ca4a7868febe7ee0ca (do not edit this line) */
