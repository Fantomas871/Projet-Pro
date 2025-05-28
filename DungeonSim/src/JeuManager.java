import Personnage.*;
import StateJoueur.Menu;
import StateJoueur.StateJoueur;

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
        // Création du joueur
        Joueur joueur = new Joueur();
        joueur.setNom("Aventurier");
        joueur.setPv(100);
        joueur.setDegat(10);
        joueur.setDefence(5);
        
        // Ouvrir le menu au lancement
        joueur.setEtatJoueur(new Menu(joueur));

        while(true){
            joueur.getEtatJoueur().afficheChoix();
        }

    }
}
