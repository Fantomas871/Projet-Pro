package StatePerso;

import Personnage.Personnage;

public class StateArmurePlusX extends StatePersonnage{
    void appliquerEffet(Personnage personnage){
        personnage.setDefence(personnage.getDefence()*2);
        System.out.println(personnage.getNom() + "double sa défense");
    }


}