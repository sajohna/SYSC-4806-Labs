package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    private AddressBook addressBook;
    private BuddyInfo buddy;

    @BeforeEach
    void setUp() {
        addressBook = new AddressBook();
        buddy = new BuddyInfo("Homer Simpson", "613-555-1234");
    }

    @AfterEach
    void tearDown() {
        addressBook = null;
        buddy = null;
    }

    @Test
    void addBuddy() {
        addressBook.addBuddy(buddy);
        assertEquals(1, addressBook.getBuddies().size());
        assertTrue(addressBook.getBuddies().contains(buddy));
    }

    @Test
    void removeBuddy() {
        addressBook.addBuddy(buddy);
        addressBook.removeBuddy(buddy);
        assertTrue(addressBook.getBuddies().isEmpty());
    }

    @Test
    void getBuddies() {
        addressBook.addBuddy(buddy);
        assertNotNull(addressBook.getBuddies());
        assertEquals(1, addressBook.getBuddies().size());
    }

    @Test
    void testToString() {
        addressBook.addBuddy(buddy);
        String result = addressBook.toString();
        assertTrue(result.contains("Homer Simpson"));
        assertTrue(result.contains("613-555-1234"));
    }
}