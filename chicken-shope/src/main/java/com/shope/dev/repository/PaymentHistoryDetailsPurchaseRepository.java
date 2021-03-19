package com.shope.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shope.dev.model.PaymentHistoryDetails;
import com.shope.dev.model.PaymentHistoryDetailsPurchase;

@Repository
public interface PaymentHistoryDetailsPurchaseRepository extends JpaRepository<PaymentHistoryDetailsPurchase, Long> {

	@Query(value = "SELECT * FROM payment_history_details_purchase m where billing_number=:billing_number", nativeQuery = true)
	public List<PaymentHistoryDetailsPurchase> getPaymentHistoryByBill(@Param("billing_number") String billing_number);

}
