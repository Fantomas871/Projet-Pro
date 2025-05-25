package StatePerso;

import Personnage.Personnage;

public class StateDegatPlusX extends StatePersonnage{
    @Override
    public void appliquerEffet(Personnage personnage){
        personnage.setDegat(personnage.getDegat()*2);
        System.out.println(personnage.getNom() + " double son attaque");


    }
}