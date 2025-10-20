package StateLivre;

import Biblio.LivrePhysique;

public class EmprunteState implements StateLivre {
	private final LivrePhysique livre;

    public EmprunteState(LivrePhysique livre) {
    	this.livre = livre;
    }

    @Override
    public void libre() {
    	this.livre.setEtat(new LibreState(this.livre));
        System.out.println("Livre rendu");
    }

    @Override
    public void emprunt() {
        System.out.println("Impossible : le livre est déjà emprunté.");
    }

    @Override
    public void reserve() {
    	this.livre.setEtat(new ReserveState(this.livre));
        System.out.println("Livre réservé");
    }

    @Override
    public String toString() {
        return "Emprunté";
    }
}