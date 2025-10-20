package Biblio;

import java.util.ArrayList;

public class Bibliotheque {
	
	private String nom;
	private ArrayList<Livre> bibliotheque;
	private ArrayList<Adherent> adherents;
	
	Bibliotheque (String n){
		
		this.nom=n;
		this.bibliotheque = new ArrayList<Livre>();
		this.adherents = new ArrayList<Adherent>();
		
	}

	public void ajouterLivre(Livre l) {
		this.bibliotheque.add(l);
	}

	public void ajouterAdherent(Adherent a) {
		this.adherents.add(a);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Livre> getBibliotheque() {
		return bibliotheque;
	}

	public void setBibliotheque(ArrayList<Livre> bibliotheque) {
		this.bibliotheque = bibliotheque;
	}

	public ArrayList<Adherent> getAdherents() {
		return adherents;
	}

	public void setAdherents(ArrayList<Adherent> adherents) {
		this.adherents = adherents;
	}
}
