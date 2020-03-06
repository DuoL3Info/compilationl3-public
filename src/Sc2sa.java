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

    public void inADecvarldecfoncProgramme(ADecvarldecfoncProgramme node)
    {
        defaultIn(node);
    }

    public void outADecvarldecfoncProgramme(ADecvarldecfoncProgramme node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecvarldecfoncProgramme(ADecvarldecfoncProgramme node)
    {
        SaDec variables = null;
        SaLDec fonctions = null;
        node.getOptdecvar().apply(this);
        variables = (SaDec) this.returnValue;
        node.getListedecfonc().apply(this);
        fonctions = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(variables, fonctions);
    }

    public void inALdecfoncProgramme(ALdecfoncProgramme node)
    {
        defaultIn(node);
    }

    public void outALdecfoncProgramme(ALdecfoncProgramme node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALdecfoncProgramme(ALdecfoncProgramme node)
    {
        SaLDec fonctions = null;
        node.getListedecfonc().apply(this);
        fonctions = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(null, fonctions);
    }

    public void inAOptdecvar(AOptdecvar node)
    {
        defaultIn(node);
    }

    public void outAOptdecvar(AOptdecvar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOptdecvar(AOptdecvar node)
    {
        SaLDec variables = null;
        node.getListedecvar().apply(this);
        variables = (SaLDec) this.returnValue;
        this.returnValue = variables;
    }

    public void inADecvarldecvarListedecvar(ADecvarldecvarListedecvar node)
    {
        defaultIn(node);
    }

    public void outADecvarldecvarListedecvar(ADecvarldecvarListedecvar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecvarldecvarListedecvar(ADecvarldecvarListedecvar node)
    {
        SaDec decVar = null;
        SaLDec lDecVar = null;
        node.getDecvar().apply(this);
        decVar = (SaDec) this.returnValue;
        node.getListedecvarbis().apply(this);
        lDecVar = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(decVar, lDecVar);
    }

    public void inADecvarListedecvar(ADecvarListedecvar node)
    {
        defaultIn(node);
    }

    public void outADecvarListedecvar(ADecvarListedecvar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecvarListedecvar(ADecvarListedecvar node)
    {
        SaDec decVar = null;
        node.getDecvar().apply(this);
        decVar = (SaDec) this.returnValue;
        this.returnValue = new SaLDec(decVar, null);
    }

    public void inADecvarldecvarListedecvarbis(ADecvarldecvarListedecvarbis node)
    {
        defaultIn(node);
    }

    public void outADecvarldecvarListedecvarbis(ADecvarldecvarListedecvarbis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecvarldecvarListedecvarbis(ADecvarldecvarListedecvarbis node)
    {
        SaDec decVar = null;
        SaLDec lDecVar = null;
        node.getDecvar().apply(this);
        decVar = (SaDec) this.returnValue;
        node.getListedecvarbis().apply(this);
        lDecVar = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(decVar, lDecVar);
    }

    public void inADecvarListedecvarbis(ADecvarListedecvarbis node)
    {
        defaultIn(node);
    }

    public void outADecvarListedecvarbis(ADecvarListedecvarbis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecvarListedecvarbis(ADecvarListedecvarbis node)
    {
        SaDec decVar = null;
        node.getDecvar().apply(this);
        decVar = (SaDec) this.returnValue;
        this.returnValue = new SaLDec(decVar, null);
    }

    public void inADecvarentierDecvar(ADecvarentierDecvar node)
    {
        defaultIn(node);
    }

    public void outADecvarentierDecvar(ADecvarentierDecvar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecvarentierDecvar(ADecvarentierDecvar node)
    {
        String nom;
        nom = node.getIdentif().getText();
        this.returnValue = new SaDecVar(nom);
    }

    public void inADecvartableauDecvar(ADecvartableauDecvar node)
    {
        defaultIn(node);
    }

    public void outADecvartableauDecvar(ADecvartableauDecvar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecvartableauDecvar(ADecvartableauDecvar node)
    {
        String nom;
        nom = node.getIdentif().getText();
        int taille = Integer.parseInt(node.getEntier().getText());
        this.returnValue = new SaDecTab(nom,taille);
    }

    public void inALdecfoncrecListedecfonc(ALdecfoncrecListedecfonc node)
    {
        defaultIn(node);
    }

    public void outALdecfoncrecListedecfonc(ALdecfoncrecListedecfonc node)
    {
        defaultOut(node);
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

    public void inALdecfoncfinalListedecfonc(ALdecfoncfinalListedecfonc node)
    {
        defaultIn(node);
    }

    public void outALdecfoncfinalListedecfonc(ALdecfoncfinalListedecfonc node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALdecfoncfinalListedecfonc(ALdecfoncfinalListedecfonc node)
    {
        inALdecfoncfinalListedecfonc(node);
        this.returnValue = null;
        outALdecfoncfinalListedecfonc(node);
    }

    public void inADecvarinstrDecfonc(ADecvarinstrDecfonc node)
    {
        defaultIn(node);
    }

    public void outADecvarinstrDecfonc(ADecvarinstrDecfonc node)
    {
        defaultOut(node);
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

    public void inAInstrDecfonc(AInstrDecfonc node)
    {
        defaultIn(node);
    }

    public void outAInstrDecfonc(AInstrDecfonc node)
    {
        defaultOut(node);
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

    public void inASansparamListeparam(ASansparamListeparam node)
    {
        defaultIn(node);
    }

    public void outASansparamListeparam(ASansparamListeparam node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASansparamListeparam(ASansparamListeparam node)
    {
        inASansparamListeparam(node);
        this.returnValue = null;
        outASansparamListeparam(node);
    }

    public void inAAvecparamListeparam(AAvecparamListeparam node)
    {
        defaultIn(node);
    }

    public void outAAvecparamListeparam(AAvecparamListeparam node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAvecparamListeparam(AAvecparamListeparam node)
    {
        SaLDec liste = null;
        node.getListedecvar().apply(this);
        liste = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(null, liste);
    }

    public void inAInstraffectInstr(AInstraffectInstr node)
    {
        defaultIn(node);
    }

    public void outAInstraffectInstr(AInstraffectInstr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstraffectInstr(AInstraffectInstr node)
    {
        SaInstAffect affect = null;
        node.getInstraffect().apply(this);
        affect = (SaInstAffect) this.returnValue;
        this.returnValue = affect;
    }

    public void inAInstrblocInstr(AInstrblocInstr node)
    {
        defaultIn(node);
    }

    public void outAInstrblocInstr(AInstrblocInstr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrblocInstr(AInstrblocInstr node)
    {
        SaInstBloc bloc = null;
        node.getInstrbloc().apply(this);
        bloc = (SaInstBloc) this.returnValue;
        this.returnValue = bloc;
    }

    public void inAInstrsiInstr(AInstrsiInstr node)
    {
        defaultIn(node);
    }

    public void outAInstrsiInstr(AInstrsiInstr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrsiInstr(AInstrsiInstr node)
    {
        SaInstSi si = null;
        node.getInstrsi().apply(this);
        si = (SaInstSi) this.returnValue;
        this.returnValue = si;
    }

    public void inAInstrtantqueInstr(AInstrtantqueInstr node)
    {
        defaultIn(node);
    }

    public void outAInstrtantqueInstr(AInstrtantqueInstr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrtantqueInstr(AInstrtantqueInstr node)
    {
        SaInstTantQue tantQue = null;
        node.getInstrtantque().apply(this);
        tantQue = (SaInstTantQue) this.returnValue;
        this.returnValue = tantQue;
    }

    public void inAInstrappelInstr(AInstrappelInstr node)
    {
        defaultIn(node);
    }

    public void outAInstrappelInstr(AInstrappelInstr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrappelInstr(AInstrappelInstr node)
    {
        SaAppel appel = null;
        node.getInstrappel().apply(this);
        appel = (SaAppel) this.returnValue;
        this.returnValue = appel;
    }

    public void inAInstrretourInstr(AInstrretourInstr node)
    {
        defaultIn(node);
    }

    public void outAInstrretourInstr(AInstrretourInstr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrretourInstr(AInstrretourInstr node)
    {
        SaInstRetour retour = null;
        node.getInstrretour().apply(this);
        retour = (SaInstRetour) this.returnValue;
        this.returnValue = retour;
    }

    public void inAInstrecritureInstr(AInstrecritureInstr node)
    {
        defaultIn(node);
    }

    public void outAInstrecritureInstr(AInstrecritureInstr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrecritureInstr(AInstrecritureInstr node)
    {
        SaInstEcriture ecriture = null;
        node.getInstrecriture().apply(this);
        ecriture = (SaInstEcriture) this.returnValue;
        this.returnValue = ecriture;
    }

    public void inAInstrvideInstr(AInstrvideInstr node)
    {
        defaultIn(node);
    }

    public void outAInstrvideInstr(AInstrvideInstr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrvideInstr(AInstrvideInstr node)
    {
        SaInst vide = null;
        node.getInstrvide().apply(this);
        vide = (SaInst) this.returnValue;
        this.returnValue = vide;
    }

    public void inAInstraffect(AInstraffect node)
    {
        defaultIn(node);
    }

    public void outAInstraffect(AInstraffect node)
    {
        defaultOut(node);
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

    public void inAInstrbloc(AInstrbloc node)
    {
        defaultIn(node);
    }

    public void outAInstrbloc(AInstrbloc node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrbloc(AInstrbloc node)
    {
        SaLInst lInst = null;
        node.getListeinst().apply(this);
        lInst = (SaLInst) this.returnValue;
        this.returnValue = new SaInstBloc(lInst);
    }

    public void inALinstrecListeinst(ALinstrecListeinst node)
    {
        defaultIn(node);
    }

    public void outALinstrecListeinst(ALinstrecListeinst node)
    {
        defaultOut(node);
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


    public void inAAvecsinonInstrsi(AAvecsinonInstrsi node)
    {
        defaultIn(node);
    }

    public void outAAvecsinonInstrsi(AAvecsinonInstrsi node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAvecsinonInstrsi(AAvecsinonInstrsi node)
    {
        SaExp exp = null;
        SaInst alors = null;
        SaInst sinon = null;
        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        node.getAlors().apply(this);
        alors = (SaInst) this.returnValue;
        node.getExp().apply(this);
        sinon = (SaInst) this.returnValue;
        this.returnValue = new SaInstSi(exp,alors,sinon);
    }

    public void inASanssinonInstrsi(ASanssinonInstrsi node)
    {
        defaultIn(node);
    }

    public void outASanssinonInstrsi(ASanssinonInstrsi node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASanssinonInstrsi(ASanssinonInstrsi node)
    {
        SaExp exp = null;
        SaInst alors = null;
        SaInst sinon = null;
        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        node.getAlors().apply(this);
        alors = (SaInst) this.returnValue;
        this.returnValue = new SaInstSi(exp,alors,sinon);
    }

    public void inAInstrsinon(AInstrsinon node)
    {
        defaultIn(node);
    }

    public void outAInstrsinon(AInstrsinon node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrsinon(AInstrsinon node)
    {
        SaInstBloc bloc = null;
        node.getInstrbloc().apply(this);
        bloc = (SaInstBloc) this.returnValue;
        this.returnValue = bloc;
    }

    public void inAInstrtantque(AInstrtantque node)
    {
        defaultIn(node);
    }

    public void outAInstrtantque(AInstrtantque node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrtantque(AInstrtantque node)
    {
        SaExp exp = null;
        SaInst faire = null;
        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        node.getFaire().apply(this);
        faire = (SaInst) this.returnValue;
        this.returnValue = new SaInstTantQue(exp,faire);
    }

    public void inAInstrappel(AInstrappel node)
    {
        defaultIn(node);
    }

    public void outAInstrappel(AInstrappel node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrappel(AInstrappel node)
    {
        SaAppel appel = null;
        node.getAppelfct().apply(this);
        appel = (SaAppel) this.returnValue;
        this.returnValue = appel;
    }

    public void inAInstrretour(AInstrretour node)
    {
        defaultIn(node);
    }

    public void outAInstrretour(AInstrretour node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrretour(AInstrretour node)
    {
        SaExp exp = null;
        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = new SaInstRetour(exp);
    }

    public void inAInstrecriture(AInstrecriture node)
    {
        defaultIn(node);
    }

    public void outAInstrecriture(AInstrecriture node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrecriture(AInstrecriture node)
    {
        SaExp exp = null;
        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = new SaInstEcriture(exp);
    }

    public void inAInstrvide(AInstrvide node)
    {
        defaultIn(node);
    }

    public void outAInstrvide(AInstrvide node)
    {
        defaultOut(node);
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


