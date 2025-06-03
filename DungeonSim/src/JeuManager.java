import Carte.*;
import Personnage.*;
import StateJoueur.*;

public class JeuManager {
    private static JeuManager instance;

    private JeuManager() {
        // Constructeur privé pour le singleton
    }

    public static JeuManager getInstance() {
        if (instance == null) {
            instance = new JeuManager();
        }
        return instance;
    }

    public void lancerJeu() {
        // Taille de la carte
        int taille = 5;
        // Création d'une instance de Carte
        Carte carte = new Carte();

        // Génération de la carte
        Piece[][] maCarte = carte.generationCarte(taille);

        // attribution de la carte
        carte.setCarte(maCarte);



        // Création du joueur
        Joueur joueur = new Joueur();
        joueur.setCarteInit(carte);
        joueur.setNom("Aventurier");
        joueur.setPv(100);
        joueur.setDegat(10);
        joueur.setDefence(5);
        joueur.setCarte(carte);





        // Ouvrir le menu au lancement
        joueur.setEtatJoueur(new Menu(joueur));

        while(true){
            if((joueur.getCarte()).thisRencontre(joueur.getX(), joueur.getY(), joueur.getCarte())==5){
                System.out.println("Victoire !!");
            }

            joueur.getEtatJoueur().afficheChoix();
        }

    }
}
