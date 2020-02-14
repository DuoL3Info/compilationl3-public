import sa.*;
import sc.analysis.DepthFirstAdapter;
import sc.node.*;


public class Sc2sa extends DepthFirstAdapter {
        private SaNode returnValue;


    // exp3 = {plus} exp3 plus exp4
    public void caseAPlusExp3(APlusExp3 node) {
        SaExp op1 = null;
        SaExp op2 = null;
        node.getExp3().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp4().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpAdd(op1, op2);
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
        this.returnValue = new SaProg(fonctions);
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
        inAOptdecvar(node);
        if(node.getListedecvar() != null)
        {
            node.getListedecvar().apply(this);
        }
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAOptdecvar(node);
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
        inADecvarldecvarListedecvar(node);
        if(node.getDecvar() != null)
        {
            node.getDecvar().apply(this);
        }
        if(node.getListedecvarbis() != null)
        {
            node.getListedecvarbis().apply(this);
        }
        outADecvarldecvarListedecvar(node);
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
        inADecvarListedecvar(node);
        if(node.getDecvar() != null)
        {
            node.getDecvar().apply(this);
        }
        outADecvarListedecvar(node);
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
        inADecvarldecvarListedecvarbis(node);
        if(node.getVirgule() != null)
        {
            node.getVirgule().apply(this);
        }
        if(node.getDecvar() != null)
        {
            node.getDecvar().apply(this);
        }
        if(node.getListedecvarbis() != null)
        {
            node.getListedecvarbis().apply(this);
        }
        outADecvarldecvarListedecvarbis(node);
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
        inADecvarListedecvarbis(node);
        if(node.getVirgule() != null)
        {
            node.getVirgule().apply(this);
        }
        if(node.getDecvar() != null)
        {
            node.getDecvar().apply(this);
        }
        outADecvarListedecvarbis(node);
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
        inADecvarentierDecvar(node);
        if(node.getEntier() != null)
        {
            node.getEntier().apply(this);
        }
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        outADecvarentierDecvar(node);
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
        inADecvartableauDecvar(node);
        if(node.getEntier() != null)
        {
            node.getEntier().apply(this);
        }
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getCrochetOuvrant() != null)
        {
            node.getCrochetOuvrant().apply(this);
        }
        if(node.getNombre() != null)
        {
            node.getNombre().apply(this);
        }
        if(node.getCrochetFermant() != null)
        {
            node.getCrochetFermant().apply(this);
        }
        outADecvartableauDecvar(node);
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
        inAInstraffectInstr(node);
        if(node.getInstraffect() != null)
        {
            node.getInstraffect().apply(this);
        }
        outAInstraffectInstr(node);
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
        inAInstrblocInstr(node);
        if(node.getInstrbloc() != null)
        {
            node.getInstrbloc().apply(this);
        }
        outAInstrblocInstr(node);
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
        inAInstrsiInstr(node);
        if(node.getInstrsi() != null)
        {
            node.getInstrsi().apply(this);
        }
        outAInstrsiInstr(node);
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
        inAInstrtantqueInstr(node);
        if(node.getInstrtantque() != null)
        {
            node.getInstrtantque().apply(this);
        }
        outAInstrtantqueInstr(node);
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
        inAInstrappelInstr(node);
        if(node.getInstrappel() != null)
        {
            node.getInstrappel().apply(this);
        }
        outAInstrappelInstr(node);
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
        inAInstrretourInstr(node);
        if(node.getInstrretour() != null)
        {
            node.getInstrretour().apply(this);
        }
        outAInstrretourInstr(node);
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
        inAInstrecritureInstr(node);
        if(node.getInstrecriture() != null)
        {
            node.getInstrecriture().apply(this);
        }
        outAInstrecritureInstr(node);
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
        inAInstrvideInstr(node);
        if(node.getInstrvide() != null)
        {
            node.getInstrvide().apply(this);
        }
        outAInstrvideInstr(node);
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
        inAInstraffect(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        if(node.getEgal() != null)
        {
            node.getEgal().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAInstraffect(node);
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
        inAInstrbloc(node);
        if(node.getAccoladeOuvrante() != null)
        {
            node.getAccoladeOuvrante().apply(this);
        }
        if(node.getListeinst() != null)
        {
            node.getListeinst().apply(this);
        }
        if(node.getAccoladeFermante() != null)
        {
            node.getAccoladeFermante().apply(this);
        }
        outAInstrbloc(node);
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
        inALinstrecListeinst(node);
        if(node.getInstr() != null)
        {
            node.getInstr().apply(this);
        }
        if(node.getListeinst() != null)
        {
            node.getListeinst().apply(this);
        }
        outALinstrecListeinst(node);
    }

    public void inALinstfinalListeinst(ALinstfinalListeinst node)
    {
        defaultIn(node);
    }

    public void outALinstfinalListeinst(ALinstfinalListeinst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALinstfinalListeinst(ALinstfinalListeinst node)
    {
        inALinstfinalListeinst(node);
        outALinstfinalListeinst(node);
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
        inAAvecsinonInstrsi(node);
        if(node.getSi() != null)
        {
            node.getSi().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getAlors() != null)
        {
            node.getAlors().apply(this);
        }
        if(node.getInstrbloc() != null)
        {
            node.getInstrbloc().apply(this);
        }
        if(node.getInstrsinon() != null)
        {
            node.getInstrsinon().apply(this);
        }
        outAAvecsinonInstrsi(node);
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
        inASanssinonInstrsi(node);
        if(node.getSi() != null)
        {
            node.getSi().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getAlors() != null)
        {
            node.getAlors().apply(this);
        }
        if(node.getInstrbloc() != null)
        {
            node.getInstrbloc().apply(this);
        }
        outASanssinonInstrsi(node);
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
        inAInstrsinon(node);
        if(node.getSinon() != null)
        {
            node.getSinon().apply(this);
        }
        if(node.getInstrbloc() != null)
        {
            node.getInstrbloc().apply(this);
        }
        outAInstrsinon(node);
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
        inAInstrtantque(node);
        if(node.getTantque() != null)
        {
            node.getTantque().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getFaire() != null)
        {
            node.getFaire().apply(this);
        }
        if(node.getInstrbloc() != null)
        {
            node.getInstrbloc().apply(this);
        }
        outAInstrtantque(node);
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
        inAInstrappel(node);
        if(node.getAppelfct() != null)
        {
            node.getAppelfct().apply(this);
        }
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAInstrappel(node);
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
        inAInstrretour(node);
        if(node.getRetour() != null)
        {
            node.getRetour().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAInstrretour(node);
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
        inAInstrecriture(node);
        if(node.getEcrire() != null)
        {
            node.getEcrire().apply(this);
        }
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAInstrecriture(node);
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
        inAInstrvide(node);
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAInstrvide(node);
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
        inAOuExp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getOu() != null)
        {
            node.getOu().apply(this);
        }
        if(node.getExp1() != null)
        {
            node.getExp1().apply(this);
        }
        outAOuExp(node);
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
        inAExp1Exp(node);
        if(node.getExp1() != null)
        {
            node.getExp1().apply(this);
        }
        outAExp1Exp(node);
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
        inAEtExp1(node);
        if(node.getExp1() != null)
        {
            node.getExp1().apply(this);
        }
        if(node.getEt() != null)
        {
            node.getEt().apply(this);
        }
        if(node.getExp2() != null)
        {
            node.getExp2().apply(this);
        }
        outAEtExp1(node);
    }

    public void inAExp2Exp1(AExp2Exp1 node)
    {
        defaultIn(node);
    }

    public void outAExp2Exp1(AExp2Exp1 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExp2Exp1(AExp2Exp1 node)
    {
        inAExp2Exp1(node);
        if(node.getExp2() != null)
        {
            node.getExp2().apply(this);
        }
        outAExp2Exp1(node);
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
        inAInfExp2(node);
        if(node.getExp2() != null)
        {
            node.getExp2().apply(this);
        }
        if(node.getInferieur() != null)
        {
            node.getInferieur().apply(this);
        }
        if(node.getExp3() != null)
        {
            node.getExp3().apply(this);
        }
        outAInfExp2(node);
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
        inAEgalExp2(node);
        if(node.getExp2() != null)
        {
            node.getExp2().apply(this);
        }
        if(node.getEgal() != null)
        {
            node.getEgal().apply(this);
        }
        if(node.getExp3() != null)
        {
            node.getExp3().apply(this);
        }
        outAEgalExp2(node);
    }

    public void inAExp3Exp2(AExp3Exp2 node)
    {
        defaultIn(node);
    }

    public void outAExp3Exp2(AExp3Exp2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExp3Exp2(AExp3Exp2 node)
    {
        inAExp3Exp2(node);
        if(node.getExp3() != null)
        {
            node.getExp3().apply(this);
        }
        outAExp3Exp2(node);
    }

    public void inAPlusExp3(APlusExp3 node)
    {
        defaultIn(node);
    }

    public void outAPlusExp3(APlusExp3 node)
    {
        defaultOut(node);
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
        inAMoinsExp3(node);
        if(node.getExp3() != null)
        {
            node.getExp3().apply(this);
        }
        if(node.getMoins() != null)
        {
            node.getMoins().apply(this);
        }
        if(node.getExp4() != null)
        {
            node.getExp4().apply(this);
        }
        outAMoinsExp3(node);
    }

    public void inAExp4Exp3(AExp4Exp3 node)
    {
        defaultIn(node);
    }

    public void outAExp4Exp3(AExp4Exp3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExp4Exp3(AExp4Exp3 node)
    {
        inAExp4Exp3(node);
        if(node.getExp4() != null)
        {
            node.getExp4().apply(this);
        }
        outAExp4Exp3(node);
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
        inAFoisExp4(node);
        if(node.getExp4() != null)
        {
            node.getExp4().apply(this);
        }
        if(node.getFois() != null)
        {
            node.getFois().apply(this);
        }
        if(node.getExp5() != null)
        {
            node.getExp5().apply(this);
        }
        outAFoisExp4(node);
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
        inADiviseExp4(node);
        if(node.getExp4() != null)
        {
            node.getExp4().apply(this);
        }
        if(node.getDivise() != null)
        {
            node.getDivise().apply(this);
        }
        if(node.getExp5() != null)
        {
            node.getExp5().apply(this);
        }
        outADiviseExp4(node);
    }

    public void inAExp5Exp4(AExp5Exp4 node)
    {
        defaultIn(node);
    }

    public void outAExp5Exp4(AExp5Exp4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExp5Exp4(AExp5Exp4 node)
    {
        inAExp5Exp4(node);
        if(node.getExp5() != null)
        {
            node.getExp5().apply(this);
        }
        outAExp5Exp4(node);
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
        inANonExp5(node);
        if(node.getNon() != null)
        {
            node.getNon().apply(this);
        }
        if(node.getExp5() != null)
        {
            node.getExp5().apply(this);
        }
        outANonExp5(node);
    }

    public void inAExp6Exp5(AExp6Exp5 node)
    {
        defaultIn(node);
    }

    public void outAExp6Exp5(AExp6Exp5 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExp6Exp5(AExp6Exp5 node)
    {
        inAExp6Exp5(node);
        if(node.getExp6() != null)
        {
            node.getExp6().apply(this);
        }
        outAExp6Exp5(node);
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
        inANombreExp6(node);
        if(node.getNombre() != null)
        {
            node.getNombre().apply(this);
        }
        outANombreExp6(node);
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
        inAAppelfctExp6(node);
        if(node.getAppelfct() != null)
        {
            node.getAppelfct().apply(this);
        }
        outAAppelfctExp6(node);
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
        inAVarExp6(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outAVarExp6(node);
    }

    public void inAParenthesesExp6(AParenthesesExp6 node)
    {
        defaultIn(node);
    }

    public void outAParenthesesExp6(AParenthesesExp6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParenthesesExp6(AParenthesesExp6 node)
    {
        inAParenthesesExp6(node);
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
        outAParenthesesExp6(node);
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
        inALireExp6(node);
        if(node.getLire() != null)
        {
            node.getLire().apply(this);
        }
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
        outALireExp6(node);
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
    public void caseAVarsimpleVar(AVarsimpleVar node)
    {
        inAVarsimpleVar(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        outAVarsimpleVar(node);
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


