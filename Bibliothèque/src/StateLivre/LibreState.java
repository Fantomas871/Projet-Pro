package StateLivre;

import Biblio.LivrePhysique;

public class LibreState implements StateLivre {
    private final LivrePhysique livre;

    public LibreState(LivrePhysique livre) {
        this.livre = livre;
    }

    @Override
    public void libre() {
        System.out.println("Le livre est déjà libre.");
    }

    @Override
    public void emprunt() {
        // transition vers EmprunteState
    	this.livre.setEtat(new EmprunteState(this.livre));
        System.out.println("Livre emprunté");
    }

    @Override
    public void reserve() {
        
        System.out.println("Impossible de passer de Libre à Réservé");
    }

    @Override
    public String toString() {
        return "Disponible";
    }
}
