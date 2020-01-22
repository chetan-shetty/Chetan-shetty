/**
 * 
 */
package com.dendoc.client.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dendoc.client.model.Client;

/**
 * @author Chetan
 *
 */
public interface ClientRepository extends JpaRepository<Client, Long>{

}
