package Strategy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Biblio.Livre;

/**
 * Recherche générique par attribut (ex: "titre", "auteur", "anneeParution", "genre").
 * Utilise d'abord un getter (getXxx), puis le champ directement si nécessaire.
 * Compare la représentation en chaîne (contains, case-insensitive).
 */
public class RechercheParAttribut implements StrategieRecherche {
    private final String attribut;

    public RechercheParAttribut(String attribut) {
        this.attribut = attribut;
    }

    @Override
    public ArrayList<Livre> rechercher(ArrayList<Livre> livres, String critere) {
    	ArrayList<Livre> resultats = new ArrayList<Livre>();
    	
    	String valeur = null;
    	
    	if (attribut.equals("titre")) {
            valeur = JOptionPane.showInputDialog(null, "Entrez le titre recherché :");
        } else if (attribut.equals("auteur")) {
            valeur = JOptionPane.showInputDialog(null, "Entrez le nom de l'auteur :");
        } else if (attribut.equals("anneeParution")) {
            valeur = JOptionPane.showInputDialog(null, "Entrez l'année de parution :");
        } else if (attribut.equals("genre")) {
            valeur = JOptionPane.showInputDialog(null, "Entrez le genre recherché :");
        }
        
        for (int i=0; i<livres.size();i++) {
            switch (critere) {
            
            case "titre":
            	
            	if (livres.get(i).getTitre().equals(valeur)) {
            		resultats.add(livres.get(i));
            		
            	}
            	break;
            	
            case "auteur":
            	
            	if (livres.get(i).getAuteur().equals(valeur)) {
            		resultats.add(livres.get(i));
            		
            	}
            	break;
            	
            case "anneeParution":
            	
            	int annee = Integer.parseInt(valeur);
            	if (livres.get(i).getAnneeParution()==annee) {
            		resultats.add(livres.get(i));
            		
            	}
            	break;
            	
            case "genre":
            	
            	if (livres.get(i).getGenre().equals(valeur)) {
            		resultats.add(livres.get(i));
            		
            	}
            	break;
            	
            
            }
            	
        }
        return resultats;
    }
}