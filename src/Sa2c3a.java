import c3a.*;
import sa.*;
import ts.Ts;
import ts.TsItemFct;

public class Sa2c3a extends SaDepthFirstVisitor<C3aOperand> {
    private C3a c3a;
    private Ts table;
    private TsItemFct tsItemFct;


    public Sa2c3a(SaNode root, Ts ts){
        c3a = new C3a();
        this.table = ts;
        root.accept(this);
    }

    public C3a getC3a() {
        return c3a;
    }

    @Override
    public C3aOperand visit(SaProg node) {
        node.getFonctions().accept(this);
        return null;
    }

    @Override
    public C3aOperand visit(SaDecTab node) { return super.visit(node); } // ???

    @Override
    public C3aOperand visit(SaExp node) { return super.visit(node);} //ne rien faire

    @Override
    public C3aOperand visit(SaExpInt node) { return new C3aConstant(node.getVal()); }

    @Override
    public C3aOperand visit(SaExpVar node) { return node.getVar().accept(this); }

    @Override
    public C3aOperand visit(SaInstEcriture node) {
        C3aOperand op1 = node.getArg().accept(this); //opérande 1 (ou null)
        C3aInstWrite c3aInstWrite = new C3aInstWrite(op1, "");
        c3a.ajouteInst(c3aInstWrite);
        return null;
    }



    @Override
    public C3aOperand visit(SaInstTantQue node) {
        C3aLabel c3aLabel = c3a.newAutoLabel();
        c3a.addLabelToNextInst(c3aLabel);

        C3aOperand op1 = node.getTest().accept(this); // opérande 1 (ou null)
        C3aOperand op2 = new C3aConstant(0); // opérande 2 (ou null)
        C3aLabel result = c3a.newAutoLabel(); // résultat ou destination du saut (ou NULL)
        C3aInstJumpIfEqual c3aInstJumpIfEqual = new C3aInstJumpIfEqual(op1, op2, result,"");
        c3a.ajouteInst(c3aInstJumpIfEqual);

        node.getFaire().accept(this);
        c3a.ajouteInst(new C3aInstJump(c3aLabel,""));
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
        tsItemFct = table.getFct(node.getNom());
        C3aInstFBegin c3aInstFBegin = new C3aInstFBegin(tsItemFct,"");
        c3a.ajouteInst(c3aInstFBegin);

        node.getCorps().accept(this);
        C3aInstFEnd c3aInstFEnd = new C3aInstFEnd("");
        c3a.ajouteInst(c3aInstFEnd);
        return null;
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
    public C3aOperand visit(SaVarSimple node) { return new C3aVar((table.getVar(node.getNom())), null); }

    @Override
    public C3aOperand visit(SaAppel node){
        if (node.getArguments() != null)
            node.getArguments().accept(this);
        return new C3aFunction(table.getFct(node.getNom()));
    }

    @Override
    public C3aOperand visit(SaExpAppel node){
        C3aFunction op1 = (C3aFunction) node.getVal().accept(this); // opérande 1 (ou null)
        C3aTemp result =  c3a.newTemp(); // résultat ou destination du saut (ou NULL)
        C3aInstCall c3aInstCall = new C3aInstCall(op1, result, "");
        c3a.ajouteInst(c3aInstCall);
        return result;
    }

    @Override
    public C3aOperand visit(SaExpAdd node) {
        C3aOperand op1 = node.getOp1().accept(this);   // opérande 1 (ou null)
        C3aOperand op2 = node.getOp2().accept(this);   // opérande 2 (ou null)
        C3aTemp result = c3a.newTemp();
        C3aInstAdd c3aInstAdd = new C3aInstAdd(op1, op2, result, "");
        c3a.ajouteInst(c3aInstAdd);
        return result;
    }



    @Override
    public C3aOperand visit(SaExpSub node) {
        C3aOperand op1 = node.getOp1().accept(this);   // opérande 1 (ou null)
        C3aOperand op2 = node.getOp2().accept(this);   // opérande 2 (ou null)
        C3aTemp result = c3a.newTemp();
        C3aInstSub c3aInstSub = new C3aInstSub(op1, op2, result, "");
        c3a.ajouteInst(c3aInstSub);
        return result;
    }

    @Override
    public C3aOperand visit(SaExpMult node){
        C3aOperand op1 = node.getOp1().accept(this);   // opérande 1 (ou null)
        C3aOperand op2 = node.getOp2().accept(this);   // opérande 2 (ou null)
        C3aTemp result = c3a.newTemp();
        C3aInstMult c3aInstMult = new C3aInstMult(op1, op2, result, "");
        c3a.ajouteInst(c3aInstMult);
        return result;
    }

    @Override
    public C3aOperand visit(SaExpDiv node) {
        C3aOperand op1 = node.getOp1().accept(this);   // opérande 1 (ou null)
        C3aOperand op2 = node.getOp2().accept(this);   // opérande 2 (ou null)
        C3aTemp result = c3a.newTemp();
        C3aInstDiv c3aInstDiv = new C3aInstDiv(op1, op2, result, "");
        c3a.ajouteInst(c3aInstDiv);
        return result;
    }


    @Override
    public C3aOperand visit(SaExpInf node) {
        C3aOperand op1 = node.getOp1().accept(this);    // opérande 1 (ou null)
        C3aOperand op2 = node.getOp2().accept(this); // résultat ou destination du saut (ou NULL)

        //initilisation d'un temporaire à 1 (vrai)
        C3aTemp c3aTemp = c3a.newTemp();
        C3aInstAffect c3aInstAffect = new C3aInstAffect(new C3aConstant(1), c3aTemp, "");
        c3a.ajouteInst(c3aInstAffect);

        //si opérande 1 < opérande 2 on saute à la fin
        C3aLabel c3aLabel = c3a.newAutoLabel(); //
        C3aInstJumpIfLess c3aInstJumpIfLess = new C3aInstJumpIfLess(op1 , op2 , c3aLabel, "");
        c3a.ajouteInst(c3aInstJumpIfLess);

        //sinon on met ce temporaire à 0
        C3aInstAffect c3aInstAffect2 = new C3aInstAffect(new C3aConstant(0), c3aTemp, "");
        c3a.ajouteInst(c3aInstAffect2);
        c3a.addLabelToNextInst(c3aLabel);
        return c3aTemp;
    }

    @Override
    public C3aOperand visit(SaExpEqual node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpAnd node) {
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);

        //initilisation d'un temporaire à 1 (vrai)
        C3aTemp c3aTemp = c3a.newTemp();
        C3aInstAffect c3aInstAffect = new C3aInstAffect(new C3aConstant(0), c3aTemp, "");
        c3a.ajouteInst(c3aInstAffect);

        //si les deux opérandes sont égaux, GOTO c3aLabel sinon modification de la temporaire à 0 (faux)
        C3aLabel c3aLabel = c3a.newAutoLabel();
        C3aInstJumpIfEqual c3aInstJumpIfEqual1 = new C3aInstJumpIfEqual(op1, op2, c3aLabel,"");
        c3a.ajouteInst(c3aInstJumpIfEqual1);

        C3aInstAffect c3aInstAffect2 = new C3aInstAffect(new C3aConstant(0), c3aTemp, "");
        c3a.ajouteInst(c3aInstAffect2);
        c3a.addLabelToNextInst(c3aLabel);
        return c3aTemp;
    }



