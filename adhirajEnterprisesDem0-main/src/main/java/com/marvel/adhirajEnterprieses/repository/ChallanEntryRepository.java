package com.marvel.adhirajEnterprieses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marvel.adhirajEnterprieses.model.BookingEntry;

@Repository
public interface ChallanEntryRepository extends JpaRepository<BookingEntry, Long> {
	BookingEntry findFirstByVehicleChassisNumberEndingWith(String chassisSuffix);
}