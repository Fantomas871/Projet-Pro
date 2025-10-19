package Strategy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
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
    public List<Livre> rechercher(List<Livre> livres, String critere) {
        List<Livre> resultats = new ArrayList<>();
        if (critere == null) critere = "";
        String critLower = critere.toLowerCase();
        String cap = attribut.isEmpty() ? attribut : Character.toUpperCase(attribut.charAt(0)) + attribut.substring(1);
        String getterName = "get" + cap;

        for (Livre livre : livres) {
            try {
                Object valeur = null;
                // essayer le getter
                try {
                    Method m = livre.getClass().getMethod(getterName);
                    valeur = m.invoke(livre);
                } catch (NoSuchMethodException nsme) {
                    // fallback: chercher le champ directement
                    try {
                        Field f = livre.getClass().getDeclaredField(attribut);
                        f.setAccessible(true);
                        valeur = f.get(livre);
                    } catch (NoSuchFieldException | SecurityException ignore) {
                        // si on ne trouve ni getter ni champ, on ignore
                    }
                }

                if (valeur != null) {
                    String s = String.valueOf(valeur).toLowerCase();
                    if (s.contains(critLower)) {
                        resultats.add(livre);
                    }
                }
            } catch (Exception ex) {
                // ignorer les erreurs pour ne pas interrompre la recherche
            }
        }
        return resultats;
    }
}