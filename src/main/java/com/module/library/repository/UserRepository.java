package com.module.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.module.library.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

}
