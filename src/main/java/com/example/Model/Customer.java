package com.example.Model;

import javax.persistence.*;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;

	private String name;

	private String email;

	public Customer() {
	}
	
	public Customer(int customerId) {
		this.customerId = customerId;
		
	}

	public Customer(int customerId, String name, String email) {
		this.customerId = customerId;
		this.name = name;
		this.email = email;
	}

	

	public Customer(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
