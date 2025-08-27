package com.adhiraj.enterpries.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adhiraj.enterpries.model.MenuMaster;

@Repository
public interface MenuMasterRepository extends JpaRepository<MenuMaster, Long> {
	
	@Query(value = "SELECT * FROM menu_master m WHERE m.role_id = :role_id AND m.organisation_id = :organisation_id AND is_active='1'", nativeQuery=true)
    public List<MenuMaster> getMenuMasterList(@Param("role_id") int role_id, @Param("organisation_id") int organisation_id);
	
	@Query(value = "SELECT * FROM menu_master", nativeQuery=true)
    public List<MenuMaster> getMenuMasterAllList();
}