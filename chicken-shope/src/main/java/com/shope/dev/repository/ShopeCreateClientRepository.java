package com.shope.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shope.dev.model.ShopeCreateClient;

@Repository
public interface ShopeCreateClientRepository extends JpaRepository<ShopeCreateClient, Long> {

	@Query(value = "SELECT * FROM shope_create_client m where is_active='A'", nativeQuery = true)
	public List<ShopeCreateClient> getAllEmployeList();

	@Modifying
	@Transactional
	@Query(value = "UPDATE shope_create_client set is_active ='D' where id=:employeeId", nativeQuery = true)
	public void deleteEmployeeById(@Param("employeeId") String employeeId);

	@Query(value = "SELECT * FROM shope_create_client m where is_active='A' and client_id=:clientId", nativeQuery = true)
	public ShopeCreateClient getClientDetailsById(@Param("clientId") String clientId);
	
	@Query(value = "SELECT COALESCE(max(id),0) FROM shope_create_client m", nativeQuery = true)
	int getMaxClient();

}
