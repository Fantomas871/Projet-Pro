package Util;

import Biblio.Livre;
import Biblio.Adherent;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Générateur de rapports simple (stubs).
 * Les méthodes retournent des résumés textuels ; adaptez les pour extraire les données réelles depuis vos classes.
 */
public class ReportGenerator {
    public static String livresEnRetard(List<Livre> livres) {
        // Exemple générique : filtre par méthode isEnRetard() si elle existe (utiliser réflexion si nécessaire).
        try {
            List<Livre> enRetard = livres.stream().filter(l -> {
                try {
                    Object r = l.getClass().getMethod("isEnRetard").invoke(l);
                    return r instanceof Boolean && (Boolean) r;
                } catch (Exception ex) {
                    return false;
                }
            }).collect(Collectors.toList());
            StringBuilder sb = new StringBuilder();
            sb.append("Livres en retard (").append(enRetard.size()).append("):\n");
            for (Livre l : enRetard) sb.append(" - ").append(l).append("\n");
            return sb.toString();
        } catch (Exception ex) {
            return "Impossible de générer le rapport de retard : méthode isEnRetard() non trouvée.";
        }
    }

    public static String topEmpruntes(List<Livre> livres, int topN) {
        // Stub générique : si Livre a getCountEmprunts() on l'utilise, sinon message.
        try {
            List<Livre> sorted = livres.stream().sorted((a, b) -> {
                try {
                    Object ca = a.getClass().getMethod("getCountEmprunts").invoke(a);
                    Object cb = b.getClass().getMethod("getCountEmprunts").invoke(b);
                    int ia = (ca instanceof Number) ? ((Number) ca).intValue() : 0;
                    int ib = (cb instanceof Number) ? ((Number) cb).intValue() : 0;
                    return Integer.compare(ib, ia);
                } catch (Exception ex) {
                    return 0;
                }
            }).limit(topN).collect(Collectors.toList());
            StringBuilder sb = new StringBuilder();
            sb.append("Top ").append(topN).append(" livres empruntés:\n");
            for (Livre l : sorted) sb.append(" - ").append(l).append("\n");
            return sb.toString();
        } catch (Exception ex) {
            return "Impossible de générer le rapport top empruntés : méthode getCountEmprunts() non trouvée.";
        }
    }
}
