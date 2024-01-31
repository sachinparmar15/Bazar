package com.website.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.website.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	//custom query to fin user byb email
	@Query("SELECT u FROM User u WHERE u.email = :email")
	User findByEmail(@Param("email") String email);
}
