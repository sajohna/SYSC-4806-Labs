package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(AddressBookDB repository) {
        return (args) -> {
            AddressBook addressBook = new AddressBook();
            addressBook.addBuddy(new BuddyInfo("Homer Simpson", "613-555-1234", "742 Evergreen Terrace"));
            addressBook.addBuddy(new BuddyInfo("Marge Simpson", "613-555-5678", "742 Evergreen Terrace"));

            repository.save(addressBook);

            System.out.println("Saved! Data from database:");
            for (AddressBook book : repository.findAll()) {
                System.out.println(book);
            }
        };
    }
}