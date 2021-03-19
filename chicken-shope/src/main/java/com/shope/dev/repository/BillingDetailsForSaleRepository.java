package com.shope.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shope.dev.model.BillingDetailsForSale;

@Repository
public interface BillingDetailsForSaleRepository extends JpaRepository<BillingDetailsForSale, Long>{
	
	@Query(value = "SELECT * FROM billing_details_for_sale m where is_active='A'", nativeQuery = true)
	public List<BillingDetailsForSale> getAllCreateOrderForSale();

	@Modifying
	@Transactional
	@Query(value = "UPDATE billing_details_for_sale set is_active ='D' where id=:employeeId", nativeQuery = true)
	public void deleteShopeCreateOrderForSaleById(@Param("employeeId") String employeeId);
	
	@Query(value = "SELECT COALESCE(max(id),0) FROM billing_details_for_sale m", nativeQuery = true)
	int getMaxNumber();
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE billing_details_for_sale set bill_amount =:bill_amount,un_paid_amount=:un_paid_amount where billing_number=:billing_number", nativeQuery = true)
	public void updateBillingDetailsForSale(@Param("billing_number") String billing_number,@Param("bill_amount") String bill_amount,@Param("un_paid_amount") int un_paid_amount);
	
	@Query(value = "SELECT paid_amount FROM billing_details_for_sale m where billing_number=:billing_number", nativeQuery = true)
	int getPaidAmountForSale(@Param("billing_number") String billing_number);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE billing_details_for_sale set paid_amount =:paid_amount,un_paid_amount=:un_paid_amount where billing_number=:billing_number", nativeQuery = true)
	public void updateProductDetailsForSaleByBillNumber(@Param("paid_amount") String paid_amount,@Param("un_paid_amount") String un_paid_amount,@Param("billing_number") String billing_number);

	@Modifying
	@Transactional
	@Query(value = "UPDATE billing_details_for_sale set is_active ='D',bill_amount-=:amount where billing_number=:billing_number", nativeQuery = true)
	public void deletePoductUpdateAmount(@Param("billing_number") String billing_number,@Param("amount") String amount);
	
}
