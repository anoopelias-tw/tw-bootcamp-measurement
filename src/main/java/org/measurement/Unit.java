package org.measurement;

public class Unit {
    private final double conversionFactor;

    private final double offset;

    public Unit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
        this.offset = 0;
    }

    public Unit(double conversionFactor, double offset) {
        this.conversionFactor = conversionFactor;
        this.offset = offset;
    }

    public double toDefaultUnit(double value) {
        return offset + (value * conversionFactor);
    }

    public double fromDefaultUnit(double value) {
        return (value - offset) / conversionFactor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return conversionFactor == unit.conversionFactor;
    }
}
