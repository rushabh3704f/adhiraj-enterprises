package com.shope.dev.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shope.dev.model.UserData;

@Repository
public interface UserDataRepository extends CrudRepository<UserData, Long> {

	@Query(value = "SELECT * FROM user_data m where is_active='1' and user_name=:user_name and password=:password and roles=:roles", nativeQuery = true)
	UserData isValidUser(@Param("user_name") String user_name, @Param("password") String password,@Param("roles") String roles);
}
