package com.customer.bill.service;

import java.util.List;
import java.util.Optional;

import com.customer.bill.dto.CustomerDto;

public interface CustomerService {
	
	public CustomerDto createCustomer(CustomerDto customerDto);
	public List<CustomerDto> getAllCustomers();
	public Optional<CustomerDto> getByIdCustomer(int customer_Id);
	public CustomerDto updateCustomer(CustomerDto customerDtos);
	public String deleteById(int customer_Id);
	
	 
	 
	 
	 
	 //public List<CustomerDto> createAllCustomer(CustomerDto customerDtos);
	
	

}
