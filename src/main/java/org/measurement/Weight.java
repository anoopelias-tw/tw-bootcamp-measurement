package org.measurement;

public class Weight extends Measurement {

    public static Weight milligram(double value) {
        return new Weight(value, MILLIGRAM);
    }

    public static Weight gram(double value) {
        return new Weight(value, GRAM);
    }

    public static Weight kilogram(double value) {
        return new Weight(value, KILOGRAM);
    }

    private static class WeightUnit extends Measurement.Unit {
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

    @Override
    public Measurement add(Measurement weight) {
        if (getClass() != weight.getClass()) throw new RuntimeException("Operating on two different classes");
        double result = this.toLowestUnit() + weight.toLowestUnit();
        WeightUnit unit = (WeightUnit) this.unit;
        return new Weight(unit.fromLowestUnit(result), unit);
    }
}
