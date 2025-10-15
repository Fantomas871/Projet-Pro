package Factory;

import java.util.Scanner;

import Biblio.Livre;

class LivreFactory {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static Livre creerLivre() {
		System.out.print("Titre: ");
		String titre = scanner.nextLine().trim();
		System.out.print("Auteur: ");
		String auteur = scanner.nextLine().trim();
		System.out.print("Année de paution: ");
		int annee = Integer.parseInt(scanner.nextLine().trim());
		System.out.print("Genre: ");
		String genre = scanner.nextLine().trim();
		System.out.print("Categorie: ");
		String categorie = scanner.nextLine().trim();
		
       switch (categorie.toLowerCase()) {
            case "ebook":
                return new Livre(titre, auteur, annee, genre);
            case "livre physique":
                return new Livre(titre, auteur, annee, genre);
            default:
                throw new IllegalArgumentException("Type de livre inconnu : " + categorie);
        }
}
    
}
