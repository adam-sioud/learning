package uke14.counter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class CounterTest {
    
    private Counter counter;
    
    @BeforeEach
    public void setUp() {
        counter = new Counter(5);
    }

    @Test
    @DisplayName("Rett tilstand etter konstruksjon")
    public void testInitialState() {
        assertEquals(0, counter.getCount()); 
    }

    @Test
    public void constructorThrowsIAE() {
        assertThrows(IllegalArgumentException.class, 
            () -> new Counter(-1));
    }

    @Test
    public void constructorDoesNotThrowIAE() {
        assertDoesNotThrow(() -> new Counter(0));
        assertDoesNotThrow(() -> new Counter(1));
    }
    @Test
    public void alternativeIAEUsingFail() {
        try {
            new Counter(-1);
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected
        }
    }
    @Test
    public void countIncreasesCounterIfNotMax() {
        assertFalse(counter.isMax());
        for (int i = 1; i <= 5; i++) {
            counter.count();
            assertEquals(i, counter.getCount());
        }
        assertTrue(counter.isMax());
        counter.count();
        assertEquals(5, counter.getCount());
    }
}
