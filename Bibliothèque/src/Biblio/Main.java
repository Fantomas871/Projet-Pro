package Biblio;

import Facade.BibliothequeFacade;

public class Main {

    public static void main(String[] args) {
        // Crée la bibliothèque et la façade
        Bibliotheque biblio = new Bibliotheque("Bibliothèque Centrale");
        BibliothequeFacade facade = new BibliothequeFacade(biblio);

        // Ajout de quelques livres physiques
        LivrePhysique lp1 = new LivrePhysique("Le Petit Prince", "Antoine de Saint-Exupéry", 1943, "Conte");
        LivrePhysique lp2 = new LivrePhysique("1984", "George Orwell", 1949, "Dystopie");
        biblio.ajouterLivre(lp1);
        biblio.ajouterLivre(lp2);

        // Ajout d'un adhérent
        Adherent alice = new Adherent("Alice");
        biblio.ajouterAdherent(alice);

        // Affiche l'inventaire
        System.out.println("Livres dans la bibliothèque :");
        for (Livre l : biblio.getBibliotheque()) {
            System.out.println(" - " + l.toString());
        }

        // Emprunt d'un livre via la façade
        System.out.println("\n=== Emprunt ===");
        facade.emprunter(lp1, alice);

        // Tentative d'emprunt du même livre par le même adhérent (montrera l'état)
        System.out.println("\n=== Tentative d'emprunt à nouveau ===");
        facade.emprunter(lp1, alice);

        // Rendre le livre
        System.out.println("\n=== Retour ===");
        facade.rendre(lp1, alice);

        // Notifier la disponibilité
        System.out.println("\n=== Notification de disponibilité ===");
        facade.notifierDisponibilite(lp1);

        System.out.println("\nDemo terminée.");
    }
}
