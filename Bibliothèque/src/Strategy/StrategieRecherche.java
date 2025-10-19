package Strategy;

import java.util.List;
import Biblio.Livre;

public interface StrategieRecherche {
    List<Livre> rechercher(List<Livre> livres, String critere);
}