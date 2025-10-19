package Strategy;
/**
 * Amende fixe, indépendante du nombre de jours.
 */
public class AmendeFixe implements StrategieAmende {
    private final double montantFixe;

    public AmendeFixe(double montantFixe) {
        this.montantFixe = montantFixe;
    }

    @Override
    public double calculerAmende(int joursRetard) {
        return joursRetard > 0 ? montantFixe : 0.0;
    }
}
