package com.Project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

	Optional<User> findByUserid(Long userid);

	

	void deleteByuserid(Long userId);
}
