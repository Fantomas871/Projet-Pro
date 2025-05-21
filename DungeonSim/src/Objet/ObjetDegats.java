package Objet;

public class ObjetDegats extends Objet {

	private int dmg;
	
	public ObjetDegats(int p, int d) {
		super(p);
		this.setDmg(d);
		
	}
	
	public String toString () {
		return "Cet objet coûte "+this.getPrix()+" pièces d'or et inflige "+this.dmg+" supplémentaire";
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

}
