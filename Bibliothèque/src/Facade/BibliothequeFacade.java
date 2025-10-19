package Facade;

import Biblio.Adherent;
import Biblio.Bibliotheque;
import Biblio.Livre;
import Strategy.StrategieAmende;
import Strategy.StrategieRecherche;
import Observer.NotificationService;
import Persistence.BibliothequeDAO;

import java.io.File;
import java.util.List;

/**
 * Facade pour simplifier l'utilisation des sous-systèmes (persistence, notifications, stratégies).
 * Les méthodes sont des stubs génériques : adaptez les appels internes selon les méthodes réelles de Biblio.Bibliotheque.
 */
public class BibliothequeFacade {
    private final Bibliotheque bibliotheque;
    private final NotificationService notificationService;
    private final BibliothequeDAO dao;

    public BibliothequeFacade(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
        this.notificationService = new NotificationService();
        this.dao = BibliothequeDAO.getInstance();
    }

    public void addObserver(Observer.Observateur obs) {
        notificationService.addObserver(obs);
    }

    public void removeObserver(Observer.Observateur obs) {
        notificationService.removeObserver(obs);
    }

    public List<Livre> rechercher(StrategieRecherche rechercheStrategy, String critere) {
        // Délégation simple : la façade fournit un point d'entrée unifié.
        // L'appel réel se fait via la stratégie : l'appel ci-dessous suppose que vous récupérez la liste de livres depuis bibliotheque.
        // TODO : remplacer bibliotheque.getLivres() par la méthode réelle de votre classe Bibliotheque
        try {
            List<Livre> livres = (List<Livre>) bibliotheque.getClass().getMethod("getLivres").invoke(bibliotheque);
            return rechercheStrategy.rechercher(livres, critere);
        } catch (Exception ex) {
            throw new UnsupportedOperationException("Adapter la façade : méthode getLivres() introuvable sur Bibliotheque", ex);
        }
    }

    public void notifierDisponibilite(Livre livre) {
        String msg = "Le livre est disponible : " + (livre != null ? livre.toString() : "null");
        notificationService.notifyObservers(msg);
    }

    public void sauvegarder(File destination) throws Exception {
        dao.save(bibliotheque, destination);
    }

    public Bibliotheque charger(File source) throws Exception {
        return dao.load(source);
    }

    public double calculerAmende(StrategieAmende strategie, int joursRetard) {
        return strategie.calculerAmende(joursRetard);
    }

    // Méthodes d'exemple pour emprunt/rendu/réservation : à adapter en fonction de votre API
    public void emprunter(Livre livre, Adherent adherent) {
        throw new UnsupportedOperationException("Implémenter la logique d'emprunt en adaptant à votre Bibliotheque");
    }

    public void rendre(Livre livre, Adherent adherent) {
        throw new UnsupportedOperationException("Implémenter la logique de retour en adaptant à votre Bibliotheque");
    }

    public void reserver(Livre livre, Adherent adherent) {
        throw new UnsupportedOperationException("Implémenter la logique de réservation en adaptant à votre Bibliotheque");
    }
}
