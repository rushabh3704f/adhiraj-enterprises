package com.shope.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shope.dev.model.UnitTypeMaster;

public interface UnitTypeMasterRepository extends JpaRepository<UnitTypeMaster, Long> {

	@Query(value = "SELECT * FROM unit_type_master m where is_active='A'", nativeQuery = true)
	public List<UnitTypeMaster> getAllUnitTypeList();

	@Modifying
	@Transactional
	@Query(value = "UPDATE unit_type_master set is_active ='D' where id=:employeeId", nativeQuery = true)
	public void deleteCreatedSaleProductById(@Param("employeeId") String employeeId);

}
