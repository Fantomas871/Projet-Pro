package MobStrat;
import Personnage.*;
import StatePerso.StateSaigne;

public class Infernal extends MobStrategy {
    //@TODO donne l'effet de saignement losqu'il attaque
    @Override
    public void executeStrategy(Personnage personnage) {
        // Ajouter l'effet de saignement à la cible
        personnage.getEffetEtatPersonnage().add(new StateSaigne());
        System.out.println(personnage.getNom() + " commence à saigner.");
    }
}