    @Override
    public C3aOperand visit(SaExpOr node) {
        C3aTemp c3aTemp = c3a.newTemp();
        C3aLabel c3aLabel = c3a.newAutoLabel();
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);

        c3a.ajouteInst(new C3aInstJumpIfNotEqual(op1,new C3aConstant(0), c3aLabel,""));
        c3a.ajouteInst(new C3aInstJumpIfNotEqual(op1,new C3aConstant(0), c3aLabel,""));
        c3a.ajouteInst(new C3aInstAffect(new C3aConstant(1), c3aTemp,""));

        C3aLabel c3aLabel2 = c3a.newAutoLabel();
        c3a.ajouteInst(new C3aInstJump(c3aLabel2,""));
        c3a.addLabelToNextInst(c3aLabel);
        c3a.ajouteInst(new C3aInstAffect(new C3aConstant(0), c3aTemp,""));
        c3a.addLabelToNextInst(c3aLabel2);
        return c3aTemp;


    }

    @Override
    public C3aOperand visit(SaExpNot node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpLire node) {
        C3aInstRead c3aInstRead = new C3aInstRead( node.accept(this), "");
        c3a.ajouteInst(c3aInstRead);
        return null;
    }

    @Override
    public C3aOperand visit(SaInstBloc node) {
        node.getVal().accept(this);
        return null;
    }

    @Override
    public C3aOperand visit(SaInstSi node) {
        C3aLabel c3aLabel = c3a.newAutoLabel();
        C3aLabel c3aLabel1 = c3a.newAutoLabel();
        C3aInstJumpIfEqual c3aInstJumpIfEqual = new C3aInstJumpIfEqual(node.getTest().accept(this), new C3aConstant(0), c3aLabel1, "");

        if (node.getSinon() == null) {
            c3a.ajouteInst(c3aInstJumpIfEqual);
            node.getAlors().accept(this);
        }
        else{
            c3a.ajouteInst(c3aInstJumpIfEqual);
            node.getAlors().accept(this);
            C3aInstJump c3aInstJump = new C3aInstJump(c3aLabel1, "");
            c3a.ajouteInst(c3aInstJump);
            c3a.addLabelToNextInst(c3aLabel);
            node.getSinon().accept(this);
        }
        c3a.addLabelToNextInst(c3aLabel1);
        return null;
    }

    @Override
    public C3aOperand visit(SaInstRetour node) {
        C3aInstReturn c3aInstReturn = new C3aInstReturn(node.getVal().accept(this), "");
        c3a.ajouteInst(c3aInstReturn);
        return null;
    }

    @Override
    public C3aOperand visit(SaLExp node) {
        C3aOperand op1 = node.getTete().accept(this);
        C3aInstParam c3aInstParam = new C3aInstParam(op1, "");
        c3a.ajouteInst(c3aInstParam);
        if (node.getQueue() != null) {
            node.getQueue().accept(this);
        }
        return null;
    }

    @Override
    public C3aOperand visit(SaVarIndicee node){
        return new C3aVar(table.getVar(node.getNom()), node.getIndice().accept(this));
    }
}
