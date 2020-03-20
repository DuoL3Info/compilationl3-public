import sa.*;
import ts.Ts;

public class Sa2ts extends SaDepthFirstVisitor {

    Ts tableGlobale;
    Ts tableLocale;

    public Sa2ts(SaNode saRoot) {
    }

    public Ts getTableGlobale(){
        return tableGlobale;
    }

    public Ts getTableLocale(){
        return tableLocale;
    }

    @Override
    public Object visit(SaDecTab node) {
        return super.visit(node);
    }

    @Override
    public Object visit(SaDecFonc node) {
        return super.visit(node);
    }

    @Override
    public Object visit(SaDecVar node) {
        return super.visit(node);
    }

    @Override
    public Object visit(SaVarSimple node) {
        return super.visit(node);
    }

    @Override
    public Object visit(SaAppel node) {
        return super.visit(node);
    }

    @Override
    public Object visit(SaVarIndicee node) {
        return super.visit(node);
    }
}
