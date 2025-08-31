package com.adhiraj.enterpries.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adhiraj.enterpries.model.BookingEntryModel;

@Repository
public interface BookingEntryRepository extends JpaRepository<BookingEntryModel, Long> {

	@Query(value = "SELECT * FROM allocation_dtl_tbl", nativeQuery = true)
	public List<BookingEntryModel> fetchBookingDetails();

	@Query(value = "SELECT * FROM allocation_dtl_tbl where id=1", nativeQuery = true)
	BookingEntryModel getDetailsByVehicleChassisNumber(String chassisSuffix);

}
