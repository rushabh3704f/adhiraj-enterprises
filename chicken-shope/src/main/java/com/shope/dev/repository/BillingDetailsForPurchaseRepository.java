package com.shope.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shope.dev.model.BillingDetailsForPurchase;
import com.shope.dev.model.BillingDetailsForSale;

@Repository
public interface BillingDetailsForPurchaseRepository extends JpaRepository<BillingDetailsForPurchase, Long> {

	@Query(value = "SELECT * FROM billing_details_for_purchase m where is_active='A'", nativeQuery = true)
	public List<BillingDetailsForPurchase> getAllCreateOrderForPurchase();
	
	
	@Query(value = "SELECT * FROM billing_details_for_purchase m where is_active='A' and billing_number=:billing_number", nativeQuery = true)
	public BillingDetailsForPurchase getCreateOrderForPurchase(@Param("billing_number") String billing_number);

	@Modifying
	@Transactional
	@Query(value = "UPDATE billing_details_for_purchase set is_active ='D' where id=:employeeId", nativeQuery = true)
	public void deleteShopeCreateOrderForPurchaseById(@Param("employeeId") String employeeId);

	@Query(value = "SELECT COALESCE(max(id),0) FROM billing_details_for_purchase m", nativeQuery = true)
	int getMaxNumberFormPurchase();

	
	@Modifying
	@Transactional
	@Query(value = "UPDATE billing_details_for_purchase set paid_amount =:paid_amount,un_paid_amount=:un_paid_amount where billing_number=:billing_number", nativeQuery = true)
	public void updateProductDetailsForSaleByBillNumber(@Param("paid_amount") String paid_amount,@Param("un_paid_amount") String un_paid_amount,@Param("billing_number") String billing_number);

}
