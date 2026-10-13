package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AddressBookController {

    @Autowired
    private AddressBookDB addressBookRepository;

    @GetMapping("/")
    public String home() {
        return "redirect:/addressbook/1";
    }

    @GetMapping("/addressbook/{id}")
    public String viewAddressBook(@PathVariable("id") Long id, Model model) {
        AddressBook addressBook = addressBookRepository.findById(id).orElse(null);
        model.addAttribute("addressBook", addressBook);
        return "addressbook";
    }
}