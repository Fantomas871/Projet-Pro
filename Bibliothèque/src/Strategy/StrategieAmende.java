package Strategy;

/**
 * Strategy pour le calcul des amendes.
 */
public interface StrategieAmende {
    /**
     * Calcule l'amende pour un nombre de jours de retard.
     * @param joursRetard nombre de jours de retard (>= 0)
     * @return montant de l'amende (double)
     */
    double calculerAmende(int joursRetard);
}
