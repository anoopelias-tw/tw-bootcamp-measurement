package org.measurement;

import java.util.Objects;

public class Length {

    private final int value;

    public enum Unit {
        METER,
        KILOMETER,
        CENTIMETER;

        private int toCentimeters(int value) {
            return value * switch (this) {
                case KILOMETER -> 100000;
                case METER -> 100;
                case CENTIMETER -> 1;
            };
        }
    }

    public Length(int value, Unit unit) {
        this.value = unit.toCentimeters(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return this.value == length.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }
}
