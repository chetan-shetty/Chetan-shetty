package com.dendoc.provider.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dendoc.provider.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
	
	@Query(value = "SELECT * from SERVICE s", nativeQuery = true )
	public List<Service> getServices();

}
