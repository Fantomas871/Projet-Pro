

public class Piece {
	
	private int x, y; // Coordonnées de la pièce sur la carte
	private int rencontre; // aléatoire entre 0 et 5 avec 0=rien 1=ennemi 2=coffre 3=marchant 4=entrée 5=sortie
	
	
	Piece (int x, int y, int r){
		this.x=x;
		this.y=y;
		this.rencontre=r;
	}
	
	static int rencontreAleatoire () {
		int rand=(int)(Math.random() * 4);
		return rand;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getRencontre() {
		return rencontre;
	}
	public void setRencontre(int rencontre) {
		this.rencontre = rencontre;
	}
	
	
	
	
}
