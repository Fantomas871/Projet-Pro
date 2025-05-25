package StatePerso;

import Personnage.Personnage;

public class StateArmurePlusX extends StatePersonnage{
    @Override
    public void appliquerEffet(Personnage personnage){
        personnage.setDefence(personnage.getDefence()*2);
        System.out.println(personnage.getNom() + " double sa défense");
    }


}