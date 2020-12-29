package Interval;

import org.junit.Test;
import static org.junit.Assert.*;


public class IntervalTest {

    Interval interval1 = new Interval(2, 7);
    Interval interval2 = new Interval(1, 4);
    Interval interval3 = new Interval(3, 5);
    Interval interval4 = new Interval(9, 15);
    Interval interval5 = new Interval(2, 7);

    @Test
    public void testMerge() {

        assertEquals(new Interval(1, 7).toString(), interval1.merge(interval2).toString());
    }

    @Test
    public void testContains() {
        assertTrue(interval1.contains(interval3));
        assertFalse(interval1.contains(interval2));
        assertTrue(interval1.contains(5));
        assertFalse(interval1.contains(10));
    }

    @Test 
    public void testIsDisjoint() {
        assertFalse(interval1.isDisjoint(interval2));
        assertTrue(interval1.isDisjoint(interval4));
    }

    @Test
    public void testEquals() {
        assertTrue(interval1.equals(interval5));
        assertFalse(interval1.equals(interval2));
    }

    @Test
    public void length() {
        assertEquals(5, interval1.length());
        assertEquals(3, interval2.length());
    }


}