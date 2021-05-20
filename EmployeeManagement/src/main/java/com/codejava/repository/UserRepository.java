package com.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codejava.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
