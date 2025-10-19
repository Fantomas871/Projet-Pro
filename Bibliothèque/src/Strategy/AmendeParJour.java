package Strategy;

/**
 * Amende calculée au tarif fixe par jour.
 */
public class AmendeParJour implements StrategieAmende {
    private final double tarifParJour;

    public AmendeParJour(double tarifParJour) {
        this.tarifParJour = tarifParJour;
    }

    @Override
    public double calculerAmende(int joursRetard) {
        if (joursRetard <= 0) return 0.0;
        return tarifParJour * joursRetard;
    }
}
