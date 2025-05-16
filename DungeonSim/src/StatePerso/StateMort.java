package StatePerso;

import Personnage.*;

public class StateMort extends StatePersonnage{
    void appliquerEffet(Personnage personnage){
        if(personnage instanceof Joueur){//classe Joueur à créer
            System.out.println("Game over " + personnage.getNom());
        } else {
            //faire drop item/gold pour joueur
        }

    }

}