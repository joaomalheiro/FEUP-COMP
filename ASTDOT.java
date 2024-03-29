/* Generated By:JJTree: Do not edit this line. ASTDOT.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTDOT extends SimpleNode {
    public ASTDOT(int id) {
        super(id);
    }

    public ASTDOT(JmmParser p, int id) {
        super(p, id);
    }

    public void applySemanticAnalysis(SymbolTable table) {
        SimpleNode lhs = ((SimpleNode) children[0]);
        SimpleNode rhs = ((SimpleNode) children[1]);

        Symbol s = table.getSymbol(lhs.name);
        if (s != null) {
            if (!s.isInitialized()) {
                System.out.println("Variable " + lhs.name + " not initialized on line " + lhs.getLine());
                System.exit(0);
            }

            if (s.getType().equals("int[]")) {
                if (rhs.index != -1)
                    if (JmmParserConstants.tokenImage[rhs.index].replaceAll("\"", "").equals("length"))
                        return;

                System.out.println("Not a valid attribute of array type on line " + rhs.getLine());
                System.exit(0);
            }

            if (!s.getType().equals("int") && !s.getType().equals("boolean")) {
                if (rhs.index != -1) {
                    System.out.println("Found " + JmmParserConstants.tokenImage[rhs.index].replaceAll("\"", "") + " and expected function call on line " + rhs.getLine());
                    System.exit(0);
                }

                if (s.getType().equals(JmmParser.getInstance().getClassTable().getType()) || parent instanceof ASTbody || parent instanceof ASTmethodBody) {
                    rhs.applySemanticAnalysis(table);
                    return;
                }

                return;
            }
        } 

        if (lhs.index != -1) {
            if (lhs.index == JmmParserConstants.THIS) {
                rhs.applySemanticAnalysis(table);
                return;
            }
        }

        if (lhs instanceof ASTNEW) {
            if (JmmParser.getInstance().getClassTable().getType().equals(((SimpleNode) lhs.children[0]).name))
                rhs.applySemanticAnalysis(table);

            return;
        }

        if(rhs instanceof ASTfunctionCall)
            ((ASTfunctionCall)rhs).applySemanticAnalysisOnParameters(table);

        if (rhs.index != JmmParserConstants.LENGTH) return;

        System.out.println("Found " + lhs.toString() + " and was expecting int[] on line " + lhs.getLine());
        System.exit(0);
    }
}
/* JavaCC - OriginalChecksum=ef835f1225925686216b66ae41223fd2 (do not edit this line) */
