package Personnage;
//@TODO implémenter la vente d'objet, ou le one shot du joueur si il est attaqué

public class Marchand extends Personnage{
	
    Marchand(String n, int pv, int dmg, int dfc) {
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
