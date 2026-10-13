package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AddressBookController.class)
public class AddressBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressBookDB addressBookRepository;

    @Test
    public void testViewAddressBook() throws Exception {
        AddressBook addressBook = new AddressBook();
        addressBook.setId(1L);
        addressBook.addBuddy(new BuddyInfo("Homer Simpson", "613-555-1234", "742 Evergreen Terrace"));

        when(addressBookRepository.findById(1L)).thenReturn(Optional.of(addressBook));

        mockMvc.perform(get("/addressbook/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("addressbook"))
                .andExpect(model().attributeExists("addressBook"));
    }
}