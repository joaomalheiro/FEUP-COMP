/* Generated By:JJTree: Do not edit this line. ASTclassDeclaration.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTclassDeclaration extends SimpleNode {
    public ASTclassDeclaration(int id) {
        super(id);
    }

    public ASTclassDeclaration(JmmParser p, int id) {
        super(p, id);
    }

    public void applySemanticAnalysis(SymbolTable table) {
        JmmParser.getInstance().getClassTable().setType(((SimpleNode) children[0]).name);
        
        if (children == null) return;

        for (int i = 0; i < children.length; i++) {
            ((SimpleNode) children[i]).applySemanticAnalysis(table);
        }
    }
}
/* JavaCC - OriginalChecksum=b9518b38c0f9d12026af2d11d1def7d8 (do not edit this line) */