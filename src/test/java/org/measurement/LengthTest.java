package org.measurement;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LengthTest {

    @Test
    public void test100MeterIsEqualTo100Meter() {
        Length length = new Length(100, Unit.METER);
        assertEquals(new Length(100, Unit.METER), length);
    }

    @Test
    public void test1MeterNotEqualTo2Meter() {
        Length length = new Length(1, Unit.METER);
        assertNotEquals(new Length(2, Unit.METER), length);
    }

    @Test
    public void test1000MeterEquals1Kilometer() {
        Length length = new Length(1000, Unit.METER);
        assertEquals(new Length(1, Unit.KILOMETER), length);
    }

    @Test
    public void test2000MeterEquals2Kilometer() {
        Length length = new Length(2000, Unit.METER);
        assertEquals(new Length(2, Unit.KILOMETER), length);
    }

    @Test
    public void test1KilometerEquals1000Meter() {
        Length length = new Length(1, Unit.KILOMETER);
        assertEquals(new Length(1000, Unit.METER), length);
    }

    @Test
    public void test3KmEquals3000Meter() {
        Length length = new Length(3, Unit.KILOMETER);
        assertEquals(new Length(3000, Unit.METER), length);
    }

    @Test
    public void testAnotherObjectNotEqualToLength() {
        Integer thousand = 1000;
        assertNotEquals(new Length(1000, Unit.METER), thousand);
    }

    @Test
    public void testLengthNotEqualsNull() {
        assertNotEquals(new Length(1000, Unit.METER), null);
    }

    @Test
    public void testLengthAsHashMapKey() {
        Map<Length, Integer> testMap = new HashMap<>();
        Length length = new Length(100, Unit.METER);
        testMap.put(length, 15);
        assertNotNull(testMap.get(new Length(100, Unit.METER)));
    }

    @Test
    public void testPutLengthWithMeterAsUnitAndGetLengthWithKilometerAsUnit() {
        Map<Length, Integer> map = new HashMap<>();
        Length length = new Length(1000, Unit.METER);
        map.put(length, 13);
        assertNotNull(map.get(new Length(1, Unit.KILOMETER)));
    }

    @Test
    public void test100CentimeterEquals1Meter() {
        Length length = new Length(100, Unit.CENTIMETER);
        assertEquals(new Length(1, Unit.METER), length);
    }

    @Test
    public void test200CentimeterEquals2Meter() {
        Length length = new Length(200, Unit.CENTIMETER);
        assertEquals(new Length(2, Unit.METER), length);
    }

    @Test
    public void test150CentimeterNotEquals125Meter() {
        Length length = new Length(150, Unit.CENTIMETER);
        assertNotEquals(new Length(125, Unit.CENTIMETER), length);
    }

    @Test
    public void test10MetersEquals1000Centimeters() {
        Length length = new Length(10, Unit.METER);
        assertEquals(new Length(1000, Unit.CENTIMETER), length);
    }

    @Test
    public void test5KilometerEquals500000Centimeters() {
        Length length = new Length(5, Unit.KILOMETER);
        assertEquals(new Length(500000, Unit.CENTIMETER), length);
    }

    @Test
    public void test200000CentimetersEquals2Kilometer() {
        Length length = new Length(200000, Unit.CENTIMETER);
        assertEquals(new Length(2, Unit.KILOMETER), length);
    }
}
