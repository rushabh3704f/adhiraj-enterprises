package com.shope.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shope.dev.model.ShopeCreateProductForSale;

public interface ShopeCreateProductForSaleRepository extends JpaRepository<ShopeCreateProductForSale, Long> {

	@Query(value = "SELECT * FROM shope_create_product_for_sale m where is_active='A' order by product_id asc", nativeQuery = true)
	public List<ShopeCreateProductForSale> getCreatedSaleProduct();

	@Modifying
	@Transactional
	@Query(value = "UPDATE shope_create_product_for_sale set is_active ='D' where id=:employeeId", nativeQuery = true)
	public void deleteCreatedSaleProductById(@Param("employeeId") String employeeId);
	
	@Query(value = "SELECT * FROM shope_create_product_for_sale m where is_active='A' and product_id=:productId", nativeQuery = true)
	ShopeCreateProductForSale getDropdownValueByProductId(@Param("productId") String productId);
	
	@Query(value = "SELECT COALESCE(max(id),0) FROM shope_create_product_for_sale m", nativeQuery = true)
	int getMaxProduct();
	
	
}
