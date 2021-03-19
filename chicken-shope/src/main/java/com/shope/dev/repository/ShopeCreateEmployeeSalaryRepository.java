package com.shope.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shope.dev.model.ShopeCreateEmployeeSalary;

@Repository
public interface ShopeCreateEmployeeSalaryRepository extends JpaRepository<ShopeCreateEmployeeSalary, Long> {

	@Query(value = "SELECT * FROM shope_create_employee_salary m where is_active='A'", nativeQuery = true)
	public List<ShopeCreateEmployeeSalary> getAllSalaryList();

	@Modifying
	@Transactional
	@Query(value = "UPDATE shope_create_employee_salary set is_active ='D' where id=:employeeId", nativeQuery = true)
	public void deleteEmpSalById(@Param("employeeId") String employeeId);
	
	

	

}
