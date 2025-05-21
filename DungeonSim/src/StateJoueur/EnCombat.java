package StateJoueur;

import Personnage.Joueur;

public class EnCombat extends StateJoueur {

    public EnCombat(Joueur joueur) {
        afficheChoix();
    }
    @Override
    public void afficheChoix() {
        System.out.println("En combat");
        //@TODO afficher les mobs et leurs PV
        //@TODO lister les actions possibles, utilisé objet si disponible
        System.out.println("Attaque");


    }

    @Override
    public void transitionEtat(String etat) {
        if (etat.equals("HorsCombat")) {
            this.joueur.setEtatJoueur(new HorsCombat(this.joueur));
        } else if (etat.equals("Menu")) {
            this.joueur.setEtatJoueur(new Menu(this.joueur));
        } else if (etat.equals("EnCombat")) {
            System.out.println("Déjà en combat");
        } else {
            System.out.println("Etat du joueur inconnu");
        }
    }

}
