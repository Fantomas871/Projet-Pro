package Personnage;

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
