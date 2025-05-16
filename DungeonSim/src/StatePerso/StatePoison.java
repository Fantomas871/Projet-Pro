package StatePerso;

import MobStrat.MortVivant;
import Personnage.*;

public class StatePoison extends StatePersonnage{
    void appliquerEffet(Personnage personnage){
        int degatPoison = (int) (  Math.round(personnage.getPv()*0.01));
        if(personnage instanceof Joueur){
            personnage.setPv(personnage.getPv()- degatPoison);
            System.out.println(personnage.getNom() + " prend " + degatPoison + " dégat de poison");
        } else if((personnage instanceof Ennemie)&&(personnage.getMobStrategy() instanceof MortVivant)){
            System.out.println(personnage.getNom() + " résiste au degat de poison");
        } else {
            personnage.setPv(personnage.getPv() - degatPoison);
            System.out.println(personnage.getNom() + " prend " + degatPoison + " dégat de poison");
        }

    }
}