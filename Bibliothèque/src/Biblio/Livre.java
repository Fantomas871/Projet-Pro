package Biblio;

public class Livre {
	
	private String titre;
	private String auteur;
	private int anneeParution;
	private String genre;
	
	public Livre(String t, String a, int an, String g){
		this.titre = t;
		this.auteur = a;
		this.anneeParution = an;
		this.genre = g;
	}
	
	public String toString() {
		return this.titre + ", " + this.genre + " de " + this.auteur + " sorti en " + this.anneeParution;
	}

	// Getters
	public String getTitre() {
		return titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public int getAnneeParution() {
		return anneeParution;
	}

	public String getGenre() {
		return genre;
	}

	// Setters
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public void setAnneeParution(int anneeParution) {
		this.anneeParution = anneeParution;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
