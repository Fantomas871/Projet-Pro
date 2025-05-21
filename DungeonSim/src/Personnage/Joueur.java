package Personnage;

import StateJoueur.*;

import java.util.Locale;
import java.util.Scanner;

public class Joueur extends Personnage {

    private StateJoueur etatJoueur;

    public Joueur(StateJoueur etatJoueur) {
        this.etatJoueur = etatJoueur;
    }

    public void setEtatJoueur(StateJoueur etatJoueur) {
        this.etatJoueur = etatJoueur;
    }

    @Override
    protected String choisirAction() {
        etatJoueur.afficheChoix();
        return "";
    }


    //@TODO implémenter le choix d'action selon l'état du joueur
    @Override
    protected String effectuerAction() {
        return "";
    }
    //@TODO implémenter l'effer de l'action


}
