package Biblio;

public class LivrePhysique extends Livre{
	
	double prixEmprunt; // prix de l'emprunt en € par mois
	private StateLivre.StateLivre etat;

	public LivrePhysique(String t, String a, int an, String g) {
		super(t, a, an, g);
		prixEmprunt = 0.8;
		setEtat(new StateLivre.LibreState(this));
	}

	public StateLivre.StateLivre getEtat() {
		return etat;
	}

	public void setEtat(StateLivre.StateLivre etat) {
		this.etat = etat;
	}

}
