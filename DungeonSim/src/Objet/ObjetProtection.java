package Objet;

public class ObjetProtection extends Objet{

	private int protection;
	
	public ObjetProtection(int p, int pp) {
		super(p);
		this.protection=pp;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Cet objet coûte "+this.getPrix()+" pièces d'or et protège de la perte de "+this.protection+" points de vie";
	}

	public int getProtection() {
		return protection;
	}

	public void setProtection(int protection) {
		this.protection = protection;
	}

}
