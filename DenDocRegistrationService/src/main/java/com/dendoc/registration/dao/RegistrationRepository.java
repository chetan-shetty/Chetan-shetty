package com.dendoc.registration.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dendoc.registration.model.Users;

@Repository
public interface RegistrationRepository extends JpaRepository<Users, Long> {
	
	@Query(value = "SELECT u.login_name from USERS u where u.login_name = ?1", nativeQuery = true )
	public String isUserExisit(String username);
	
	@Query(value = "SELECT u.login_name from USERS u where u.login_name == ?1 and u.password = ?2", nativeQuery = true )
	public String validateUser(String loginName, String password);

	@Query(value = "SELECT * from USERS u where u.login_name = ?1", nativeQuery = true )
	public Users getUserByLoginName(String loginName);

}
