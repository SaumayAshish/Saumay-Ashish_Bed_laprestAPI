package com.glearning.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.lms.model.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String username);
}
