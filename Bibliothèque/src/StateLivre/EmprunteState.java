package StateLivre;

/**
 * Etat : Livre emprunté.
 */
public class EmprunteState implements StateLivre {
    private final Object contexte;

    public EmprunteState(Object contexte) {
        this.contexte = contexte;
    }

    @Override
    public void libre() {
        // retour du livre -> disponible (ou réservé selon la logique du contexte)
        setStateOnContext(new LibreState(contexte));
        System.out.println("Transition : Emprunté -> Disponible");
    }

    @Override
    public void emprunt() {
        System.out.println("Impossible : le livre est déjà emprunté.");
    }

    @Override
    public void reserve() {
        // ajouter une réservation : on passe en état réservé (conception simple)
        setStateOnContext(new ReserveState(contexte));
        System.out.println("Transition : Emprunté -> Réservé (réservation ajoutée)");
    }

    @Override
    public String toString() {
        return "Emprunté";
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