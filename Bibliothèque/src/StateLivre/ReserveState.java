package StateLivre;

import Biblio.LivrePhysique;

public class ReserveState implements StateLivre {
	private final LivrePhysique livre;

    public ReserveState(LivrePhysique livre) {
        this.livre = livre;
    }

    @Override
    public void libre() {
        System.out.println("Impossible le livre est réservé");
    }

    @Override
    public void emprunt() {
    	this.livre.setEtat(new EmprunteState(this.livre));
        System.out.println("L'ancien propriétaire a rendu le livre il est maintenant pour vous");
    }

    @Override
    public void reserve() {
        System.out.println("Le livre est déjà réservé");
    }

    @Override
    public String toString() {
        return "Réservé";
    }
}