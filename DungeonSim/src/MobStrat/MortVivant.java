package MobStrat;
import Personnage.*;
import StatePerso.StatePoison;

public class MortVivant extends MobStrategy {
    //@TODO donne l'état poison à ses attaques
    @Override
    public void executeStrategy(Personnage personnage) {
        // Ajouter l'effet de poison à la cible
        personnage.getEffetEtatPersonnage().add(new StatePoison());
        System.out.println(personnage.getNom() + " est empoisonné.");
    }
}
