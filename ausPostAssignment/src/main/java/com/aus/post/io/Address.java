package com.aus.post.io;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * Address is persistence Entity - database used apache derby
 * 
 * @author Shruti Mahapatra
 *
 */


@Entity
public class Address {
	
	/**
	 * @param Id
	 * @param postCode
	 * @param suburb
	 */
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	int postCode;
	String suburb;
	
	public Address(int id, int postCode, String suburb) {
		super();
		this.id = id;
		this.postCode = postCode;
		this.suburb = suburb;
	}

	public Address() {
	}

	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	public String getSuburb() {
		return suburb;
	}
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
}
