package com.adhiraj.enterpries.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adhiraj.enterpries.model.MasterLoginDetails;


@Repository
public interface MasterLoginRepository extends JpaRepository<MasterLoginDetails, Long> {
	
	@Query(value="SELECT * FROM master_login_details m WHERE m.employee_id != :employee_id",  nativeQuery = true)
    public List<MasterLoginDetails> getAllEmployee(@Param("employee_id") String employee_id);
	
	@Query(value="SELECT * FROM master_login_details m WHERE m.employee_id =:employee_id",  nativeQuery = true)
    public MasterLoginDetails getEmployee(@Param("employee_id") String employee_id);
	
	@Query(value="SELECT * FROM master_login_details",  nativeQuery = true)
    public List<MasterLoginDetails> getAllEmployeeList();
	
	@Query(value="SELECT * FROM master_login_details m WHERE m.role_id = :role_id",  nativeQuery = true)
    public List<MasterLoginDetails> getAllEmployeeByRoleid(@Param("role_id") int role_id);
	
	@Query(value="SELECT * FROM master_login_details WHERE employee_id=:employee_id LIMIT 1",nativeQuery=true)
	MasterLoginDetails getDSAPartnerDetails(@Param("employee_id") String employee_id);

}