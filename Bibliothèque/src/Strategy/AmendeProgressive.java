package Strategy;
/**
 * Amende progressive : tarif initial puis majoration au-delà d'un seuil.
 */
public class AmendeProgressive implements StrategieAmende {
    private final double tarifInitial;
    private final double tarifMajore;
    private final int seuilMajoration;

    public AmendeProgressive(double tarifInitial, double tarifMajore, int seuilMajoration) {
        this.tarifInitial = tarifInitial;
        this.tarifMajore = tarifMajore;
        this.seuilMajoration = seuilMajoration;
    }

    @Override
    public double calculerAmende(int joursRetard) {
        if (joursRetard <= 0) return 0.0;
        int premiers = Math.min(joursRetard, seuilMajoration);
        int rest = Math.max(0, joursRetard - seuilMajoration);
        return premiers * tarifInitial + rest * tarifMajore;
    }
}
