package org.measurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.measurement.Weight.*;

public class WeightTest {

    @Test
    public void test1000GramEquals1Kilogram() {
        Weight weight = gram(1000);
        assertEquals(kilogram(1), weight);
    }

    @Test
    public void test1KilogramNotEquals2Kilogram() {
        Weight weight = kilogram(1);
        assertNotEquals(kilogram(2), weight);
    }

    @Test
    public void test2000GramEquals2Kilogram() {
        Weight weight = kilogram(2);
        assertEquals(kilogram(2), weight);
    }

    @Test
    public void test2000000MilligramsEqualTo2Kilogram() {
        Weight weight = milligram(2000000);
        assertEquals(kilogram(2), weight);
    }

    @Test
    public void test2KilogramEqualsTo2000000Milligrams() {
        Weight weight = kilogram(2);
        assertEquals(milligram(2000000), weight);
    }

    @Test
    public void test1000GramsPlus1000GramsEquals2000Grams() {
        Weight weight = gram(1000);
        Weight result = weight.add(gram(1000));
        assertTrue(result.exactlyEquals(gram(2000)));
    }

    @Test
    public void test1KilogramPlus300GramsEqualsTo1p3Kilograms() {
        Weight weight = kilogram(1);
        Weight result = weight.add(gram(300));
        assertTrue(result.exactlyEquals(kilogram(1.3)));
    }
}
