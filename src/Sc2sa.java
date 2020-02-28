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
        node.getPProgramme().apply(this);
        node.getEOF().apply(this);
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
        SaLDec variables = null;
        SaLDec fonctions = null;
        node.getOptdecvar().apply(this);
        variables = (SaLDec) this.returnValue;
        node.getListedecfonc().apply(this);
        fonctions = (SaLDec) this.returnValue;
        this.returnValue = new SaProg(variables, fonctions);
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
        this.returnValue = new SaProg(null, fonctions);
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
        SaExpInt entier = null;
        node.getEntier().apply(this);
        entier = (SaExpInt) this.returnValue;
        int nombre = Integer.parseInt(node.getEntier().getText());
        this.returnValue = new SaExpInt(nombre);
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
        // à faire
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
        inALdecfoncrecListedecfonc(node);
        if(node.getDecfonc() != null)
        {
            node.getDecfonc().apply(this);
        }
        if(node.getListedecfonc() != null)
        {
            node.getListedecfonc().apply(this);
        }
        outALdecfoncrecListedecfonc(node);
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
        inADecvarinstrDecfonc(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getListeparam() != null)
        {
            node.getListeparam().apply(this);
        }
        if(node.getOptdecvar() != null)
        {
            node.getOptdecvar().apply(this);
        }
        if(node.getInstrbloc() != null)
        {
            node.getInstrbloc().apply(this);
        }
        outADecvarinstrDecfonc(node);
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
        inAInstrDecfonc(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getListeparam() != null)
        {
            node.getListeparam().apply(this);
        }
        if(node.getInstrbloc() != null)
        {
            node.getInstrbloc().apply(this);
        }
        outAInstrDecfonc(node);
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
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
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
        inAAvecparamListeparam(node);
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getListedecvar() != null)
        {
            node.getListedecvar().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
        outAAvecparamListeparam(node);
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

    public void inAOuExp(AOuExp node)
    {
        defaultIn(node);
    }

    public void outAOuExp(AOuExp node)
    {
        defaultOut(node);
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

    public void inAExp1Exp(AExp1Exp node)
    {
        defaultIn(node);
    }

    public void outAExp1Exp(AExp1Exp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExp1Exp(AExp1Exp node)
    {
        SaExp op1 = null;
        node.getExp1().apply(this);
        op1 = (SaExp) this.returnValue;
        this.returnValue = op1;
    }

    public void inAEtExp1(AEtExp1 node)
    {
        defaultIn(node);
    }

    public void outAEtExp1(AEtExp1 node)
    {
        defaultOut(node);
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

    public void inAInfExp2(AInfExp2 node)
    {
        defaultIn(node);
    }

    public void outAInfExp2(AInfExp2 node)
    {
        defaultOut(node);
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

    public void inAEgalExp2(AEgalExp2 node)
    {
        defaultIn(node);
    }

    public void outAEgalExp2(AEgalExp2 node)
    {
        defaultOut(node);
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


    public void inAPlusExp3(APlusExp3 node)
    {
        defaultIn(node);
    }

    public void outAPlusExp3(APlusExp3 node)
    {
        defaultOut(node);
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

    public void inAMoinsExp3(AMoinsExp3 node)
    {
        defaultIn(node);
    }

    public void outAMoinsExp3(AMoinsExp3 node)
    {
        defaultOut(node);
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


    public void inAFoisExp4(AFoisExp4 node)
    {
        defaultIn(node);
    }

    public void outAFoisExp4(AFoisExp4 node)
    {
        defaultOut(node);
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

    public void inADiviseExp4(ADiviseExp4 node)
    {
        defaultIn(node);
    }

    public void outADiviseExp4(ADiviseExp4 node)
    {
        defaultOut(node);
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


    public void inANonExp5(ANonExp5 node)
    {
        defaultIn(node);
    }

    public void outANonExp5(ANonExp5 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANonExp5(ANonExp5 node)
    {
        SaExp op1 = null;
        node.getExp5().apply(this);
        op1 = (SaExp) this.returnValue;
        this.returnValue = new SaExpNot(op1);
    }


    public void inANombreExp6(ANombreExp6 node)
    {
        defaultIn(node);
    }

    public void outANombreExp6(ANombreExp6 node)
    {
        defaultOut(node);
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

    public void inAAppelfctExp6(AAppelfctExp6 node)
    {
        defaultIn(node);
    }

    public void outAAppelfctExp6(AAppelfctExp6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAppelfctExp6(AAppelfctExp6 node)
    {
        SaAppel op1 = null;
        node.getAppelfct().apply(this);
        op1 = (SaAppel) this.returnValue;
        this.returnValue = new SaExpAppel(op1);
    }

    public void inAVarExp6(AVarExp6 node)
    {
        defaultIn(node);
    }

    public void outAVarExp6(AVarExp6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarExp6(AVarExp6 node)
    {
        SaVar op1 = null;
        node.getVar().apply(this);
        op1 = (SaVar) this.returnValue;
        this.returnValue = new SaExpVar(op1);
    }


    public void inALireExp6(ALireExp6 node)
    {
        defaultIn(node);
    }

    public void outALireExp6(ALireExp6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALireExp6(ALireExp6 node)
    {
        SaExpLire op1 = null;
        node.getLire().apply(this);
        op1 = (SaExpLire) this.returnValue;
        this.returnValue = new SaExpLire();
    }

    public void inAVartabVar(AVartabVar node)
    {
        defaultIn(node);
    }

    public void outAVartabVar(AVartabVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVartabVar(AVartabVar node)
    {
        inAVartabVar(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getCrochetOuvrant() != null)
        {
            node.getCrochetOuvrant().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getCrochetFermant() != null)
        {
            node.getCrochetFermant().apply(this);
        }
        outAVartabVar(node);
    }

    public void inAVarsimpleVar(AVarsimpleVar node)
    {
        defaultIn(node);
    }

    public void outAVarsimpleVar(AVarsimpleVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarsimpleVar(AVarsimpleVar node) {
        SaVarSimple var = null;
        node.getIdentif().apply(this);
        var = (SaVarSimple) this.returnValue;
        this.returnValue = var;
    }

    public void inARecursifListeexp(ARecursifListeexp node)
    {
        defaultIn(node);
    }

    public void outARecursifListeexp(ARecursifListeexp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARecursifListeexp(ARecursifListeexp node)
    {
        inARecursifListeexp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getListeexpbis() != null)
        {
            node.getListeexpbis().apply(this);
        }
        outARecursifListeexp(node);
    }

    public void inAFinalListeexp(AFinalListeexp node)
    {
        defaultIn(node);
    }

    public void outAFinalListeexp(AFinalListeexp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFinalListeexp(AFinalListeexp node)
    {
        inAFinalListeexp(node);
        outAFinalListeexp(node);
    }

    public void inARecursifListeexpbis(ARecursifListeexpbis node)
    {
        defaultIn(node);
    }

    public void outARecursifListeexpbis(ARecursifListeexpbis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARecursifListeexpbis(ARecursifListeexpbis node)
    {
        inARecursifListeexpbis(node);
        if(node.getVirgule() != null)
        {
            node.getVirgule().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getListeexpbis() != null)
        {
            node.getListeexpbis().apply(this);
        }
        outARecursifListeexpbis(node);
    }

    public void inAFinalListeexpbis(AFinalListeexpbis node)
    {
        defaultIn(node);
    }

    public void outAFinalListeexpbis(AFinalListeexpbis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFinalListeexpbis(AFinalListeexpbis node)
    {
        inAFinalListeexpbis(node);
        outAFinalListeexpbis(node);
    }

    public void inAAppelfct(AAppelfct node)
    {
        defaultIn(node);
    }

    public void outAAppelfct(AAppelfct node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAppelfct(AAppelfct node)
    {
        inAAppelfct(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getListeexp() != null)
        {
            node.getListeexp().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
        outAAppelfct(node);
    }
}


