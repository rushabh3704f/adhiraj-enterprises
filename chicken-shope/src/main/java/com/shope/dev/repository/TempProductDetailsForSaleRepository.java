package com.shope.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shope.dev.model.TempProductDetailsForSale;

@Repository
public interface TempProductDetailsForSaleRepository extends JpaRepository<TempProductDetailsForSale, Long> {
	
	@Query(value = "SELECT * FROM temp_product_details_for_sale m where is_active='A'", nativeQuery = true)
	public List<TempProductDetailsForSale> getAllProductDetailsByBillingNumber();

	@Modifying
	@Transactional
	@Query(value = "UPDATE temp_product_details_for_sale set is_active ='D' where id=:employeeId", nativeQuery = true)
	public void deleteProductFromListByProductId(@Param("employeeId") String employeeId);
	
	
	@Query(value = "SELECT COALESCE(sum(sum),0) FROM temp_product_details_for_sale m where is_active='A'", nativeQuery = true)
	public int getSumOfProduct();

}
