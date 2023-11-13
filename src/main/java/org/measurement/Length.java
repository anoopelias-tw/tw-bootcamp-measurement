package org.measurement;

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

    public boolean equals(Length length) {
        return this.toMeters() == length.toMeters();
    }
}
