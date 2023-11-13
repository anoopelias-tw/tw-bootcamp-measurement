package org.measurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LengthTest {

    @Test
    public void test100MeterIsEqualTo100Meter() {
        Length length = new Length(100, Unit.METER);
        assertTrue(length.equals(new Length(100, Unit.METER)));
    }

    @Test
    public void test1MeterNotEqualTo2Meter() {
        Length length = new Length(1, Unit.METER);
        assertFalse(length.equals(new Length(2, Unit.METER)));
    }

    @Test
    public void test1000MeterEquals1Kilometer() {
        Length length = new Length(1000, Unit.METER);
        assertTrue(length.equals(new Length(1, Unit.KILOMETER)));
    }

    @Test
    public void test2000MeterEquals2Kilometer() {
        Length length = new Length(2000, Unit.METER);
        assertTrue(length.equals(new Length(2, Unit.KILOMETER)));
    }

    @Test
    public void test1KilometerEquals1000Meter() {
        Length length = new Length(1, Unit.KILOMETER);
        assertTrue(length.equals(new Length(1000, Unit.METER)));
    }

    @Test
    public void test3KmEquals3000Meter() {
        Length length = new Length(3, Unit.KILOMETER);
        assertTrue(length.equals(new Length(3000, Unit.METER)));
    }
}
