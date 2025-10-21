package Biblio;

import java.util.ArrayList;

public class Adherent {
	
	String nom;
	LivrePhysique [] listeLivrePhysique = new LivrePhysique [5];
	ArrayList<Ebook> listeEbook;

	public Adherent(String nom) {
		this.nom = nom;
		this.listeEbook = new ArrayList<Ebook>();
	}

	public void emprunterLivrePhysique(LivrePhysique livre) {
		for (int i = 0; i < listeLivrePhysique.length; i++) {
			if (listeLivrePhysique[i] == null && livre.getEtat().toString().equals("Disponible")) {
				listeLivrePhysique[i] = livre;
				System.out.println(nom + " a emprunté le livre physique : " + livre.getTitre());
				return;
			}else if (listeLivrePhysique[i] == null && livre.getEtat().toString().equals("Emprunté")) {
				System.out.println("Le livre physique : " + livre.getTitre() + " est emprunté, il est désormais réservé pour vous.");
				listeLivrePhysique[i] = livre;
				return;
			}
		}
		System.out.println(nom + " ne peut pas emprunter plus de livres physiques.");
	}

	public void rendreLivrePhysique(LivrePhysique livre){
		if (livre.getEtat().toString().equals("Emprunté")){
			for (int i=0; i<listeLivrePhysique.length; i++){
				if (listeLivrePhysique[i].getTitre() == livre.getTitre()){
					listeLivrePhysique[i] = null;
					livre.getEtat().libre();
					System.out.println(nom + " a rendu le livre physique : " + livre.getTitre());
					return;
				}
		}
		}else if (livre.getEtat().toString().equals("Réservé")){
			for (int i=0; i<listeLivrePhysique.length; i++){
				if (listeLivrePhysique[i].getTitre() == livre.getTitre()){
					listeLivrePhysique[i] = null;
					livre.getEtat().emprunt();
					System.out.println(nom + " a rendu le livre physique : " + livre.getTitre());
					return;
				}
			}
		}
	}

	public String toString() {
		return "Adherent [nom=" + nom + ", listeLivrePhysique=" + listeLivrePhysique + ", listeEbook=" + listeEbook
				+ "]";
	}

	// Getters
	public String getNom() {
		return nom;
	}

	public LivrePhysique[] getListeLivrePhysique() {
		return listeLivrePhysique;
	}

	public ArrayList<Ebook> getListeEbook() {
		return listeEbook;
	}

}
