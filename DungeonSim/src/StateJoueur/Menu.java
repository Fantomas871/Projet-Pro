package StateJoueur;

import java.util.Scanner;

public class Menu extends StateJoueur{

    public Menu(){
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
                //@TODO génère une carte et y place le joueur
                flagSortieMenue = true;
            }else {
                System.out.println("Action invalide");
            }

        }
    }
}
