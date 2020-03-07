import sa.*;
import sc.analysis.DepthFirstAdapter;
import sc.node.*;


public class Sc2sa extends DepthFirstAdapter {
        private SaNode returnValue;


    public SaNode getRoot(){
        return returnValue;
    }

    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        SaProg prog;
        node.getPProgramme().apply(this);
        prog = (SaProg) this.returnValue;
        this.returnValue = prog;
        outStart(node);
    }

    @Override
    public void caseADecvarldecfoncProgramme(ADecvarldecfoncProgramme node)
    {
        SaDec optdecvar = null;
        SaLDec listedecfonc = null;
        node.getOptdecvar().apply(this);
        optdecvar = (SaDec) this.returnValue;
        node.getListedecfonc().apply(this);
        listedecfonc = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(optdecvar, listedecfonc);
    }

    @Override
    public void caseALdecfoncProgramme(ALdecfoncProgramme node)
    {
        SaLDec listedecfonc = null;
        node.getListedecfonc().apply(this);
        listedecfonc = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(null, listedecfonc);
    }

    @Override
    public void caseAOptdecvar(AOptdecvar node)
    {
        SaLDec listedecvar = null;
        node.getListedecvar().apply(this);
        listedecvar = (SaLDec) this.returnValue;
        this.returnValue = listedecvar;
    }

    @Override
    public void caseADecvarldecvarListedecvar(ADecvarldecvarListedecvar node)
    {
        SaDec decVar = null;
        SaLDec listedecvarbis = null;
        node.getDecvar().apply(this);
        decVar = (SaDec) this.returnValue;
        node.getListedecvarbis().apply(this);
        listedecvarbis = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(decVar, listedecvarbis);
    }

    @Override
    public void caseADecvarListedecvar(ADecvarListedecvar node)
    {
        SaDec decVar = null;
        node.getDecvar().apply(this);
        decVar = (SaDec) this.returnValue;
        this.returnValue = decVar;
    }

    @Override
    public void caseADecvarldecvarListedecvarbis(ADecvarldecvarListedecvarbis node)
    {
        SaDec decVar = null;
        SaLDec listedecvarbis = null;
        node.getDecvar().apply(this);
        decVar = (SaDec) this.returnValue;
        node.getListedecvarbis().apply(this);
        listedecvarbis = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(decVar, listedecvarbis);
    }

    @Override
    public void caseADecvarListedecvarbis(ADecvarListedecvarbis node)
    {
        SaDec decVar = null;
        node.getDecvar().apply(this);
        decVar = (SaDec) this.returnValue;
        this.returnValue = decVar;
    }

    @Override
    public void caseADecvarentierDecvar(ADecvarentierDecvar node)
    {
        String nom;
        nom = node.getIdentif().getText();
        this.returnValue = new SaDecVar(nom);
    }

    @Override
    public void caseADecvartableauDecvar(ADecvartableauDecvar node)
    {
        String nom;
        nom = node.getIdentif().getText();
        int taille = Integer.parseInt(node.getEntier().getText());
        this.returnValue = new SaDecTab(nom,taille);
    }

    @Override
    public void caseALdecfoncrecListedecfonc(ALdecfoncrecListedecfonc node)
    {
        SaDec decFonc = null;
        SaLDec lDecFonc = null;
        node.getDecfonc().apply(this);
        decFonc = (SaDec) this.returnValue;
        node.getListedecfonc().apply(this);
        lDecFonc = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(decFonc, lDecFonc);
    }

    @Override
    public void caseALdecfoncfinalListedecfonc(ALdecfoncfinalListedecfonc node)
    {
        inALdecfoncfinalListedecfonc(node);
        this.returnValue = null;
        outALdecfoncfinalListedecfonc(node);
    }

    @Override
    public void caseADecvarinstrDecfonc(ADecvarinstrDecfonc node)
    {
        String nom = null;
        SaLDec par = null;
        SaLDec var = null;
        SaInst corps = null;
        nom = node.getIdentif().getText();
        node.getListeparam().apply(this);
        par = (SaLDec) this.returnValue;
        node.getOptdecvar().apply(this);
        var = (SaLDec) this.returnValue;
        node.getInstrbloc().apply(this);
        corps = (SaInstBloc) this.returnValue;
        this.returnValue = new SaDecFonc(nom,par,var,corps);
    }

    @Override
    public void caseAInstrDecfonc(AInstrDecfonc node)
    {
        String nom = null;
        SaLDec par = null;
        SaLDec var = null;
        SaInst corps = null;
        nom = node.getIdentif().getText();
        node.getListeparam().apply(this);
        par = (SaLDec) this.returnValue;
        node.getInstrbloc().apply(this);
        corps = (SaInstBloc) this.returnValue;
        this.returnValue = new SaDecFonc(nom,par,var,corps);
    }

    @Override
    public void caseASansparamListeparam(ASansparamListeparam node)
    {
        inASansparamListeparam(node);
        this.returnValue = null;
        outASansparamListeparam(node);
    }

    @Override
    public void caseAAvecparamListeparam(AAvecparamListeparam node)
    {
        SaLDec liste = null;
        node.getListedecvar().apply(this);
        liste = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(null, liste);
    }

    @Override
    public void caseAInstraffectInstr(AInstraffectInstr node)
    {
        SaInstAffect affect = null;
        node.getInstraffect().apply(this);
        affect = (SaInstAffect) this.returnValue;
        this.returnValue = affect;
    }

    @Override
    public void caseAInstrblocInstr(AInstrblocInstr node)
    {
        SaInstBloc bloc = null;
        node.getInstrbloc().apply(this);
        bloc = (SaInstBloc) this.returnValue;
        this.returnValue = bloc;
    }

    @Override
    public void caseAInstrsiInstr(AInstrsiInstr node)
    {
        SaInstSi si = null;
        node.getInstrsi().apply(this);
        si = (SaInstSi) this.returnValue;
        this.returnValue = si;
    }

    @Override
    public void caseAInstrtantqueInstr(AInstrtantqueInstr node)
    {
        SaInstTantQue tantQue = null;
        node.getInstrtantque().apply(this);
        tantQue = (SaInstTantQue) this.returnValue;
        this.returnValue = tantQue;
    }

    @Override
    public void caseAInstrappelInstr(AInstrappelInstr node)
    {
        SaAppel appel = null;
        node.getInstrappel().apply(this);
        appel = (SaAppel) this.returnValue;
        this.returnValue = appel;
    }

    @Override
    public void caseAInstrretourInstr(AInstrretourInstr node)
    {
        SaInstRetour retour = null;
        node.getInstrretour().apply(this);
        retour = (SaInstRetour) this.returnValue;
        this.returnValue = retour;
    }

    @Override
    public void caseAInstrecritureInstr(AInstrecritureInstr node)
    {
        SaInstEcriture ecriture = null;
        node.getInstrecriture().apply(this);
        ecriture = (SaInstEcriture) this.returnValue;
        this.returnValue = ecriture;
    }

    @Override
    public void caseAInstrvideInstr(AInstrvideInstr node)
    {
        SaInst vide = null;
        node.getInstrvide().apply(this);
        vide = (SaInst) this.returnValue;
        this.returnValue = vide;
    }

    @Override
    public void caseAInstraffect(AInstraffect node)
    {
        SaExp exp = null;
        SaVar var = null;
        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        node.getVar().apply(this);
        var = (SaVar) this.returnValue;
        this.returnValue = new SaInstAffect(var, exp);
    }

    @Override
    public void caseAInstrbloc(AInstrbloc node)
    {
        SaLInst lInst = null;
        node.getListeinst().apply(this);
        lInst = (SaLInst) this.returnValue;
        this.returnValue = lInst;
    }

    @Override
    public void caseALinstrecListeinst(ALinstrecListeinst node)
    {
        SaInst inst = null;
        SaLInst lInst = null;
        node.getInstr().apply(this);
        inst = (SaInst) this.returnValue;
        node.getListeinst().apply(this);
        lInst = (SaLInst) this.returnValue;
        this.returnValue = new SaLInst(inst,lInst);
    }

    @Override
    public void caseALinstfinalListeinst(ALinstfinalListeinst node)
    {
        inALinstfinalListeinst(node);
        this.returnValue = null;
        outALinstfinalListeinst(node);
    }

    @Override
    public void caseAAvecsinonInstrsi(AAvecsinonInstrsi node)
    {
        SaExp exp = null;
        SaInst instrbloc = null;
        SaInst instrsinon = null;
        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        node.getInstrbloc().apply(this);
        instrbloc = (SaInstBloc) this.returnValue;
        node.getInstrsinon().apply(this);
        instrsinon = (SaInst) this.returnValue;
        this.returnValue = new SaInstSi(exp,instrbloc,instrsinon);
    }

    @Override
    public void caseASanssinonInstrsi(ASanssinonInstrsi node)
    {
        SaExp exp = null;
        SaInst instrbloc = null;
        SaInst sinon = null;
        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        node.getInstrbloc().apply(this);
        instrbloc = (SaInstBloc) this.returnValue;
        this.returnValue = new SaInstSi(exp,instrbloc,sinon);
    }

    @Override
    public void caseAInstrsinon(AInstrsinon node)
    {
        SaInstBloc bloc = null;
        node.getInstrbloc().apply(this);
        bloc = (SaInstBloc) this.returnValue;
        this.returnValue = bloc;
    }

    @Override
    public void caseAInstrtantque(AInstrtantque node)
    {
        SaExp exp = null;
        SaInst instrbloc = null;
        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        node.getInstrbloc().apply(this);
        instrbloc = (SaInstBloc) this.returnValue;
        this.returnValue = new SaInstTantQue(exp,instrbloc);
    }

    @Override
    public void caseAInstrappel(AInstrappel node)
    {
        SaAppel appel = null;
        node.getAppelfct().apply(this);
        appel = (SaAppel) this.returnValue;
        this.returnValue = appel;
    }

    @Override
    public void caseAInstrretour(AInstrretour node)
    {
        SaExp exp = null;
        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = new SaInstRetour(exp);
    }

    @Override
    public void caseAInstrecriture(AInstrecriture node)
    {
        SaExp exp = null;
        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = new SaInstEcriture(exp);
    }

    @Override
    public void caseAInstrvide(AInstrvide node)
    {
       this.returnValue = null;
    }

    @Override
    public void caseAOuExp(AOuExp node)
    {
        SaExp op1 = null;
        SaExp op2 = null;
        node.getExp().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp1().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpOr(op1, op2);
    }

    @Override
    public void caseAExp1Exp(AExp1Exp node)
    {
        SaExp op1 = null;
        node.getExp1().apply(this);
        op1 = (SaExp) this.returnValue;
        this.returnValue = op1;
    }

    @Override
    public void caseAEtExp1(AEtExp1 node)
    {
        SaExp op1 = null;
        SaExp op2 = null;
        node.getExp1().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp2().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpAnd(op1, op2);
    }

    @Override
    public void caseAInfExp2(AInfExp2 node)
    {
        SaExp op1 = null;
        SaExp op2 = null;
        node.getExp2().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp3().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpInf(op1, op2);
    }

    @Override
    public void caseAEgalExp2(AEgalExp2 node)
    {
        SaExp op1 = null;
        SaExp op2 = null;
        node.getExp2().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp3().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpEqual(op1, op2);
    }

    public void caseAPlusExp3(APlusExp3 node) {
        SaExp op1 = null;
        SaExp op2 = null;
        node.getExp3().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp4().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpAdd(op1, op2);
    }

    @Override
    public void caseAMoinsExp3(AMoinsExp3 node)
    {
        SaExp op1 = null;
        SaExp op2 = null;
        node.getExp3().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp4().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpSub(op1, op2);
    }

    @Override
    public void caseAFoisExp4(AFoisExp4 node)
    {
        SaExp op1 = null;
        SaExp op2 = null;
        node.getExp4().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp5().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpMult(op1, op2);
    }

    @Override
    public void caseADiviseExp4(ADiviseExp4 node)
    {
        SaExp op1 = null;
        SaExp op2 = null;
        node.getExp4().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp5().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpDiv(op1, op2);
    }

    @Override
    public void caseANonExp5(ANonExp5 node)
    {
        SaExp op1 = null;
        node.getExp5().apply(this);
        op1 = (SaExp) this.returnValue;
        this.returnValue = new SaExpNot(op1);
    }

    @Override
    public void caseANombreExp6(ANombreExp6 node)
    {
        SaExpInt op1 = null;
        node.getNombre().apply(this);
        op1 = (SaExpInt) this.returnValue;
        int nombre = Integer.parseInt(node.getNombre().getText());
        this.returnValue = new SaExpInt(nombre);
    }

    @Override
    public void caseAAppelfctExp6(AAppelfctExp6 node)
    {
        SaAppel op1 = null;
        node.getAppelfct().apply(this);
        op1 = (SaAppel) this.returnValue;
        this.returnValue = new SaExpAppel(op1);
    }

    @Override
    public void caseAVarExp6(AVarExp6 node)
    {
        SaVar op1 = null;
        node.getVar().apply(this);
        op1 = (SaVar) this.returnValue;
        this.returnValue = new SaExpVar(op1);
    }

    @Override
    public void caseALireExp6(ALireExp6 node)
    {
        SaExpLire op1 = null;
        node.getLire().apply(this);
        op1 = (SaExpLire) this.returnValue;
        this.returnValue = new SaExpLire();
    }

    @Override
    public void caseAVartabVar(AVartabVar node)
    {
        String nom = null;
        SaExp exp = null;
        nom = node.getIdentif().getText();
        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = new SaVarIndicee(nom, exp);
    }

    @Override
    public void caseAVarsimpleVar(AVarsimpleVar node) {
        String nom = null;
        nom = node.getIdentif().getText();
        this.returnValue = new SaVarSimple(nom);
    }

    @Override
    public void caseARecursifListeexp(ARecursifListeexp node)
    {
        SaExp tete = null;
        SaLExp queue = null;
        node.getExp().apply(this);
        tete = (SaExp) this.returnValue;
        node.getListeexpbis().apply(this);
        queue = (SaLExp) this.returnValue;
        this.returnValue = new SaLExp(tete,queue);
    }

    @Override
    public void caseAFinalListeexp(AFinalListeexp node)
    {
        inAFinalListeexp(node);
        this.returnValue = null;
        outAFinalListeexp(node);
    }

    @Override
    public void caseARecursifListeexpbis(ARecursifListeexpbis node)
    {
        SaExp tete = null;
        SaLExp queue = null;
        node.getExp().apply(this);
        tete = (SaExp) this.returnValue;
        node.getListeexpbis().apply(this);
        queue = (SaLExp) this.returnValue;
        this.returnValue = new SaLExp(tete,queue);
    }

    @Override
    public void caseAFinalListeexpbis(AFinalListeexpbis node)
    {
        inAFinalListeexpbis(node);
        this.returnValue = null;
        outAFinalListeexpbis(node);
    }

    @Override
    public void caseAAppelfct(AAppelfct node)
    {
        String nom = null;
        SaLExp listeExp = null;
        nom = node.getIdentif().getText();
        node.getListeexp().apply(this);
        listeExp = (SaLExp) this.returnValue;
        this.returnValue = new SaAppel(nom, listeExp);
    }
}


