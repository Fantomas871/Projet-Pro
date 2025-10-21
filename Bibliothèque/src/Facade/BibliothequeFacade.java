package Facade;

import Biblio.Adherent;
import Biblio.Bibliotheque;
import Biblio.Livre;
import Biblio.LivrePhysique;
import Strategy.StrategieAmende;
import Strategy.StrategieRecherche;
import Observer.NotificationService;
import Persistence.BibliothequeDAO;

import java.io.File;
import java.util.ArrayList;

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

    public ArrayList<Livre> rechercher(StrategieRecherche rechercheStrategy, String critere) {
        ArrayList<Livre> livres = bibliotheque.getBibliotheque();
        return rechercheStrategy.rechercher(livres, critere);
    }

    public void notifierDisponibilite(LivrePhysique livre) {
        if (livre.getEtat().toString().equals("Disponible")) {
            String msg = "Le livre est disponible : " + livre.toString();
            notificationService.notifyObservers(msg);
        }
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

    public void emprunter(LivrePhysique livre, Adherent adherent) {
        adherent.emprunterLivrePhysique(livre);
    }

    public void rendre(LivrePhysique livre, Adherent adherent) {
        adherent.rendreLivrePhysique(livre);
    }
}
