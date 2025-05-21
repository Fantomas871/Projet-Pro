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

    Personnage (String n, int pv, int dmg, int dfc){
    	this.nom=n;
    	this.pv=pv;
    	this.degat=dmg;
    	this.defence=dfc;
    }
    
    protected void perdreVid(int dmg, int dfc){
        this.pv -= dmg-dfc;
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