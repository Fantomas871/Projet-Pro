package StateJoueur;

import Personnage.Joueur;

import java.util.Scanner;

public class HorsCombat extends StateJoueur{

    public HorsCombat(Joueur joueur) {
        afficheChoix();
    }

    @Override
    public void afficheChoix() {
        //@TODO changer de salle, ouvrir inventaire, ouvrir menu, interargir(ouvrir coffre, parler marchand)

        boolean flagSortieBoucle = false;

        System.out.println("Entrer N-S-E-O pour changer de salle dans la direction choisie");
        System.out.println("Entrer F pour interargir");
        System.out.println("Entrer menu pour ouvrir le menu");
        Scanner scanner = new Scanner(System.in);

        while(!flagSortieBoucle){
            String action = scanner.nextLine();
            if(action.equalsIgnoreCase("menu")){

            }

        }
    }

    @Override
    public void transitionEtat(String etat) {
        if (etat.equals("EnCombat")) {
            this.joueur.setEtatJoueur(new EnCombat(this.joueur));
        } else if (etat.equals("Menu")) {
            this.joueur.setEtatJoueur(new Menu(this.joueur));
        } else if (etat.equals("HorsCombat")) {
            System.out.println("Déjà hors combat");
        } else {
            System.out.println("Etat du joueur inconnu");
        }
    }

}
