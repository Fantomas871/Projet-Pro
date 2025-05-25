package StatePerso;

import Personnage.*;
//@TODO si mob passe StateVivant-->StateMort drop des golds ou un objet

public class StateMort extends StatePersonnage{
    @Override
    public void appliquerEffet(Personnage personnage){
        if(personnage instanceof Joueur){
            System.out.println("Game over " + personnage.getNom());
        } else {
            System.out.println(personnage.getNom() + " est mort et a laissé tomber quelque chose.");
            //faire drop item/gold pour joueur
        }

    }

}