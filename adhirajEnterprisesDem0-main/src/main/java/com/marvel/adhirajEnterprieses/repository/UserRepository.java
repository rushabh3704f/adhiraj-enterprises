package com.marvel.adhirajEnterprieses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marvel.adhirajEnterprieses.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmailAndPassword(String email, String password);
}
