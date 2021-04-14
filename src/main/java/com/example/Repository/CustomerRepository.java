package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
		
	@Query("SELECT COALESCE(MAX(customerId),0) FROM Customer")
	public int maxValue();

}
