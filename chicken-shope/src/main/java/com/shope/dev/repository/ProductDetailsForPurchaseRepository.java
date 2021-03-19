package com.shope.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shope.dev.model.ProductDetailsForPurchase;

@Repository
public interface ProductDetailsForPurchaseRepository extends JpaRepository<ProductDetailsForPurchase, Long> {

	@Query(value = "SELECT * FROM product_details_for_purchase m WHERE m.billing_number = :billing_number", nativeQuery = true)
	public List<ProductDetailsForPurchase> getAllProductDetailsForPurchaseList(@Param("billing_number") String billing_number);

}
