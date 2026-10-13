package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuddyInfoTest {

    private BuddyInfo buddy;

    @BeforeEach
    void setUp() {
        buddy = new BuddyInfo("Homer Simpson", "613-555-1234");
    }

    @AfterEach
    void tearDown() {
        buddy = null;
    }

    @Test
    void getName() {
        assertEquals("Homer Simpson", buddy.getName());
    }

    @Test
    void setName() {
        buddy.setName("Marge Simpson");
        assertEquals("Marge Simpson", buddy.getName());
    }

    @Test
    void getPhoneNumber() {
        assertEquals("613-555-1234", buddy.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        buddy.setPhoneNumber("613-555-5678");
        assertEquals("613-555-5678", buddy.getPhoneNumber());
    }

    @Test
    void testToString() {
        String result = buddy.toString();
        assertTrue(result.contains("Homer Simpson"));
        assertTrue(result.contains("613-555-1234"));
    }
}