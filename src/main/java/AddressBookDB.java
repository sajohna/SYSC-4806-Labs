package org.example;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface AddressBookDB extends CrudRepository<AddressBook, Long> {
    List<AddressBook> findAll();
}