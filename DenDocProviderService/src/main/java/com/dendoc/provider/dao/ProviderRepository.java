/**
 * 
 */
package com.dendoc.provider.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dendoc.provider.model.Provider;

/**
 * @author Chetan
 *
 */
public interface ProviderRepository extends JpaRepository<Provider, Long>{
	
	@Query(value = "select prd.* from provider prd , provider_insurance prdinc , provider_service prdsc , address adrs "
					+"where  prd.provider_id=prdinc.provider_id  and prd.provider_id = prdsc.provider_id and "
					+"prd.address_id =adrs.address_id and "
					+"prdsc.service_id =?1 and adrs.pincode = ?2 and prdinc.insurance_id = ?3 ", nativeQuery = true )
	public List<Provider> getProviderByAllDetails(long service_id ,long pincode ,long insurance_id);

	@Query(value = "select prd.* from provider prd , provider_service prdsc , address adrs "
			+"where  prd.provider_id = prdsc.provider_id and "
			+"prd.address_id =adrs.address_id and "
			+"prdsc.service_id =?1 and adrs.pincode = ?2 ", nativeQuery = true )
	public List<Provider> getProviderByAllDetailsWithoutInc(long service_id ,long pincode );
	
}
