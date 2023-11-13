package org.measurement;

import java.util.Objects;

public abstract class Measurement<T extends Measurement<?>> {
    private final double value;
    protected final Unit unit;

    public static class Unit {
        private final int conversionFactor;

        public Unit(int conversionFactor) {
            this.conversionFactor = conversionFactor;
        }
        public double toDefaultUnit(double value) {
            return value * conversionFactor;
        }
        public double fromDefaultUnit(double value) {
            return value / conversionFactor;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Unit unit = (Unit) o;
            return conversionFactor == unit.conversionFactor;
        }
    }

    public Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Measurement<T> measurement = (Measurement<T>) o;
        return this.toLowestUnit() == measurement.toLowestUnit() ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toLowestUnit());
    }

    public abstract T create(double value);

    public T add(T other) {
        double result = this.toLowestUnit() + other.toLowestUnit();
        return this.create(this.unit.fromDefaultUnit(result));
    }

    protected double toLowestUnit() {
        return this.unit.toDefaultUnit(this.value);
    }

    public boolean exactlyEquals(Measurement<T> other) {
        return this.value == other.value && this.unit.equals(other.unit);
    }
}
