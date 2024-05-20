package uke14.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {
    Person p1, p2, p3, p4;


    @BeforeEach
    void setUp() {
        p1 = new Person("Ola");
        p2 = new Person("Kari");
        p3 = new Person("Per");
        p4 = new Person("Pål");
    }

    @Test
    void testSetPartner() {
        p1.setPartner(p2);
        assertEquals(p2, p1.getPartner());
        assertEquals(p1, p2.getPartner());
    }

    @Test
    void testSetPartnerNull() {
        p1.setPartner(p2);
        p1.setPartner(null);
        assertNull(p1.getPartner());
        assertNull(p2.getPartner());
    }

    @Test
    void testSetPartnerWithExistingPartner() {
        p1.setPartner(p2);
        p3.setPartner(p4);
        p1.setPartner(p4);
        assertEquals(p4, p1.getPartner());
        assertEquals(p1, p4.getPartner());
        assertNull(p2.getPartner());
        assertNull(p3.getPartner());
    }

    @Test
    void testSetPartnerWithSelf() {
        // Alternative 1
        try {
            p1.setPartner(p1);
            fail("Should have thrown an exception");
        } catch (IllegalArgumentException e) {
            // Expected
        } catch (Exception e) {
            fail("Should have thrown IllegalArgumentException");
        }
        // Alternative 2
        try {
            p1.setPartner(p1);
            fail("Should have thrown an exception");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
        // Alternative 3
        Exception e = assertThrows(IllegalArgumentException.class, () -> p1.setPartner(p1));
        assertEquals("Cannot be partner with oneself", e.getMessage());
    }

    
}
