package com.shope.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shope.dev.model.SoldProduct;

@Repository
public interface SoldProductRepository extends JpaRepository<SoldProduct, Long> {

	@Query(value = "SELECT * FROM shope_sold_product m where is_active='A'", nativeQuery = true)
	public List<SoldProduct> getSoldProduct();

	@Modifying
	@Transactional
	@Query(value = "UPDATE shope_sold_product set is_active ='D' where id=:productId", nativeQuery = true)
	public void deleteSoldProductById(@Param("productId") String productId);

}
