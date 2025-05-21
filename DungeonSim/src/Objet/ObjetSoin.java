package Objet;

public class ObjetSoin extends Objet{

	private int soin;
	
	ObjetSoin(int p, int s){
		super(p);
		this.soin=s;
	}
	
	@Override
	public String toString() {
		
		return "Cet objet coûte "+this.getPrix()+" pièces d'or et soigne "+this.soin+" points de vie";
	}
	
	
	

	public int getSoin() {
		return soin;
	}

	public void setSoin(int soin) {
		this.soin = soin;
	}
	
	

}
