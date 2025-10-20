package Strategy;

import java.util.ArrayList;
import java.util.List;
import Biblio.Livre;

public class RechercheStrategy {
    private StrategieRecherche strategie;

    public RechercheStrategy() { }

    public RechercheStrategy(StrategieRecherche strategie) {
        this.strategie = strategie;
    }

    public void setStrategie(StrategieRecherche strategie) {
        this.strategie = strategie;
    }

    public ArrayList<Livre> rechercher(ArrayList<Livre> livres, String critere) {
        if (strategie == null) {
            throw new IllegalStateException("Stratégie de recherche non définie.");
        }
        return strategie.rechercher(livres, critere);
    }

    public static StrategieRecherche parTitre() {
        return new RechercheParAttribut("titre");
    }
    public static StrategieRecherche parAuteur() {
        return new RechercheParAttribut("auteur");
    }
    public static StrategieRecherche parAnnee() {
        return new RechercheParAttribut("anneeParution");
    }
    public static StrategieRecherche parGenre() {
        return new RechercheParAttribut("genre");
    }
}
