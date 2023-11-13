package org.measurement;

public enum Unit {
    METER,
    KILOMETER,
    CENTIMETER;

    public int toCentimeters(int value) {
        return value * switch (this) {
            case KILOMETER -> 100000;
            case METER -> 100;
            case CENTIMETER -> 1;
        };
    }
}
