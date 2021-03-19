package com.shope.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shope.dev.model.ShopeCreateEmployee;
import com.shope.dev.model.ShopeCreateEmployeeSalary;

@Repository
public interface ShopeCreateEmployeeRepository extends JpaRepository<ShopeCreateEmployee, Long> {

	@Query(value = "SELECT * FROM shope_create_employee m where is_active='A'", nativeQuery = true)
	public List<ShopeCreateEmployee> getAllEmployeList();

	@Modifying
	@Transactional
	@Query(value = "UPDATE shope_create_employee set is_active ='D' where id=:employeeId", nativeQuery = true)
	public void deleteEmployeeById(@Param("employeeId") String employeeId);
	
	@Query(value = "SELECT COALESCE(max(id),0) FROM shope_create_employee m", nativeQuery = true)
	int getMaxEmployee();
	
	@Query(value = "SELECT * FROM shope_create_employee m where is_active='A' and employee_id=:employeeId", nativeQuery = true)
	public ShopeCreateEmployee getEmployeeSalary(@Param("employeeId") String employeeId);
	

}
