package com.aus.post.io;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * AddressController is Controller class which calls services mentioned and returns JSON response 
 * 
 * @author Shruti Mahapatra
 *
 */

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;

	@RequestMapping("/get/AllAddress")
	public List<Address> returnAllAddress(){
		return addressService.getAllAddresses();
	}	

	@RequestMapping("/get/AddressByPostcode/{postcode}")
	public List<Address> returnAddress(@PathVariable int postcode){
		return addressService.getAddressByPostcode(postcode);
	}

	@RequestMapping("/get/AddressBySuburb/{suburb}")
	public List<Address> returnAddressSuburb(@PathVariable String suburb){
		return addressService.getAddressBySuburb(suburb);
	}

	@RequestMapping(method= RequestMethod.POST,value="/addNewAddress")
	public String addNewAddress(@RequestBody Address address){
		String returnMessage = addressService.addNewAddress(address);
		return returnMessage;
	}
}
