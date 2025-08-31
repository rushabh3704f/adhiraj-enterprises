package com.adhiraj.enterpries.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adhiraj.enterpries.model.BookingEntryModel;
import com.adhiraj.enterpries.repository.BookingEntryRepository;
import com.adhiraj.enterpries.service.DigitalShopeService;

@Service
public class DigitalShopeServiceImpl implements DigitalShopeService{

	@Autowired
	BookingEntryRepository allocationDetailsRepository;

	public List<BookingEntryModel> fetchBookingDetails() {
		List<BookingEntryModel> allocationDetailsModel = allocationDetailsRepository.fetchBookingDetails();
		return allocationDetailsModel;
	}

}
