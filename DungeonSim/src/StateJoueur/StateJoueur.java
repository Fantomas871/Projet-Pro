package StateJoueur;

import Personnage.Joueur;

public abstract class StateJoueur {

    protected Joueur joueur;

    abstract public void afficheChoix();
    abstract public void transitionEtat(String etat);
}
