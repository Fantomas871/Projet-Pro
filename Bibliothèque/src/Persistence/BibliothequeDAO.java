package Persistence;

import java.io.*;
import Biblio.Bibliotheque;

/**
 * Singleton responsable de la persistance (sérialisation) de la Bibliotheque.
 * Attention : la classe Biblio.Bibliotheque doit être Serializable pour que la sérialisation fonctionne.
 * Si elle ne l'est pas, adaptez cette classe (JSON, CSV, ou persistance custom).
 */
public class BibliothequeDAO {
    private static final BibliothequeDAO INSTANCE = new BibliothequeDAO();

    private BibliothequeDAO() { }

    public static BibliothequeDAO getInstance() {
        return INSTANCE;
    }

    public void save(Bibliotheque bibliotheque, File destination) throws IOException {
        if (bibliotheque == null) throw new IllegalArgumentException("bibliotheque null");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(destination))) {
            oos.writeObject(bibliotheque);
        }
    }

    public Bibliotheque load(File source) throws IOException, ClassNotFoundException {
        if (source == null || !source.exists()) throw new FileNotFoundException("Fichier introuvable: " + source);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(source))) {
            Object obj = ois.readObject();
            return (Bibliotheque) obj;
        }
    }
}
