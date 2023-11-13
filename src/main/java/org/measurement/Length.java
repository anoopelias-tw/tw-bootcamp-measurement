package org.measurement;

import java.util.Objects;

public class Length extends Measurement<Length> {

    public static Length centimeter(double value) {
        return new Length(value, CENTIMETER);
    }

    public static Length meter(double value) {
        return new Length(value, METER);
    }

    public static Length kilometer(double value) {
        return new Length(value, KILOMETER);
    }

    private static class LengthUnit extends Measurement.Unit {
        private LengthUnit(int conversionFactor) {
            super(conversionFactor);
        }
    }

    private static final LengthUnit METER = new LengthUnit(100);
    private static final LengthUnit CENTIMETER = new LengthUnit(1);
    private static final LengthUnit KILOMETER = new LengthUnit(100000);

    public Length(double value, LengthUnit unit) {
        super(value, unit);
    }

    public Length create(double value) {
        return new Length(value, (LengthUnit) this.unit);
    }
}
