package org.measurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.measurement.Temperature.*;

public class TemperatureTest {

    @Test
    public void testZeroDegreeCelsiusEqualTo32DegreeFahrenheit() {
        Temperature temperature = celsius(0);
        assertEquals(fahrenheit(32), temperature);
    }

    @Test
    public void testZeroDegreeCelsiusNotEqualTo1Fahrenheit() {
        Temperature temperature = celsius(0);
        assertNotEquals(fahrenheit(1), temperature);
    }

    @Test
    public void testZeroDegreeCelsiusEqualTo273p15Kelvin() {
        Temperature temperature = celsius(0);
        assertEquals(kelvin(273.15), temperature);
    }
}
