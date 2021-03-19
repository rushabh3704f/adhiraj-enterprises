package com.shope.dev.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shope.dev.model.Roles;

@Repository
public interface RoleMasterRepository extends CrudRepository<Roles, Long> {
	
	@Query(value = "SELECT * FROM roles", nativeQuery=true)
    public List<Roles> getRolesList();
	
	@Query(value = "SELECT * FROM roles WHERE role_id=:roleid", nativeQuery=true)
    public List<Roles> getRolesById(@Param(value = "roleid") int roleid);
}