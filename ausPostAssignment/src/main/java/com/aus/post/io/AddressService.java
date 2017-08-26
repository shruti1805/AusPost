package com.aus.post.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * AddressService provides service - to search, add postcode and suburb
 * 
 * @author Shruti Mahapatra
 *
 */

@Service
public class AddressService {
	
	@Autowired
	AddressDBConnectivity addressDBConnectivity;
	
	private List<Address> address = new ArrayList<> ();
	
	public List<Address> getAddress(){
	return address;	
	}
	
	public List<Address> getAllAddresses(){
		List<Address> address = new ArrayList<> ();
		addressDBConnectivity.findAll().forEach(address :: add);
		return address;	
		}
	
	public String addNewAddress(Address address) {
		
		List<Address> sentAddress = new ArrayList<> ();
		addressDBConnectivity.findByPostCode(address.postCode).forEach(sentAddress :: add);
		for(Address addressSuburb : sentAddress){
			if (addressSuburb.suburb.equals(address.suburb)){
				return "Entry Already exists for the entered Postcode and Suburb combination";
			}
		}
		
		addressDBConnectivity.save(address);	
		return "Added Successfully";
	}

	public List<Address> getAddressByPostcode(int postcode){
		List<Address> address = new ArrayList<> ();
		addressDBConnectivity.findByPostCode(postcode).forEach(address :: add);
		return address;	
	}
	
	public List<Address> getAddressBySuburb(String suburb){
		List<Address> address = new ArrayList<> ();
		addressDBConnectivity.findBySuburb(suburb).forEach(address :: add);
		return address;	
	}
}
