package Factory;

import MobStrat.*;
import Personnage.Ennemie;

public class FactoryEnnemi {
	
	public static Ennemie creerEnnemie (String typeEnnemi) {
		switch (typeEnnemi.toLowerCase()) {
		case "Celeste":
			return new Ennemie ("Gobelin", (int)Math.random()*20, (int)Math.random()*5, (int)Math.random()*3, new Celestial());
		case "Infernal":
			return new Ennemie ("Gobelin", (int)Math.random()*20, (int)Math.random()*5, (int)Math.random()*3, new Infernal());
		case"Mort vivant":
			return new Ennemie ("Gobelin", (int)Math.random()*20, (int)Math.random()*5, (int)Math.random()*3, new MortVivant());
		default:
			throw new IllegalArgumentException("Type d'ennemi inconnu : " + typeEnnemi);
		
		}
	}

}
