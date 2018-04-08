package com.service;

import java.util.List;

import com.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);
	
	public void deleteCustomers(int id);
	

}
