package org.measurement;

import java.util.Objects;

public abstract class Measurement<T extends Measurement<?>> {
    private final double value;
    protected final Unit unit;

    public Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Measurement<T> measurement = (Measurement<T>) o;
        return Math.abs(this.toDefaultUnit() - measurement.toDefaultUnit()) <= 0.00005;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toDefaultUnit());
    }

    public abstract T create(double value);

    public T add(T other) {
        double result = this.toDefaultUnit() + other.toDefaultUnit();
        return this.create(this.unit.fromDefaultUnit(result));
    }

    protected double toDefaultUnit() {
        return this.unit.toDefaultUnit(this.value);
    }

    public boolean exactlyEquals(Measurement<T> other) {
        return this.value == other.value && this.unit.equals(other.unit);
    }
}
