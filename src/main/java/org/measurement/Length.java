package org.measurement;

import java.util.Objects;

public class Length {

    private final int value;

    private final Unit unit;

    public Length(int value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    private int toMeters() {
        if (this.unit == Unit.KILOMETER) {
            return this.value * 1000;
        } else {
            return this.value;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return this.toMeters() == length.toMeters();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toMeters());
    }
}
