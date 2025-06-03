package StateJoueur;

import Personnage.Joueur;
import Personnage.Marchand;

import java.util.Scanner;

import Factory.FactoryObjet;
import Objet.Objet;

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
                switch (action) {
                    case("N")://@TODO vérifier que le déplacement est possible à partir des coordonnées, si oui les effectuées
                    case("n"): if(joueur.getY()-1>0){
                        joueur.setY(joueur.getY()-1);
                        joueur.getCarte().visible(joueur.getX(), joueur.getY());
                    }else System.out.println("Déplacement impossible");
                        break;
                    case("S"):
                    case("s"): if (joueur.getY()+1>joueur.getCarte().getCarte().length){
                        joueur.setY(joueur.getY()+1);
                        joueur.getCarte().visible(joueur.getX(), joueur.getY());
                    }else System.out.println("Déplacement impossible");
                        break;
                    case("E"):
                    case("e"): if (joueur.getX()+1>joueur.getCarte().getCarte().length){
                        joueur.setY(joueur.getX()+1);
                        joueur.getCarte().visible(joueur.getX(), joueur.getY());
                    }else System.out.println("Déplacement impossible");
                        break;
                    case("O"):
                    case("o"):if (joueur.getY()-1>0){
                        joueur.setY(joueur.getY()-1);
                        joueur.getCarte().visible(joueur.getX(), joueur.getY());
                    }else System.out.println("Déplacement impossible");
                        break;
                    default:
                        System.out.println("how did you get here, how, just how!!");
                        break;
                }

                System.out.println("Déplacement vers " + action);
                flagSortieBoucle = true;
            } else if (action.equalsIgnoreCase("M")){
                joueur.getCarte().afficher();
                flagSortieBoucle = true;
            }else if (action.equalsIgnoreCase("F")) {

            	if (joueur.getCarte().thisRencontre(joueur.getX(), joueur.getY())==2) {
            		
            		String [] type = {"degats","protection","soin"};
            		int rand=(int)Math.random()*3;
            		Objet obj = FactoryObjet.creerObjet(type[rand]);
            		System.out.print("Vous avez trouvé un objet."+obj.toString());
            		System.out.print("Il a été ajouté à votre inventaire.");
            		joueur.getInventaire().add(obj);
            		
            	}else if (joueur.getCarte().thisRencontre(joueur.getX(), joueur.getY())==3) {
            		System.out.println("Quest ce que t'achète ?");
            		Marchand re4 = new Marchand("Resident Evil 4", 1, 1000, 1000);
                    for (int i=0; i<5;i++) {
                    	String [] type = {"degats","protection","soin"};
                    	int rand=(int)Math.random()*3;
                		re4.getInventaire().add(FactoryObjet.creerObjet(type[rand]));
                    }
            		re4.montrerMarchandise();
            		
            	}else {
            	
                System.out.println("Il n'y a rien ici.");
                
            	}
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
