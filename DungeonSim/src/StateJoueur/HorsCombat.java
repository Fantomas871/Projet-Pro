package StateJoueur;

import Personnage.Joueur;

import java.util.Scanner;

public class HorsCombat extends StateJoueur {

    public HorsCombat(Joueur joueur) {
        super(joueur);

    }

    @Override
    public void afficheChoix() {
        boolean flagSortieBoucle = false;
        System.out.println("Entrez N-S-E-O pour changer de salle dans la direction choisie");
        System.out.println("Entrez F pour interagir");
        System.out.println("Entrez M pour afficher la carte");
        System.out.println("Entrez menu pour ouvrir le menu");
        Scanner scanner = new Scanner(System.in);

        while (!flagSortieBoucle) {

            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("menu")) {
                transitionEtat(action);
                flagSortieBoucle = true;
            } else if (action.equalsIgnoreCase("N") || action.equalsIgnoreCase("S") || action.equalsIgnoreCase("E") || action.equalsIgnoreCase("O")) {
                // Implémenter le déplacement
                int[] taille = joueur.getCarte().getTaille();
                switch (action) {
                    case "N":
                    case "n":
                        if (joueur.getY() - 1 >= 0) {
                            joueur.setY(joueur.getY() - 1);
                            System.out.println("Déplacement vers le nord");
                        } else {
                            System.out.println("Déplacement impossible");
                        }
                        break;
                    case "S":
                    case "s":
                        if (joueur.getY() + 1 < taille[1]) {
                            joueur.setY(joueur.getY() + 1);
                            System.out.println("Déplacement vers le sud");
                        } else {
                            System.out.println("Déplacement impossible");
                        }
                        break;
                    case "E":
                    case "e":
                        if (joueur.getX() + 1 < taille[0]) {
                            joueur.setX(joueur.getX() + 1);
                            System.out.println("Déplacement vers l'est");
                        } else {
                            System.out.println("Déplacement impossible");
                        }
                        break;
                    case "O":
                    case "o":
                        if (joueur.getX() - 1 >= 0) {
                            joueur.setX(joueur.getX() - 1);
                            System.out.println("Déplacement vers l'ouest");
                        } else {
                            System.out.println("Déplacement impossible");
                        }
                        break;
                    default:
                        System.out.println("Comment êtes-vous arrivé ici, comment, juste comment ?!");
                        break;
                }

                joueur.getCarte().trueSight(joueur.getCarte());

                flagSortieBoucle = true;
            } else if (action.equalsIgnoreCase("M")){
                joueur.getCarte().afficher();
                flagSortieBoucle = true;
            }else if (action.equalsIgnoreCase("F")) {
                //@TODO Implémenter l'interaction
                System.out.println("Il n'y a rien ici.");
                flagSortieBoucle = true;
            } else if (action.equalsIgnoreCase("M")) {
            	joueur.getCarte().afficher();
            }
        }
    }

    @Override
    public void transitionEtat(String etat) {
        if (etat.equalsIgnoreCase("EnCombat")) {
            this.joueur.setEtatJoueur(new EnCombat(this.joueur));
        } else if (etat.equalsIgnoreCase("Menu")) {
            this.joueur.setEtatJoueur(new Menu(this.joueur));
        } else if (etat.equalsIgnoreCase("HorsCombat")) {
            System.out.println("Déjà hors combat");
        } else {
            System.out.println("Etat du joueur inconnu");
        }
    }
}
