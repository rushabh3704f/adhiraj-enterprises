package com.marvel.adhirajEnterprieses.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.marvel.adhirajEnterprieses.model.BookingEntry;

public interface BookingEntryRepository extends JpaRepository<BookingEntry, Long> {
}
