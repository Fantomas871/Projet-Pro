package Observer;

/**
 * Interface Observateur simple.
 */
public interface Observateur {
    /**
     * Appelé quand un événement se produit.
     * @param message texte de notification
     */
    void update(String message);
}
