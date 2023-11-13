package org.measurement;

public class Weight extends Measurement<Weight> {

    public static Weight milligram(double value) {
        return new Weight(value, MILLIGRAM);
    }

    public static Weight gram(double value) {
        return new Weight(value, GRAM);
    }

    public static Weight kilogram(double value) {
        return new Weight(value, KILOGRAM);
    }

    private static class WeightUnit extends Unit {
        private WeightUnit(int conversionFactor) {
            super(conversionFactor);
        }
    }

    private static final WeightUnit MILLIGRAM = new WeightUnit(1);
    private static final WeightUnit GRAM = new WeightUnit(1000);
    private static final WeightUnit KILOGRAM = new WeightUnit(1000_000);

    private Weight(double value, WeightUnit unit) {
        super(value, unit);
    }

    public Weight create(double value) {
        return new Weight(value, (WeightUnit) this.unit);
    }
}
