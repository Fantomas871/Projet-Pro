package StateJoueur;

import Personnage.Joueur;

import java.util.Scanner;

public class Menu extends StateJoueur{

    public Menu(Joueur joueur) {
        afficheChoix();
    }

    @Override
    public void afficheChoix() {
        boolean flagSortieMenue = false;

        System.out.println("Menu");
        System.out.println("Entrer NV pour commencer une nouvelle partie ou Q pour quitter");
        Scanner scanner = new Scanner(System.in);

        while(!flagSortieMenue){
            String action = scanner.nextLine();
            if(action.equalsIgnoreCase("q")){
                System.exit(0);//on sort du programme
            } else if (action.equalsIgnoreCase("nv")){
                //@TODO réinitialise tout, génère une carte et y place le joueur
                flagSortieMenue = true;
            }else {
                System.out.println("Action invalide");
            }

        }
    }

    @Override
    public void transitionEtat(String etat) {
        if (etat.equals("EnCombat")) {
            this.joueur.setEtatJoueur(new EnCombat(this.joueur));
        } else if (etat.equals("HorsCombat")) {
            this.joueur.setEtatJoueur(new HorsCombat(this.joueur));
        } else if (etat.equals("Menu")) {
            System.out.println("Déjà dans le menu");
        } else {
            System.out.println("Etat du joueur inconnu");
        }
    }

}
