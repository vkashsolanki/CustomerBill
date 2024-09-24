package com.customer.bill.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.bill.dto.CustomerDto;
import com.customer.bill.entity.Customer;
import com.customer.bill.repository.CustomerRepository;
import com.customer.bill.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ModelMapper modelMapper;

	// @autowired or constructor we can make constructor both CustomerRepository and
	// ModelMapper inside single constructor
	/*
	 * public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper
	 * modelMapper){ this.customerRepository=customerRepository;
	 * this.modelMapper=modelMapper; }
	 */

	// craete customers

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		// Mapping DTO to Entity
		Customer customer = modelMapper.map(customerDto, Customer.class);
		// Save customer entity
		Customer saveCustomer = customerRepository.save(customer);
		// Will return mapping Entity to DTO
		return modelMapper.map(saveCustomer, CustomerDto.class);
	}

	// Find All Customers
	@Override
	public List<CustomerDto> getAllCustomers() {
		return customerRepository.findAll().stream().map(customers -> modelMapper.map(customers, CustomerDto.class))
				.collect(Collectors.toList());
	}

	// Find by id customers
	@Override
	public Optional<CustomerDto> getByIdCustomer(int customer_Id) {

		return customerRepository.findById(customer_Id).map(customer -> modelMapper.map(customer, CustomerDto.class));
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDtos) {

		Customer existingCustomers = customerRepository.findById(customerDtos.getCustomer_Id()).get();
		existingCustomers.setCustomer_Name(customerDtos.getCustomer_Name());
		existingCustomers.setCustomer_Address(customerDtos.getCustomer_Address());
		existingCustomers.setCompany_Name(customerDtos.getCompany_Name());
		existingCustomers.setSerial_Number(customerDtos.getSerial_Number());
		existingCustomers.setDescription(customerDtos.getDescription());
		existingCustomers.setQuantity(customerDtos.getQuantity());
		existingCustomers.setRate(customerDtos.getRate());
		existingCustomers.setAmount(customerDtos.getAmount());
		existingCustomers.setInvoice_Number(customerDtos.getInvoice_Number());
		existingCustomers.setInvoice_Date(customerDtos.getInvoice_Date());

		Customer updateCustomers = customerRepository.save(existingCustomers);
		return modelMapper.map(updateCustomers, CustomerDto.class);

	}

	@Override
	public String deleteById(int customer_Id) {
		customerRepository.deleteById(customer_Id);
		return "Customer-Bill are Deleted !..";
	}

}
/*
 * ||||||||||||||||||||||||| // Create All Customers
 * 
 * @Override public List<CustomerDto> createAllCustomer(CustomerDto
 * customerDtos) {
 * 
 * Customer allCustomer = modelMapper.map(customerDtos, Customer.class);
 * Customer save = customerRepository.save(allCustomer);
 * 
 * return (List<CustomerDto>) modelMapper.map(save, CustomerDto.class); }
 */
