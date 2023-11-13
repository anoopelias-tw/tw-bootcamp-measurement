package org.measurement;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LengthTest {

    @Test
    public void test100MeterIsEqualTo100Meter() {
        Length length = new Length(100, Length.Unit.METER);
        assertEquals(new Length(100, Length.Unit.METER), length);
    }

    @Test
    public void test1MeterNotEqualTo2Meter() {
        Length length = new Length(1, Length.Unit.METER);
        assertNotEquals(new Length(2, Length.Unit.METER), length);
    }

    @Test
    public void test1000MeterEquals1Kilometer() {
        Length length = new Length(1000, Length.Unit.METER);
        assertEquals(new Length(1, Length.Unit.KILOMETER), length);
    }

    @Test
    public void test2000MeterEquals2Kilometer() {
        Length length = new Length(2000, Length.Unit.METER);
        assertEquals(new Length(2, Length.Unit.KILOMETER), length);
    }

    @Test
    public void test1KilometerEquals1000Meter() {
        Length length = new Length(1, Length.Unit.KILOMETER);
        assertEquals(new Length(1000, Length.Unit.METER), length);
    }

    @Test
    public void test3KmEquals3000Meter() {
        Length length = new Length(3, Length.Unit.KILOMETER);
        assertEquals(new Length(3000, Length.Unit.METER), length);
    }

    @Test
    public void testAnotherObjectNotEqualToLength() {
        Integer thousand = 1000;
        assertNotEquals(new Length(1000, Length.Unit.METER), thousand);
    }

    @Test
    public void testLengthNotEqualsNull() {
        assertNotEquals(new Length(1000, Length.Unit.METER), null);
    }

    @Test
    public void testLengthAsHashMapKey() {
        Map<Length, Integer> testMap = new HashMap<>();
        Length length = new Length(100, Length.Unit.METER);
        testMap.put(length, 15);
        assertNotNull(testMap.get(new Length(100, Length.Unit.METER)));
    }

    @Test
    public void testPutLengthWithMeterAsUnitAndGetLengthWithKilometerAsUnit() {
        Map<Length, Integer> map = new HashMap<>();
        Length length = new Length(1000, Length.Unit.METER);
        map.put(length, 13);
        assertNotNull(map.get(new Length(1, Length.Unit.KILOMETER)));
    }

    @Test
    public void test100CentimeterEquals1Meter() {
        Length length = new Length(100, Length.Unit.CENTIMETER);
        assertEquals(new Length(1, Length.Unit.METER), length);
    }

    @Test
    public void test200CentimeterEquals2Meter() {
        Length length = new Length(200, Length.Unit.CENTIMETER);
        assertEquals(new Length(2, Length.Unit.METER), length);
    }

    @Test
    public void test150CentimeterNotEquals125Meter() {
        Length length = new Length(150, Length.Unit.CENTIMETER);
        assertNotEquals(new Length(125, Length.Unit.CENTIMETER), length);
    }

    @Test
    public void test10MetersEquals1000Centimeters() {
        Length length = new Length(10, Length.Unit.METER);
        assertEquals(new Length(1000, Length.Unit.CENTIMETER), length);
    }

    @Test
    public void test5KilometerEquals500000Centimeters() {
        Length length = new Length(5, Length.Unit.KILOMETER);
        assertEquals(new Length(500000, Length.Unit.CENTIMETER), length);
    }

    @Test
    public void test200000CentimetersEquals2Kilometer() {
        Length length = new Length(200000, Length.Unit.CENTIMETER);
        assertEquals(new Length(2, Length.Unit.KILOMETER), length);
    }
}
