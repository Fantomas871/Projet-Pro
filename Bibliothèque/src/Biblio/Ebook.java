package Biblio;


public class Ebook extends Livre{
	
	double prixEmprunt; // prix de l'emprunt en € par mois

	public Ebook(String t, String a, int an, String g) {
		super(t, a, an, g);
		prixEmprunt = 0.4;
	}

}
