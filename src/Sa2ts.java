import sa.*;
import ts.*;

public class Sa2ts extends SaDepthFirstVisitor<Void> {

    Ts tableGlobale = new Ts();
    Ts tableLocale;
    int nb_param = 0;

    public Sa2ts(SaNode saRoot) {
        visit((SaProg) saRoot);
    }

    public Ts getTableGlobale(){
        return tableGlobale;
    }


//3.1. Variables.
//    Lors de la déclaration, vérifier que :
//            — Il n’y a pas deux variables identiques déclarées dans une même portée
//              — Les variables locales et les arguments peuvent avoir le même nom qu’une variable globale.
//              — Il n’est pas possible de déclarer une variable locale qui a le même nom qu’un argument.
//            — Un tableau est toujours une variable globale
//    Lors de l’appel dans une affectation ou expression, vérifier que :
//            — Toute variable utilisée est déclarée en tant que (recherche dans l’ordre) :
//            — (1) Variable locale ou (2) argument de fonction ou (3) variable globale.
//            — Les tableaux ne peuvent jamais être utilisés sans indice
//— Les entiers ne peuvent jamais être indicés
//— Aucune conversion ou coercition n’est possible
//— Il n’y a pas de vérification de dépassement des bornes du tableau


    //DECLARATION DE TABLEAUX
    @Override
    public Void visit(SaDecTab node) {
        defaultIn(node);
        if(tableLocale != null) {
            if (tableGlobale.variables.size() < nb_param)
                tableLocale.addVar(node.getNom(), node.getTaille());
            else
                tableLocale.addParam(node.getNom());
        }
        else
            tableGlobale.addVar(node.getNom() ,node.getTaille());
        defaultOut(node);
        return null;
    }


    //DECLARATION D'UNE VARIABLE
    @Override
    public Void visit(SaDecVar node) {
        defaultIn(node);
        if(tableLocale != null) {
            if (tableLocale.variables.size() < nb_param)
                tableLocale.addParam(node.getNom());
            else
                tableLocale.addVar(node.getNom(),1);
        }
        else
            tableGlobale.addVar(node.getNom(),1);
        defaultOut(node);
        return null;
    }

    //DECLARATION D'UNE VARIABLE (SIMPLE ?)
    @Override
    public Void visit(SaVarSimple node) {
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    //DECLARATION D'UNE VARIABLE (INDICE ?)
    @Override
    public Void visit(SaVarIndicee node) {
        defaultIn(node);
        defaultOut(node);
        return null;
    }


    //3.2. Fonctions.
//    Lors de la déclaration, vérifier que :
//            — Il n’y a pas deux fonctions identiques déclarées à des endroits différents
//— Il n’y a pas de polymorphisme en L, c’est-à-dire, deux fonctions sont identiques si leurs
//    identificateurs sont identiques (indépendamment du nombre de paramètres)
//    Lors de l’appel dans une instruction ou expression, vérifier que :
//            — Toute fonction appelée doit être déclarée avant dans le programme
//— Le nombre d’arguments réels passés à la fonction appelée est identique au nombre d’arguments formels dans la déclaration
//— Il existe une fonction sans arguments qui s’appelle main
//    Votre compilateur ne doit pas vérifier :
//            — Le type de retour d’une fonction : c’est toujours un entier
//— Le type d’un argument : c’est toujours un entier
//— Toute branche d’exécution contient une instruction retour



    //DECLARATION DE FONCTION
    @Override
    public Void visit(SaDecFonc node) {
        defaultIn(node);
        if(node.getParametres()==null)
            nb_param = 0;
        else
            nb_param = node.getParametres().length();
        tableLocale = new Ts();
        tableGlobale.addFct(node.getNom(), nb_param, tableLocale, node);
        defaultOut(node);
        return null;
    }


    //APPEL DE FONCTION
    @Override
    public Void visit(SaAppel node) {
        defaultIn(node);
        defaultOut(node);
        return null;
    }
}
