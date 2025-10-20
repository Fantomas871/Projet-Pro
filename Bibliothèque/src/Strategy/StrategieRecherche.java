package Strategy;

import java.util.ArrayList;
import java.util.List;
import Biblio.Livre;

public interface StrategieRecherche {
	ArrayList<Livre> rechercher(ArrayList<Livre> livres, String critere);
}