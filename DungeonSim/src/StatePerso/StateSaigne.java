package StatePerso;

import Personnage.Personnage;

public class StateSaigne extends StatePersonnage{
    void appliquerEffet(Personnage personnage){
        int degatSaignement = (int) (  Math.round(personnage.getPv()*0.01));
        if(Personnage == Joueur){
            personnage.setPv(personnage.getPv()- degatSaignement);
            System.out.println(personnage.getNom() + " prend " + degatSaignement + " dégat de saignement");
        } else if(personnage.mobStrategy==Infernal){
            System.out.println(personnage.getNom() + " résiste au degat de saignement");
        } else {
            personnage.setPv(personnage.getPv()- degatSaignement);
            System.out.println(personnage.getNom() + " prend " + degatSaignement + " dégat de saignement");
        }


    }

}