package Personnage;

import StateJoueur.*;

import java.util.Locale;
import java.util.Scanner;

public class Joueur extends Personnage{

    private StateJoueur etatJoueur;


    Joueur(StateJoueur etatJoueur){
        this.etatJoueur = new Menu();
    }

    @Override
    protected String choisirAction() {
        etatJoueur.afficheChoix(); //selon l'état du joueur, affiche les commandes du menu, de combat, de déplacement ou d'interaction

        return "";
    }
    //@TODO implémenter le choix d'action selon l'état du joueur
    @Override
    protected String effectuerAction() {
        return "";
    }
    //@TODO implémenter l'effer de l'action


}
