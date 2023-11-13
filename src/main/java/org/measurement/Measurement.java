package org.measurement;

import java.util.Objects;

public abstract class Measurement {
    private final double value;
    protected final Unit unit;

    public static class Unit {
        private final int conversionFactor;

        public Unit(int conversionFactor) {
            this.conversionFactor = conversionFactor;
        }
        public double toLowestUnit(double value) {
            return value * conversionFactor;
        }
        public double fromLowestUnit(double value) {
            return value / conversionFactor;
        }
    }

    public Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Measurement measurement = (Measurement) o;
        return this.toLowestUnit() == measurement.toLowestUnit() ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toLowestUnit());
    }

    public abstract Measurement add(Measurement other);

    protected double toLowestUnit() {
        return this.unit.toLowestUnit(this.value);
    }

    public boolean exactlyEquals(Measurement other) {
        return this.value == other.value && this.unit.equals(other.unit);
    }
}
