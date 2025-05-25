package MobStrat;
import Personnage.*;
import StatePerso.StateArmurePlusX;

public class Celestial extends MobStrategy {
    //@TODO booste la défense des autres mobs (StateArmurePlusX)
    @Override
    public void executeStrategy(Personnage personnage) {
        // Ajouter l'effet de boost de défense à la cible
        personnage.getEffetEtatPersonnage().add(new StateArmurePlusX());
        System.out.println(personnage.getNom() + " a reçu une protection divine.");
    }
}
