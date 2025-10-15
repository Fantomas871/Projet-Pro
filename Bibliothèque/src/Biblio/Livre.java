package Biblio;

public class Livre {
	
	private String titre;
	private String auteur;
	private int anneeParution;
	private String genre;
	
	public Livre(String t, String a, int an, String g){
		this.titre=t;
		this.auteur=a;
		this.anneeParution=an;
		this.genre=g;
		
	}
	
	public String toString () {
		return this.titre+", "+this.genre+" de "+this.auteur+" sorti en "+this.anneeParution;
	}

}
