package StatePerso;

import Personnage.*;
import MobStrat.*;

public class StateSaigne extends StatePersonnage{
    void appliquerEffet(Personnage personnage){
        int degatSaignement = (int) (  Math.round(personnage.getPv()*0.01));
        if(personnage instanceof Joueur){
            personnage.setPv(personnage.getPv()- degatSaignement);
            System.out.println(personnage.getNom() + " prend " + degatSaignement + " dégat de saignement");
        } else if(personnage.getMobStrategy() instanceof Infernal){
            System.out.println(personnage.getNom() + " résiste au degat de saignement");
        } else {
            personnage.setPv(personnage.getPv()- degatSaignement);
            System.out.println(personnage.getNom() + " prend " + degatSaignement + " dégat de saignement");
        }


    }

}