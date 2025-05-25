import Carte.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bienvenue dans Dungeon Simulator!");
        
        // Lancement du jeu via le gestionnaire de jeu
        JeuManager jeuManager = JeuManager.getInstance();
        jeuManager.lancerJeu();
        
/*
        // Taille de la carte
        int taille = 5;

        // Création d'une instance de Carte
        Carte carte = new Carte();

        // Génération de la carte
        Piece[][] maCarte = carte.generationCarte(taille);

        // Affichage de la carte
        carte.setCarte(maCarte);
        carte.afficher();
*/
    }
}
