package Personnage;
import StatePerso.StatePersonnage;

import java.util.ArrayList;

public abstract class Personnage {
    protected String nom;
    protected int pv;
    protected int degat;
    protected int defence;
    protected ArrayList<StatePersonnage> effetEtatPersonnage;

    protected void perdreVid(int nb){
        this.pv -= nb;
    }

    protected abstract String choisirAction();

    protected abstract String effectuerAction();


    //getter
    public int getPv() {
        return pv;
    }

    public int getDegat() {
        return degat;
    }

    public int getDefence() {
        return defence;
    }

    public String getNom() {return nom; }

    //setter
    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setDegat(int degat) {
        this.degat = degat;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setNom(String nom) {this.nom = nom; }
}