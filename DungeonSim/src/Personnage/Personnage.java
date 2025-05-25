package Personnage;
import MobStrat.MobStrategy;
import StatePerso.StatePersonnage;

import java.util.ArrayList;

public abstract class Personnage {
    private MobStrategy mobStrategy;
    protected String nom;
    protected int pv;
    protected int degat;
    protected int defence;
    protected ArrayList<StatePersonnage> effetEtatPersonnage;

    public Personnage() {
        this.effetEtatPersonnage = new ArrayList<>();
    }

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

    public MobStrategy getMobStrategy() {return mobStrategy; }
    
    public ArrayList<StatePersonnage> getEffetEtatPersonnage() {
        return effetEtatPersonnage;
    }

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
    
    public void setMobStrategy(MobStrategy mobStrategy) {
        this.mobStrategy = mobStrategy;
    }
}