package Carte;

public class Carte{
	
	private Piece [][] carte;
	
	public Carte() {
	    // Constructeur par défaut
	}
	
	public Piece [][] generationCarte(int taille){
		carte = new Piece [taille][taille];
		
		// Initialiser toutes les pièces d'abord
		for (int i = 0; i < taille; i++) {
		    for (int j = 0; j < taille; j++) {
		        carte[i][j] = new Piece(i, j, 0);
		    }
		}
		
		// Générer l'entrée (éviter les indices hors limites)
		int entreeX = (int)(Math.random() * taille);
		int entreeY = (int)(Math.random() * taille);
		carte[entreeX][entreeY].setRencontre(4);
		
		// Générer la sortie
		int sortieX = (int)(Math.random() * taille);
		int sortieY = (int)(Math.random() * taille);
		
		while (entreeX == sortieX && entreeY == sortieY) {
			sortieX = (int)(Math.random() * taille);
			sortieY = (int)(Math.random() * taille);
		}
		carte[sortieX][sortieY].setRencontre(5);
		
		int coffre = taille;
		int marchant = 1;
		
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
			    // Ne pas modifier l'entrée et la sortie
			    if ((i == entreeX && j == entreeY) || (i == sortieX && j == sortieY)) {
			        continue;
			    }
			    
				int rand = Piece.rencontreAleatoire();
				switch (rand) {
			    case 0:
		        	carte[i][j].setRencontre(0);
			        break;
			    case 1:
		        	carte[i][j].setRencontre(1);
			        break;
			    case 2:
			    	if (coffre > 0) {
			        	carte[i][j].setRencontre(2);
			        	coffre--;
			        } else {
			            carte[i][j].setRencontre(0);
			        }
			        break;
			    case 3:
			    	if (marchant > 0) {
			        	carte[i][j].setRencontre(3); // Correction: mettre 3 pour marchand au lieu de 0
			        	marchant--;
			        } else {
			            carte[i][j].setRencontre(0);
			        }
			        break;
				}
			}
		}
		
		return carte;
	}
	
	public int [] positionDepart (Carte c){
		int[] position= new int [2];
		for (int i = 0; i < c.carte.length; i++) {
			for (int j = 0; j < c.carte.length; j++) {
				if (c.carte[i][j].getRencontre()==4) {
					position [0]=i;
					position [1]=j;
				}
			}
		}
		return position;
	}
	
	public void trueSight (Carte c) { // Fonction pour pouvoir tester le placement
		for (int i = 0; i < c.carte.length; i++) {
			for (int j = 0; j < c.carte.length; j++) {
				c.carte[i][j].setVisible(true);
			}
		}
	}
	
	public int thisRencontre (int x, int y, Carte c) {
		int rencontre = c.carte[x][y].getRencontre();
		return rencontre;
		
	}
	
	public void afficher() {
		for (int i = 0; i < carte.length; i++) {
			for (int j = 0; j < carte.length; j++) {
				switch (carte[j][i].getRencontre()) {
				case 0:
					if (carte[j][i].isVisible()) {
						System.out.print(". ");
						break;
					}else{
						System.out.print("? ");
						break;
					}
				case 1:
					if (carte[j][i].isVisible()) {
						System.out.print("X ");
						break;
					}else{
						System.out.print("? ");
						break;
					}
				case 2:
					if (carte[j][i].isVisible()) {
						System.out.print("C ");
						break;
					}else{
						System.out.print("? ");
						break;
					}
				case 3:
					if (carte[j][i].isVisible()) {
						System.out.print("M ");
						break;
					}else{
						System.out.print("? ");
						break;
					}
				case 4:
					if (carte[j][i].isVisible()) {
						System.out.print("E ");
						break;
					}else{
						System.out.print("? ");
						break;
					}
				case 5:
					if (carte[j][i].isVisible()) {
						System.out.print("S");
						break;
					}else{
						System.out.print("?");
						break;
					}
				}
			}
			System.out.println(); // Saut de ligne après chaque ligne, pas après chaque cellule
		}
	}
	
	

	public Piece [][] getCarte() {
		return carte;
	}

	public void setCarte(Piece [][] carte) {
		this.carte = carte;
	}


}
