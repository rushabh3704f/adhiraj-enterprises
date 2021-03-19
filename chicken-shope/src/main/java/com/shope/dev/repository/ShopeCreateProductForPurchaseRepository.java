package com.shope.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shope.dev.model.ShopeCreateProductForPurchase;
import com.shope.dev.model.ShopeCreateProductForSale;

public interface ShopeCreateProductForPurchaseRepository extends JpaRepository<ShopeCreateProductForPurchase, Long> {

	@Query(value = "SELECT * FROM shope_create_product_for_purchase m where is_active='A' order by product_id asc", nativeQuery = true)
	public List<ShopeCreateProductForPurchase> getCreatedPurchaseProduct();

	@Modifying
	@Transactional
	@Query(value = "UPDATE shope_create_product_for_purchase set is_active ='D' where id=:employeeId", nativeQuery = true)
	public void deleteCreatedPurchaseProductById(@Param("employeeId") String employeeId);
	
	@Query(value = "SELECT COALESCE(max(id),0) FROM shope_create_product_for_purchase m", nativeQuery = true)
	int getMaxPurchaseProduct();
	
	
	@Query(value = "SELECT * FROM shope_create_product_for_purchase m where is_active='A' and product_id=:productId", nativeQuery = true)
	ShopeCreateProductForPurchase getDropdownValueForPurchase(@Param("productId") String productId);
}
