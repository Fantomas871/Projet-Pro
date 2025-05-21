package Objet;

public abstract class Objet {
	
	private int prix;
	
	public Objet(int p) {
		this.prix=p;
	}

	public abstract String toString ();

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	

}
