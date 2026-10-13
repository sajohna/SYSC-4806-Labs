package org.example;

import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoDB extends CrudRepository<BuddyInfo, Long> {
}