
public class Carte{
	
	private Piece [][] carte;
	
	Piece [][] generationCarte(int taille){
		carte=new Piece [taille][taille];
		
		int entreeX=(int)(Math.random() * taille+1);
		int entreeY=(int)(Math.random() * taille+1);
		int sortieX=(int)(Math.random() * taille+1);
		int sortieY=(int)(Math.random() * taille+1);
		carte[entreeX][entreeY].setRencontre(4);
		while (entreeX==sortieX || entreeY==sortieY) {
			sortieX=(int)(Math.random() * taille+1);
			sortieY=(int)(Math.random() * taille+1);
		}
		carte[sortieX][sortieY].setRencontre(5);
		
		int coffre= taille;
		int marchant= 1;
		
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j ++) {
				int rand= Piece.rencontreAleatoire();
				switch (rand) {
			    case 0:
			        if (carte[i][j].getRencontre()!=4 || carte[i][j].getRencontre()!=5) {
			        	carte[i][j].setRencontre(0);
			        }
			        break;
			    case 1:
			    	if (carte[i][j].getRencontre()!=4 || carte[i][j].getRencontre()!=5) {
			        	carte[i][j].setRencontre(1);
			        }
			        break;
			    case 2:
			    	if ((carte[i][j].getRencontre()!=4 || carte[i][j].getRencontre()!=5)&& coffre!=0) {
			        	carte[i][j].setRencontre(2);
			        	coffre-=1;
			        }
			        break;
			    case 3:
			    	if ((carte[i][j].getRencontre()!=4 || carte[i][j].getRencontre()!=5)&& marchant!=0) {
			        	carte[i][j].setRencontre(0);
			        	marchant-=1;
			        }
			        break;
				}
			}
		}
		
		return carte;
		
	}
	
	void afficher() {
		for (int i=0; i<carte.length; i++) {
			for (int j=0; j<carte.length; j ++) {
				switch (carte[j][i].getRencontre()) {
				case 0:
					System.out.print(".");
					break;
				case 1:
					System.out.print("X");
					break;
				case 2:
					System.out.print("C");
					break;
				case 3:
					System.out.print("M");
					break;
				case 4:
					System.out.print("E");
					break;
				case 5:
					System.out.print("S");
					break;
				}
				System.out.println();
			}
		}
	}
	
	

	public Piece [][] getCarte() {
		return carte;
	}

	public void setCarte(Piece [][] carte) {
		this.carte = carte;
	}

}
