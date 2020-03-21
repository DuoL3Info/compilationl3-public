import sa.*;
import ts.*;

public class Sa2ts extends SaDepthFirstVisitor<Void> {

    Ts tableGlobale = new Ts();
    Ts tableLocale = new Ts();

    public Sa2ts(SaNode saRoot) {
    }

    public Ts getTableGlobale(){
        return tableGlobale;
    }

    public Ts getTableLocale(){
        return tableLocale;
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



    //DECLARATION DE TABLEAUX (EX : int a[10])
    @Override
    public Void visit(SaDecTab node) {
        TsItemVar tsItem = node.tsItem;
        //attributs utiles de tsItem

        String identif = tsItem.getIdentif(); //le nom de la variable.
        int taille = tsItem.getTaille(); //la taille mémoire occupée par la variable. Elle est égale à un pour des variables simples et, pour les tableaux, à la taille de ces derniers.
        int adresse = tsItem.getAdresse(); //adresse relative de la variable. La première variable introduite dans la table a pour adresse 0, la seconde 0 + la taille de la première variable. . .
        Ts portee = tsItem.portee; //la portée de la variable, représentée par la table à laquelle appartient la variable
        boolean isParam = tsItem.isParam; //indique si la variable est une variable (locale ou globale) ou un paramètre.

        if(portee.variables.containsKey(identif)) return null; //la table contient déjà cette variable ?


        return super.visit(node);
    }


    //DECLARATION D'UNE VARIABLE ( EX : int b )
    @Override
    public Void visit(SaDecVar node) {
        defaultIn(node);
        TsItemVar tsItem = node.tsItem;


        defaultOut(node);
        return super.visit(node);
    }

    //DECLARATION D'UNE VARIABLE (SIMPLE ?)
    @Override
    public Void visit(SaVarSimple node) {
        return super.visit(node);
    }

    //DECLARATION D'UNE VARIABLE (INDICE ?)
    @Override
    public Void visit(SaVarIndicee node) {
        return super.visit(node);
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



    //DECLARATION DE FONCTION (EX : main(){ ... })
    @Override
    public Void visit(SaDecFonc node) {
        return super.visit(node);
    }


    //APPEL DE FONCTION (EX : main())
    @Override
    public Void visit(SaAppel node) {
        return super.visit(node);
    }


}
