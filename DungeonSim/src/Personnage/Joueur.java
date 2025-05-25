package Personnage;

import StateJoueur.*;

import java.util.Scanner;

public class Joueur extends Personnage {

    private StateJoueur etatJoueur;

    public Joueur() {
        super(); // Appel au constructeur parent pour initialiser les listes
        this.setNom("Joueur");
        this.setPv(100);
        this.setDegat(15);
        this.setDefence(10);
    }

    public Joueur(StateJoueur etatJoueur) {
        this(); // Appel au constructeur par défaut
        this.etatJoueur = etatJoueur;
    }

    public StateJoueur getEtatJoueur() {
        return etatJoueur;
    }

    public void setEtatJoueur(StateJoueur etatJoueur) {
        this.etatJoueur = etatJoueur;
    }

    @Override
    protected String choisirAction() {
        if (etatJoueur != null) {
            etatJoueur.afficheChoix();
        }
        
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    //@TODO implémenter le choix d'action selon l'état du joueur
    @Override
    protected String effectuerAction() {
        String action = choisirAction();
        // Traitement de l'action selon l'état du joueur
        return action;
    }
}
