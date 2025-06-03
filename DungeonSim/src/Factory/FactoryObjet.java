package Factory;

import Objet.*;

public class FactoryObjet {
	
	public static Objet creerObjet(String type) {
        switch (type.toLowerCase()) {
            case "degats":
                return new ObjetDegats(((int)Math.random()*500)+50,(int)Math.random()*5);
            case "protection":
                return new ObjetProtection(((int)Math.random()*500)+50,(int)Math.random()*3);
            case "soin":
            	return new ObjetSoin(((int)Math.random()*500)+50,(int)Math.random()*20);
            default:
                throw new IllegalArgumentException("Type d'objet inconnu : " + type);
        }
    }
}
