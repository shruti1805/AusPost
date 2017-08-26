package com.aus.post.io;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * 
 * AddressDBConnectivity - provides Repository for CRUD operations
 * 
 * @author Shruti Mahapatra
 *
 */

public interface AddressDBConnectivity extends CrudRepository<Address, String> {
	public List<Address> findByPostCode(int postcode);
	public List<Address> findBySuburb(String subUrb);
}
