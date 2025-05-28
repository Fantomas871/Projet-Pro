package Personnage;

import MobStrat.MobStrategy;

import java.util.Objects;

public class Ennemie extends Personnage{
	
	MobStrategy type;

    public Ennemie(String n, int pv, int dmg, int dfc, MobStrategy t) {
		super(n, pv, dmg, dfc);
		this.type=t;
	}

	private String actionAEffectuer;
    @Override
    protected String choisirAction() {
        int chance = (int) (Math.random()*10);
        if(chance>2){
            this.actionAEffectuer = "attaque";
        }
        this.actionAEffectuer = "defend";
        return actionAEffectuer;
    }

    @Override
    protected String effectuerAction() {
        if(this.actionAEffectuer.equals("attaque")){
            //@TODO implémenter l'attaque
        } else if(this.actionAEffectuer.equals("defend")){
            //@TODO implémenter la défense
        } else {
            System.out.println("Erreur de choix d'action");
        }
        return "";
    }

}
