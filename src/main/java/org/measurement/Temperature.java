package org.measurement;

public class Temperature extends Measurement<Temperature> {

    public static Temperature celsius(double value) {
        return new Temperature(value, CELSIUS);
    }

    public static Temperature fahrenheit(double value) {
        return new Temperature(value, FAHRENHEIT);
    }

    public static Temperature kelvin(double value) {
        return new Temperature(value, KELVIN);
    }

    public static final TemperatureUnit CELSIUS = new TemperatureUnit(1.8, 32);
    public static final TemperatureUnit FAHRENHEIT = new TemperatureUnit(1, 0);
    public static final TemperatureUnit KELVIN = new TemperatureUnit(1.8, -459.67);

    @Override
    public Temperature create(double value) {
        return new Temperature(value, (TemperatureUnit) this.unit);
    }

    private static class TemperatureUnit extends Unit {
        public TemperatureUnit(double conversionFactor, double offset) {
            super(conversionFactor, offset);
        }
    }

    private Temperature(double value, TemperatureUnit unit) {
        super(value, unit);
    }
}
