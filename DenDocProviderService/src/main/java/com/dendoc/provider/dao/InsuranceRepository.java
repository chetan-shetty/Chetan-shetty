package com.dendoc.provider.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dendoc.provider.model.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
	
	@Query(value = "SELECT * from INSURANCE i", nativeQuery = true )
	public List<Insurance> getInsurances();
}
