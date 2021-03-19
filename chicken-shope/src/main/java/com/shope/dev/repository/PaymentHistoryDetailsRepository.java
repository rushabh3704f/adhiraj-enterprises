package com.shope.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shope.dev.model.PaymentHistoryDetails;

@Repository
public interface PaymentHistoryDetailsRepository extends JpaRepository<PaymentHistoryDetails, Long> {

	@Query(value = "SELECT * FROM payment_history_details m where billing_number=:billing_number", nativeQuery = true)
	public List<PaymentHistoryDetails> getPaymentHistoryByBill(@Param("billing_number") String billing_number);

}
