package Personnage;

import java.util.Objects;

public class Joueur extends Personnage{

    Joueur(String n, int pv, int dmg, int dfc) {
		super(n, pv, dmg, dfc);
		// TODO Auto-generated constructor stub
	}

	@Override
    protected String choisirAction() {
        return "";
    }

    @Override
    protected String effectuerAction() {
        return "";
    }



}
