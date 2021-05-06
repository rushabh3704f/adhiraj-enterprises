package com.shope.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shope.dev.model.TempProductDetailsForPurchase;
import com.shope.dev.model.TempProductDetailsForSale;

@Repository
public interface TempProductDetailsForPurchaseRepository extends JpaRepository<TempProductDetailsForPurchase, Long> {
	
	@Query(value = "SELECT * FROM temp_product_details_for_purchase m where is_active='A'", nativeQuery = true)
	public List<TempProductDetailsForPurchase> getAllPurchaseProductDetailsByBillingNumber();

	@Modifying
	@Transactional
	@Query(value = "UPDATE temp_product_details_for_purchase set is_active ='D' where id=:employeeId", nativeQuery = true)
	public void deleteProductFromListByProductId(@Param("employeeId") String employeeId);
	
	
	@Query(value = "SELECT COALESCE(sum(sum),0) FROM temp_product_details_for_purchase m where is_active='A'", nativeQuery = true)
	public double getSumOfPurchaseProduct();
	
	
	

}
