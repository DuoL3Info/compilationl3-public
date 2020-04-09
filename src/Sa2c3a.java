import sa.*;
import c3a.*;
import ts.*;

public class Sa2c3a extends SaDepthFirstVisitor<C3aOperand> {

    private Ts table;
    private C3a c3a;
    private TsItemFct tsItemFct;

    private Sa2c3a(SaNode saRoot, Ts table) {
        c3a = new C3a();
        saRoot.accept(this);
        this.table = table;
    }

    public C3a getC3a(){
        return c3a;
    }

    @Override
    public C3aOperand visit(SaProg node) {
        node.getFonctions().accept(this);
        return null;
    }

    @Override
    public C3aOperand visit(SaDecTab node) {
        return super.visit(node);
    } // ???

    @Override
    public C3aOperand visit(SaExp node) { return super.visit(node);} //ne rien faire

    @Override
    public C3aOperand visit(SaExpInt node) { return new C3aConstant(node.getVal()); }

    @Override
    public C3aOperand visit(SaExpVar node) { return node.getVar().accept(this); }

    @Override
    public C3aOperand visit(SaInstEcriture node) {
        C3aOperand op1 = node.getArg().accept(this); //op1
        C3aInstWrite c3aInstWrite = new C3aInstWrite(op1, "");
        c3a.ajouteInst(c3aInstWrite);
        return null;
    }

    @Override
    public C3aOperand visit(SaInstTantQue node) {
        C3aLabel si = c3a.newAutoLabel();
        c3a.addLabelToNextInst(si);

        C3aOperand op1 = node.getTest().accept(this); // opérande 1 (ou null)
        C3aOperand op2 = new C3aConstant(0); // opérande 2 (ou null)
        C3aLabel result = c3a.newAutoLabel(); // résultat ou destination du saut (ou NULL)
        C3aInstJumpIfEqual c3aInstJumpIfEqual = new C3aInstJumpIfEqual(op1, op2, result,"");
        c3a.ajouteInst(c3aInstJumpIfEqual);

        node.getFaire().accept(this);
        c3a.ajouteInst(new C3aInstJump(si,""));
        c3a.addLabelToNextInst(result);
        return null;
    }

    @Override
    public C3aOperand visit(SaLInst node) {
        node.getTete().accept(this);
        if (node.getQueue() != null)
            node.getQueue().accept(this);
        return null;
    }

    @Override
    public C3aOperand visit(SaDecFonc node) {
        return super.visit(node); // ???
    }

    @Override
    public C3aOperand visit(SaDecVar node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaInstAffect node) {
        C3aOperand op1 = node.getRhs().accept(this); // opérande 1 (ou null)
        C3aOperand result =  node.getLhs().accept(this); // résultat ou destination du saut (ou NULL)
        C3aInstAffect c3aInstAffect = new C3aInstAffect(op1, result,"");
        c3a.ajouteInst(c3aInstAffect);
        return result;
    }

    @Override
    public C3aOperand visit(SaLDec node) {
        node.getTete().accept(this);
        if (node.getQueue() != null) node.getQueue().accept(this);
        return null;
    }

    @Override
    public C3aOperand visit(SaVarSimple node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaAppel node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpAppel node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpAdd node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpSub node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpMult node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpDiv node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpInf node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpEqual node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpAnd node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpOr node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpNot node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpLire node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaInstBloc node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaInstSi node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaInstRetour node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaLExp node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaVarIndicee node) {
        return super.visit(node);
    }
}
