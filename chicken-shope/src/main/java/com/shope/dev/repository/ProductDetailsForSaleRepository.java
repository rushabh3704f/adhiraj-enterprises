package com.shope.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shope.dev.model.ProductDetailsForPurchase;
import com.shope.dev.model.ProductDetailsForSale;

@Repository
public interface ProductDetailsForSaleRepository extends JpaRepository<ProductDetailsForSale, Long> {

	@Query(value = "SELECT * FROM product_details_for_sale m WHERE m.billing_number = :billing_number and is_active='A'", nativeQuery = true)
	public List<ProductDetailsForSale> getAllProductDetailsForSaleList(@Param("billing_number") String billing_number);
	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE product_details_for_sale set is_active ='D' where id=:id", nativeQuery = true)
	public void deleteProductDetailsForSaleById(@Param("id") String id);
	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE product_details_for_sale set unit =:unit,sum=:sum where id=:id", nativeQuery = true)
	public void updateProductDetailsForSaleById(@Param("unit") String unit,@Param("sum") String sum,@Param("id") Long id);

}
