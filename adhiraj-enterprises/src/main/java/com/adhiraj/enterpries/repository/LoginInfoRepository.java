package com.adhiraj.enterpries.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adhiraj.enterpries.model.MasterLoginDetails;

public interface LoginInfoRepository extends JpaRepository<MasterLoginDetails, Long> {
	
	@Query(value="SELECT * FROM master_login_details m WHERE m.employee_id = :employee_id AND m.accesscode = :accesscode",  nativeQuery = true)
    public MasterLoginDetails checkLogin(@Param("employee_id") String employee_id, @Param("accesscode") String accesscode);
	
	
}
