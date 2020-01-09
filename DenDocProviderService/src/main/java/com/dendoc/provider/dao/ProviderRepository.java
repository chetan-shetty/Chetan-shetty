/**
 * 
 */
package com.dendoc.provider.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dendoc.provider.model.Provider;

/**
 * @author Chetan
 *
 */
public interface ProviderRepository extends JpaRepository<Provider, Long>{
	
	

}
