package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JPATest {

    @Autowired
    private AddressBookDB addressBookRepository;

    @Test
    void testPersistAddressBookAndBuddies() {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("Homer Simpson", "613-555-1234");
        BuddyInfo buddy2 = new BuddyInfo("Marge Simpson", "613-555-5678");

        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);

        // Save using Spring Data JPA repository instead of EntityManager
        addressBookRepository.save(addressBook);

        // Query the AddressBook back from the H2 database
        AddressBook foundBook = addressBookRepository.findById(addressBook.getId()).orElse(null);

        assertNotNull(foundBook);
        assertEquals(2, foundBook.getBuddies().size());
        assertEquals("Homer Simpson", foundBook.getBuddies().get(0).getName());
        assertEquals("Marge Simpson", foundBook.getBuddies().get(1).getName());
    }
}