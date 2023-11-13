package org.measurement;

import java.util.Objects;

public class Length {

    private final int value;

    private final Unit unit;


    public Length(int value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return this.unit.toCentimeters(this.value) == length.unit.toCentimeters(length.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.unit.toCentimeters(this.value));
    }
}
