package StateJoueur;

import Personnage.Joueur;

public abstract class StateJoueur {

    protected Joueur joueur;

    public StateJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public abstract void afficheChoix();

    public abstract void transitionEtat(String etat);
}
