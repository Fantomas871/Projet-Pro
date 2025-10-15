package Personnage;
//@TODO implémenter la vente d'objet, ou le one shot du joueur si il est attaqué

import java.util.ArrayList;

import Objet.Objet;
import Factory.*;

public class Marchand extends Personnage{
	private ArrayList<Objet> inventaire;
    public Marchand(String n, int pv, int dmg, int dfc) {
		super(n, pv, dmg, dfc);
		// TODO Auto-generated constructor stub
	}

	@Override
    protected String choisirAction() {
        return "";
    }
    @Override
    protected String effectuerAction() {
        return "";
    }
    
    public void montrerMarchandise() {
    	for (int i=0;i<this.inventaire.size();i++) {
    		this.inventaire.get(i).toString();
    	}
    }
    
    public void remplirIventaire () {
    	for (int i=0;i<10;i++) {
    		String [] type = {"degats","protection","soin"};
    		String random = type[(int)Math.random()*3+1];
    		this.inventaire.add(FactoryObjet.creerObjet(random));
    	}
    }

	public ArrayList<Objet> getInventaire() {
		return inventaire;
	}

	public void setInventaire(ArrayList<Objet> inventaire) {
		this.inventaire = inventaire;
	}

}
