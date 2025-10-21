package Persistence;

import java.io.*;
import java.util.ArrayList;
import Biblio.Bibliotheque;
import Biblio.Livre;
import Biblio.LivrePhysique;
import Biblio.Adherent;
import StateLivre.LibreState;
import StateLivre.EmprunteState;
import StateLivre.ReserveState;


public class BibliothequeDAO {
    private static final BibliothequeDAO INSTANCE = new BibliothequeDAO();

    private BibliothequeDAO() { }

    public static BibliothequeDAO getInstance() {
        return INSTANCE;
    }

    public void save(Bibliotheque bibliotheque, File destination) throws IOException {
        if (bibliotheque == null) throw new IllegalArgumentException("bibliotheque null");
        try (BufferedWriter w = new BufferedWriter(new FileWriter(destination))) {
            w.write("{\n");
            w.write("  \"nom\": \"" + escape(bibliotheque.getNom()) + "\",\n");

            // livres
            w.write("  \"livres\": [\n");
            ArrayList<Livre> livres = bibliotheque.getBibliotheque();
            for (int i = 0; i < livres.size(); i++) {
                Livre l = livres.get(i);
                if (l instanceof LivrePhysique) {
                    LivrePhysique lp = (LivrePhysique) l;
                    w.write("    {\n");
                    w.write("      \"type\": \"physique\",\n");
                    w.write("      \"titre\": \"" + escape(lp.getTitre()) + "\",\n");
                    w.write("      \"auteur\": \"" + escape(lp.getAuteur()) + "\",\n");
                    w.write("      \"annee\": " + lp.getAnneeParution() + ",\n");
                    w.write("      \"genre\": \"" + escape(lp.getGenre()) + "\",\n");
                    w.write("      \"etat\": \"" + escape(lp.getEtat().toString()) + "\"\n");
                    w.write("    }");
                    if (i < livres.size()-1) w.write(",");
                    w.write("\n");
                }
            }
            w.write("  ],\n");

            // adherents (only names and borrowed titles)
            w.write("  \"adherents\": [\n");
            ArrayList<Adherent> ads = bibliotheque.getAdherents();
            for (int i = 0; i < ads.size(); i++) {
                Adherent a = ads.get(i);
                w.write("    {\n");
                w.write("      \"nom\": \"" + escape(a.getNom()) + "\",\n");
                // list borrowed titles
                w.write("      \"emprunts\": [");
                LivrePhysique[] liste = a.getListeLivrePhysique();
                boolean first = true;
                for (LivrePhysique lp : liste) {
                    if (lp != null) {
                        if (!first) w.write(", ");
                        w.write("\"" + escape(lp.getTitre()) + "\"");
                        first = false;
                    }
                }
                w.write("],\n");
                w.write("    }");
                if (i < ads.size()-1) w.write(",");
                w.write("\n");
            }
            w.write("  ]\n");

            w.write("}\n");
        }
    }

    public Bibliotheque load(File source) throws IOException {
        if (source == null || !source.exists()) throw new FileNotFoundException("Fichier introuvable: " + source);

        StringBuilder sb = new StringBuilder();
        try (BufferedReader r = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = r.readLine()) != null) sb.append(line).append('\n');
        }
        String content = sb.toString();

        // Very small ad-hoc parsing
        String nom = extractString(content, "\"nom\"\s*:\s*\"");
        Bibliotheque b = new Bibliotheque(nom == null ? "" : nom);

        // parse livres blocks
        int idxLivres = content.indexOf("\"livres\":");
        if (idxLivres >= 0) {
            int start = content.indexOf('[', idxLivres);
            int end = content.indexOf(']', start);
            if (start >= 0 && end > start) {
                String listeLivres = content.substring(start+1, end);
                String[] items = listeLivres.split("\\},");
                for (String item : items) {
                    if (item.contains("physique")) {
                        String titre = extractString(item, "\"titre\"\s*:\s*\"");
                        String auteur = extractString(item, "\"auteur\"\s*:\s*\"");
                        String anneeS = extractNumber(item, "\"annee\"\s*:\s*");
                        int an = 0;
                        try { an = Integer.parseInt(anneeS); } catch (Exception ex) { }
                        String genre = extractString(item, "\"genre\"\s*:\s*\"");
                        String etat = extractString(item, "\"etat\"\s*:\s*\"");
                        LivrePhysique lp = new LivrePhysique(titre == null ? "" : titre,
                                auteur == null ? "" : auteur,
                                an,
                                genre == null ? "" : genre);
                        if (etat != null) {
                            switch (etat) {
                                case "Disponible": lp.setEtat(new LibreState(lp)); break;
                                case "Emprunté": lp.setEtat(new EmprunteState(lp)); break;
                                case "Réservé": lp.setEtat(new ReserveState(lp)); break;
                                default: lp.setEtat(new LibreState(lp));
                            }
                        }
                        b.ajouterLivre(lp);
                    }
                }
            }
        }

        // parse adherents
        int idxAds = content.indexOf("\"adherents\":");
        if (idxAds >= 0) {
            int start = content.indexOf('[', idxAds);
            int end = content.indexOf(']', start);
            if (start >= 0 && end > start) {
                String listeAds = content.substring(start+1, end);
                String[] items = listeAds.split("\\},");
                for (String item : items) {
                    String nomAd = extractString(item, "\"nom\"\s*:\s*\"");
                    if (nomAd == null) continue;
                    Adherent a = new Adherent(nomAd);
                    b.ajouterAdherent(a);
                    // emprunts
                    int emStart = item.indexOf("\"emprunts\":");
                    if (emStart >= 0) {
                        int s = item.indexOf('[', emStart);
                        int e = item.indexOf(']', s);
                        if (s >= 0 && e > s) {
                            String listEm = item.substring(s+1, e);
                            String[] titres = listEm.split(",");
                            for (String t : titres) {
                                String cleaned = t.trim();
                                if (cleaned.startsWith("\"") && cleaned.endsWith("\"")) cleaned = cleaned.substring(1, cleaned.length()-1);
                                cleaned = cleaned.replaceAll("\\\\\"", "\"");
                                if (!cleaned.isEmpty()) {
                                    // find book by title
                                    for (Livre lv : b.getBibliotheque()) {
                                        if (lv.getTitre().equals(cleaned) && lv instanceof LivrePhysique) {
                                            a.emprunterLivrePhysique((LivrePhysique) lv);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return b;
    }

    private static String escape(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    private static String extractString(String src, String keyPrefix) {
        int idx = src.indexOf(keyPrefix);
        if (idx < 0) return null;
        int start = idx + keyPrefix.length();
        int end = src.indexOf('"', start);
        if (end < 0) return null;
        return src.substring(start, end);
    }

    private static String extractNumber(String src, String keyPrefix) {
        int idx = src.indexOf(keyPrefix);
        if (idx < 0) return "0";
        int start = idx + keyPrefix.length();
        StringBuilder sb = new StringBuilder();
        while (start < src.length()) {
            char c = src.charAt(start);
            if (Character.isDigit(c) || c=='-') { sb.append(c); start++; } else break;
        }
        return sb.toString();
    }
}
