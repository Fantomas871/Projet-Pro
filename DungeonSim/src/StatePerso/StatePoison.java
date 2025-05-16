package StatePerso;

import Personnage.Personnage;

public class StatePoison extends StatePersonnage{
    void appliquerEffet(Personnage personnage){
        int degatPoison = (int) (  Math.round(personnage.getPv()*0.01));
        if(Personnage == Joueur){
            personnage.setPv(personnage.getPv()- degatPoison);
            System.out.println(personnage.getNom() + " prend " + degatPoison + " dégat de poison");
        } else if(personnage.mobStrategy==MortVivant){
            System.out.println(personnage.getNom() + " résiste au degat de poison");
        } else {
            personnage.setPv(personnage.getPv()- degatPoison);
            System.out.println(personnage.getNom() + " prend " + degatPoison + " dégat de poison");
        }

    }
}