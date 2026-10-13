package org.example;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddies;

    public AddressBook() {
        this.buddies = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addBuddy(BuddyInfo buddy) {
        if (buddy != null) {
            buddies.add(buddy);
        }
    }

    public void removeBuddy(BuddyInfo buddy) {
        buddies.remove(buddy);
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Address Book:\n");
        for (BuddyInfo buddy : buddies) {
            sb.append(buddy.toString()).append("\n");
        }
        return sb.toString();
    }
}