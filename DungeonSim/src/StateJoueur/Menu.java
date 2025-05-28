package StateJoueur;

import Personnage.Joueur;
import Carte.*;

import java.util.Scanner;

public class Menu extends StateJoueur {

    public Menu(Joueur joueur) {
        super(joueur);

    }

    @Override
    public void afficheChoix() {
        boolean flagSortieMenue = false;
        System.out.println("Menu");
        System.out.println("Entrer NV pour commencer une nouvelle partie ou Q pour quitter");
        Scanner scanner = new Scanner(System.in);

        while (!flagSortieMenue) {
            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("Q")) {
                System.exit(0); // On sort du programme
            } else if (action.equalsIgnoreCase("NV")) {
                // Réinitialisation et génération de la carte
                Carte carte = new Carte();
                int taille = 5; // Taille par défaut
                Piece[][] nouvelleCarte = carte.generationCarte(taille);
                carte.setCarte(nouvelleCarte);
                // Transition vers l'état HorsCombat
                transitionEtat("HorsCombat");
                flagSortieMenue = true;
            } else {
                System.out.println("Action invalide");
            }
        }
    }

    @Override
    public void transitionEtat(String etat) {
        if (etat.equalsIgnoreCase("EnCombat")) {
            this.joueur.setEtatJoueur(new EnCombat(this.joueur));
        } else if (etat.equalsIgnoreCase("HorsCombat")) {
            this.joueur.setEtatJoueur(new HorsCombat(this.joueur));
        } else if (etat.equalsIgnoreCase("Menu")) {
            System.out.println("Déjà dans le menu");
        } else {
            System.out.println("Etat du joueur inconnu");
        }
    }
}