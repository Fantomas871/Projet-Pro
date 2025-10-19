package StateLivre;

/**
 * Etat : Livre réservé.
 */
public class ReserveState implements StateLivre {
    private final Object contexte;

    public ReserveState(Object contexte) {
        this.contexte = contexte;
    }

    @Override
    public void libre() {
        // si une réservation est retirée/annulée -> disponible
        setStateOnContext(new LibreState(contexte));
        System.out.println("Transition : Réservé -> Disponible");
    }

    @Override
    public void emprunt() {
        // réservation transformée en emprunt
        setStateOnContext(new EmprunteState(contexte));
        System.out.println("Transition : Réservé -> Emprunté (par le réservant)");
    }

    @Override
    public void reserve() {
        System.out.println("Le livre est déjà réservé : ajout dans la file de réservation (si gérée par le contexte).");
    }

    @Override
    public String toString() {
        return "Réservé";
    }

    private void setStateOnContext(StateLivre nouvelle) {
        if (contexte == null) return;
        try {
            contexte.getClass().getMethod("setState", StateLivre.class).invoke(contexte, nouvelle);
            return;
        } catch (Exception ignored) {}
        try {
            contexte.getClass().getMethod("setEtat", StateLivre.class).invoke(contexte, nouvelle);
        } catch (Exception ignored) {}
    }
}